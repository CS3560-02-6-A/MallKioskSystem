<div align="center">

# Outfit Curator

**CS 3560.01 — Object-Oriented Progrmming**

</div>

---

## Team members
- Shuvashree Basnet — [GitHub](https://github.com/shuvashreebasnet) | [LinkedIn]()
- Jeannette Ruiz — [GitHub](https://github.com/jeanrnette) | [LinkedIn]()
- Brooke Landry — [GitHub](https://github.com/BrookeWork) | [LinkedIn]()
- Anthony Corona — [GitHub](https://github.com/anthony6633) | [LinkedIn]()
- Thuy An Nguyen — [GitHub](https://github.com/) | [LinkedIn]()
- Chau Nguyen — [GitHub](https://github.com/Chau-Nguyen-Developer) | [LinkedIn]()

---

## Overview

The Mall Kiosk System is an interactive in-mall kiosk designed to enhance the shopping experience by helping users quickly discover complete outfits based on their needs.

Instead of browsing multiple stores manually, users can input simple preferences (such as gender and occasion) and receive a curated outfit along with store locations and pricing details.

This system bridges the gap between:
- the convenience of online shopping
- and the immediacy of in-store purchases

### Problem

Shopping in large malls is often:
- time-consuming
- overwhelming
- inefficient

Customers may visit multiple stores and still not find what they need. Online shopping, while convenient, introduces:
- shipping delays
- high return rates due to incorrect sizing

### Solution

The kiosk provides:
- Real-time inventory access across mall stores
- Outfit generation based on user preferences
- Guided shopping experience via a generated receipt

Users can:
- generate a complete outfit
- view item details and prices
- receive a receipt with store locations for easy navigation

---

## Features

### Shopper Features
- Select gender and occasion
- Generate a random outfit
- Swap or modify items in the outfit
- View price breakdown
- Receive a receipt with:
    - item names
    - prices
    - SKUs
    - store locations

### Store & Management Features
- Manage store inventory
- Add/remove items
- Update store hours
- Enable/disable store participation
- Maintain accurate pricing and availability

### System Features
- Centralized inventory database
- Outfit recommendation logic
- Real-time data consistency
- Receipt generation system
- Session tracking for users

---

## System Architecture

### Database Tables
Content

---

## Stakeholders
- **Shoppers** – primary users
- **Mall Management** – oversees system deployment
- **Store Management** – manages inventory and hours
- **IT Team** – maintains system reliability
- **Investors** – support development
- **Outlet Employees** – assist customers in-store

---

## Tech Stack

### Frontend

- React (Vite)
- JavaScript
- CSS (custom styling + theme system)

### Backend
- Java (OOP architecture)
- DAO pattern for database access

### Database
- SQL (relational schema)

---

## Resources

GitHub Repository: (https://github.com/CS3560-02-6-A)
Figma Designs: (https://www.figma.com/design/Dr3BZ3X85Rt1dMO2MRGL7A/CS3560_OutfitCurator?node-id=0-1&t=eSrnbFsuRPcvZAU2-1)



NOTES FOR RUNNING ON PC:
1. Start MySQL
2. Create database:
   CREATE DATABASE mall_kiosk_system;

3. Import schema and change user/password values in dao/databaseConnection:
   mysql -u root -p mall_kiosk_system < database/schema.sql

4. (Optional) Import data:
   mysql -u root -p mall_kiosk_system < database/fullKioskTableData.sql
   
-------------
Have two terminals open
In 1st terminal, cd to /MallKioskSystem/frontend and use
''npm install''
follow by
''npm run dev''

In the 2nd terminal:

Recompile HTTP Server with
javac -cp ".:src:./lib/mysql-connector-j-9.7.0.jar" $(find src -name "*.java")

Start the HTTP server
java -cp ".:src:./lib/mysql-connector-j-9.7.0.jar" src.app.KioskServer
-------------

---

## Complete Setup Guide

Follow these steps to set up and run the project from scratch on your machine.

### Prerequisites
- **Node.js** (v16 or higher) — for frontend
- **Java** (JDK 8 or higher) — for backend
- **MySQL Server** (v8.0 or higher) — for database

### Step 1: Create and Import the Database

#### On macOS/Linux:

1. Start MySQL:
   ```bash
   mysql -u root -p
   ```

2. Create the database:
   ```sql
   CREATE DATABASE mall_kiosk_system;
   EXIT;
   ```

3. Import the schema and data:
   ```bash
   mysql -u root -p mall_kiosk_system < database/fullKioskTableData.sql
   ```

#### On Windows:

1. Open Command Prompt or PowerShell

2. Start MySQL:
   ```powershell
   mysql -u root -p
   ```

3. Create the database:
   ```sql
   CREATE DATABASE mall_kiosk_system;
   EXIT;
   ```

4. Import the schema and data:
   ```powershell
   mysql -u root -p mall_kiosk_system < database\fullKioskTableData.sql
   ```

### Step 2: Configure Database Connection

The project uses credentials in `db.properties` to connect to MySQL. Update this file if your MySQL credentials differ:

```properties
db.url=jdbc:mysql://localhost:3306/mall_kiosk_system
db.user=root
db.password=YOUR_PASSWORD
```

### Step 3: Start the Backend (HTTP Server)

Open **Terminal 1** in the project root directory:

#### On macOS/Linux:
```bash
# Compile Java source files
javac -cp ".:src:./lib/mysql-connector-j-9.7.0.jar" $(find src -name "*.java")

# Start the HTTP server on port 8080
java -cp ".:src:./lib/mysql-connector-j-9.7.0.jar" src.app.KioskServer
```

#### On Windows:
```powershell
# Compile Java source files
javac -cp ".;src;.\lib\mysql-connector-j-9.7.0.jar" (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# Start the HTTP server on port 8080
java -cp ".;src;.\lib\mysql-connector-j-9.7.0.jar" src.app.KioskServer
```

You should see:
```
Kiosk API running at http://localhost:8080
```

### Step 4: Start the Frontend (React Development Server)

Open **Terminal 2** in the project root directory:

```bash
# Navigate to frontend directory
cd frontend

# Install dependencies (first time only)
npm install

# Start Vite dev server on port 5173
npm run dev
```

You should see:
```
VITE v[version] ready in [time] ms

➜  Local:   http://localhost:5173/
```

### Step 5: Access the Application

Open your browser and navigate to:
```
http://localhost:5173/
```

The application should now be running with the backend API on port 8080 and frontend on port 5173.

### Troubleshooting

**MySQL Connection Error:**
- Verify MySQL is running: `mysql -u root -p -e "SELECT 1"`
- Check `db.properties` has correct credentials
- Ensure `mall_kiosk_system` database exists: `mysql -u root -p -e "SHOW DATABASES"`

**Backend Won't Compile:**
- Ensure Java is installed: `java -version`
- Check all `.java` files compile with no errors

**Frontend Won't Start:**
- Clear npm cache: `npm cache clean --force`
- Delete `node_modules` and `package-lock.json`, then run `npm install` again
- Ensure Node.js is v16+: `node -v`

**Port Already in Use:**
- Backend port 8080: change port in `src/app/KioskServer.java` line 22
- Frontend port 5173: Vite will auto-increment if port is taken

---
