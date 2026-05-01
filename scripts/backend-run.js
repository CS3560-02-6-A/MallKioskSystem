const path = require('path');
const { spawnSync } = require('child_process');

const rootDir = path.resolve(__dirname, '..');
const classpath = [
  path.join(rootDir, 'out'),
  path.join(rootDir, 'lib', 'mysql-connector-j-9.7.0.jar'),
].join(path.delimiter);

const args = ['-cp', classpath, 'src.app.Main'];
const result = spawnSync('java', args, {
  cwd: rootDir,
  stdio: 'inherit',
  shell: false,
});

if (result.error) {
  console.error(result.error.message);
  process.exit(1);
}

process.exit(result.status ?? 0);
