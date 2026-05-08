package src.app;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import src.dao.storeDAO;
import src.model.StoreItem;
import src.model.Receipt;
import src.service.mallKioskService;


public class KioskServer
{
   
    public static void main(String[] args) throws Exception
    {
        mallKioskService service = new mallKioskService();
        storeDAO myStoreDAO = new storeDAO();
        String today = LocalDate.now()
            .getDayOfWeek()
            .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // GET /api/items?gender=women&occasion=casual  — returns full filtered catalog
        server.createContext("/api/items", exchange -> {
            addCors(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            String query = exchange.getRequestURI().getQuery();
            String gender = null, occasion = null;

            if (query != null) {
                for (String param : query.split("&")) {
                    String[] kv = param.split("=", 2);
                    if (kv.length == 2) {
                        if (kv[0].equals("gender"))   gender   = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                        if (kv[0].equals("occasion")) occasion = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                    }
                }
            }

            // treat "neutral" / "no preference" as no filter
            if (gender != null && gender.equalsIgnoreCase("neutral")) {
                gender = null;
            }
            if (occasion != null && occasion.equalsIgnoreCase("no preference")) {
                occasion = null;
            }

            List<StoreItem> items = service.getItemsFullDataWithFilters(gender, occasion);
            String json = outfitToJson(items, myStoreDAO, today);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] bytes = json.getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.getResponseBody().close();
        });

        // GET /api/outfit?gender=women&occasion=casual
        server.createContext("/api/outfit", exchange -> {
            addCors(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            String query = exchange.getRequestURI().getQuery();
            String gender = null, occasion = null;

            if (query != null) {
                for (String param : query.split("&")) {
                    String[] kv = param.split("=", 2);
                    if (kv.length == 2) {
                        if (kv[0].equals("gender"))   gender   = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                        if (kv[0].equals("occasion")) occasion = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                    }
                }
            }

            // treat "neutral" / "no preference" as no filter
            if (gender != null && gender.equalsIgnoreCase("neutral")) {
                gender = null;
            }
            if (occasion != null && occasion.equalsIgnoreCase("no preference")) {
                occasion = null;
            }

            List<StoreItem> outfit = service.generateOutfit(gender, occasion);
            String json = outfitToJson(outfit, myStoreDAO, today);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] bytes = json.getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.getResponseBody().close();
        });

        // GET /api/receipt?gender=women&occasion=casual
        server.createContext("/api/receipt", exchange -> {
            addCors(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            String query = exchange.getRequestURI().getQuery();
            String gender = null, occasion = null;
            if (query != null) {
                for (String param : query.split("&")) {
                    String[] kv = param.split("=", 2);
                    if (kv.length == 2) {
                        if (kv[0].equals("gender"))   gender   = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                        if (kv[0].equals("occasion")) occasion = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                    }
                }
            }

                        // treat "neutral" / "no preference" as no filter
            if (gender != null && gender.equalsIgnoreCase("neutral")) {
                gender = null;
            }
            if (occasion != null && occasion.equalsIgnoreCase("no preference")) {
                occasion = null;
            }

            List<StoreItem> outfit = service.generateOutfit(gender, occasion);
            Receipt receipt = service.generateReceipt(outfit);

            String json = "{\"total\":" + receipt.getTotalPrice() +
                          ",\"generatedAt\":\"" + receipt.getGeneratedAt() + "\"" +
                          ",\"items\":" + outfitToJson(outfit, myStoreDAO, today) + "}";

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] bytes = json.getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.getResponseBody().close();
        });

        server.start();
        System.out.println("Kiosk API running at http://localhost:8080");
    }

    private static void addCors(HttpExchange exchange)
    {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
    }

    private static String outfitToJson(List<StoreItem> items, storeDAO dao, String today)
    {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < items.size(); i++) {
            StoreItem it = items.get(i);
            if (i > 0) sb.append(",");

            String storeHours = "";
            String[] times = dao.getHoursForStoreAndDay(it.getStoreId(), today);
            if (times != null) {
                storeHours = formatTime(times[0]) + " - " + formatTime(times[1]);
            }

            sb.append("{")
              .append("\"itemId\":").append(it.getItemId()).append(",")
              .append("\"name\":\"").append(it.getItemName()).append("\",")
              .append("\"type\":\"").append(it.getItemType()).append("\",")
              .append("\"color\":\"").append(it.getItemColor()).append("\",")
              .append("\"gender\":\"").append(it.getGender() != null ? it.getGender() : "").append("\",")
              .append("\"price\":").append(it.getPrice()).append(",")
              .append("\"storeId\":").append(it.getStoreId()).append(",")
              .append("\"storeName\":\"").append(it.getStoreName() != null ? it.getStoreName() : "").append("\",")
              .append("\"aisle\":\"").append(it.getAisle()).append("\",")
              .append("\"storeHours\":\"").append(storeHours).append("\"")
              .append("}");
        }
        sb.append("]");
        return sb.toString();
    }

    private static String formatTime(String sqlTime)
    {
        if (sqlTime == null || sqlTime.isEmpty()) return "";
        String[] parts = sqlTime.split(":");
        int hour   = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String period = hour < 12 ? "AM" : "PM";
        int displayHour = hour % 12;
        if (displayHour == 0) displayHour = 12;
        return displayHour + ":" + String.format("%02d", minute) + period;
    }
}