const fs = require('fs');
const path = require('path');
const { spawnSync } = require('child_process');

const rootDir = path.resolve(__dirname, '..');
const srcDir = path.join(rootDir, 'src');
const outDir = path.join(rootDir, 'out');
const mysqlJar = path.join(rootDir, 'lib', 'mysql-connector-j-9.7.0.jar');

function collectJavaFiles(dir) {
  const entries = fs.readdirSync(dir, { withFileTypes: true });
  const files = [];

  for (const entry of entries) {
    const fullPath = path.join(dir, entry.name);
    if (entry.isDirectory()) {
      files.push(...collectJavaFiles(fullPath));
    } else if (entry.isFile() && entry.name.endsWith('.java')) {
      files.push(fullPath);
    }
  }

  return files;
}

const javaFiles = collectJavaFiles(srcDir);
if (javaFiles.length === 0) {
  console.error('No Java source files found in src/.');
  process.exit(1);
}

if (!fs.existsSync(outDir)) {
  fs.mkdirSync(outDir, { recursive: true });
}

const classpath = mysqlJar;
const args = ['-cp', classpath, '-d', outDir, ...javaFiles];

const result = spawnSync('javac', args, {
  cwd: rootDir,
  stdio: 'inherit',
  shell: false,
});

if (result.error) {
  console.error(result.error.message);
  process.exit(1);
}

process.exit(result.status ?? 0);
