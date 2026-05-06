# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

"Outfit Curator" — an interactive mall kiosk that generates outfit recommendations based on a shopper's gender and occasion preferences, with real-time inventory and receipt generation.

## Architecture

This is a **decoupled full-stack app**: a React/Vite frontend talks to a raw Java HTTP server (no Spring) that queries MySQL via hand-written DAOs.

### Frontend (`/frontend/`)
React 19 + Vite SPA with React Router v7. Five pages follow a linear wizard flow:

```
/ → /gender → /occasion → /builder → /receipt
```

Feature modules live in `src/features/`: `onboarding`, `outfit-curator`, `receipt`. Shared UI components are in `src/components/`. Styling uses a centralized theme system under `src/theme/`.

### Backend (`/src/`)
Plain Java using `com.sun.net.httpserver` on **port 8080**. No Maven/Gradle — dependencies are jars in `/lib/`.

Layers:
- `app/` — `KioskServer.java` (HTTP entry point), `Main.java` (CLI testing)
- `service/mallKioskService.java` — orchestrates business logic
- `dao/` — direct JDBC queries against MySQL
- `model/` — domain objects (`StoreItem`, `Outfit`, `Receipt`, `Session`, etc.)
- `util/Constants.java` — shared constants

**API endpoints served by KioskServer:**
- `GET /api/outfit?gender=X&occasion=Y` — returns a randomly generated outfit JSON
- `GET /api/receipt?gender=X&occasion=Y` — returns receipt with item prices and store locations

### Database (MySQL)
Key tables: `items_tbl` (clothing catalog), `inventory_tbl` (per-store stock/price/aisle), `stores_tbl`, `receipt_tbl`, `session_tbl`, `storeHours_tbl`.

## Setup

1. **Database:**
   ```bash
   mysql -u root -p mall_kiosk_system < database/fullKioskTableData.sql  # sample data
   ```
2. **Configure DB connection:** copy `db.properties.example` → `db.properties` and fill in credentials.

3. **Backend:** compile and run `src/app/KioskServer.java` manually with `javac`/`java` (no build tool).

4. **Frontend:**
   ```bash
   cd frontend
   npm install
   npm run dev      # dev server
   ```

## Frontend Commands

All run from `/frontend/`:

| Command | Purpose |
|---|---|
| `npm run dev` | Start Vite dev server |
| `npm run build` | Production build |
| `npm run preview` | Preview production build |
| `npm run lint` | Run ESLint |

## Key Design Patterns

**Outfit generation flow:**
1. Frontend sends gender + occasion to `/api/outfit`
2. `mallKioskService` calls `storeItemDAO.getItemsFullDataWithFilters()` to query matching inventory
3. `outfitGenerator.java` partitions results into categories (top, bottom, shoes, accessories) and randomly picks one per category
4. Outfit is serialized to JSON and returned

**No backend framework** — `KioskServer.java` manually routes requests, parses query params, and writes JSON responses. When adding endpoints, follow the existing handler pattern in that file.

**Frontend fetches backend** at `http://localhost:8080`. The Vite dev server does not proxy — both must be running simultaneously.
