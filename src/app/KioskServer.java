package src.app;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.List;
import src.model.StoreItem;
import src.model.Receipt;
import src.service.mallKioskService;


public class KioskServer
{
   
    public static void main(String[] args) throws Exception
    {
        mallKioskService service = new mallKioskService();

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
            String json = outfitToJson(items);

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
             for (StoreItem i : outfit) 
        {
            System.out.println(
               "Name: " + i.getItemName() +
            " | Type: " + i.getItemType() +
            " | Color: " + i.getItemColor() +
            " | Gender: " + i.getGender() +
            " | Occasion: " + i.getOccasion() +
            " | StoreID: " + i.getStoreId() +
            " | ItemID: " + i.getItemId() +
            " | Price: $" + i.getPrice() +
            " | InStock: " + i.isInStock() +
            " | Aisle: " + i.getAisle()
            );
        }
            String json = outfitToJson(outfit);

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
                          ",\"items\":" + outfitToJson(outfit) + "}";

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

    private static String outfitToJson(List<StoreItem> items)
    {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < items.size(); i++) {
            StoreItem it = items.get(i);
            if (i > 0) sb.append(",");
            sb.append("{")
              .append("\"itemId\":").append(it.getItemId()).append(",")
              .append("\"name\":\"").append(it.getItemName()).append("\",")
              .append("\"type\":\"").append(it.getItemType()).append("\",")
              .append("\"color\":\"").append(it.getItemColor()).append("\",")
              .append("\"price\":").append(it.getPrice()).append(",")
              .append("\"storeId\":").append(it.getStoreId()).append(",")
              .append("\"aisle\":\"").append(it.getAisle()).append("\"")
              .append("}");
        }
        sb.append("]");
        return sb.toString();
    }
}