package com.mycompany.eveonlinemarket;


import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Fetcher {
    HashMap<String, ArrayList<Item>> marche =getAllItemTypes();
    HashMap<String,Itemtype> strname= new HashMap<>();
    String region;

    int system = 0;

    private static final String API_BASE_URL = "https://esi.evetech.net/latest";
    private static final String MARKET_PRICES_ENDPOINT = "/markets/{region_id}/orders/";
    private static final String ALL_ITEMS_ENDPOINT = "/universe/types/";

    public Fetcher(int system) {
        this.system = system;
    }
    public Fetcher(String region) {
        this.region = region;
    }

    private HashMap<String, ArrayList<Item>> getAllItemTypes() {
        OkHttpClient client = new OkHttpClient();
        HashMap<String, ArrayList<Item>> marche = new HashMap<>();

        String allItemsUrl = API_BASE_URL + ALL_ITEMS_ENDPOINT;

        Request request = new Request.Builder()
                .url(allItemsUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();
            JsonParser parser = new JsonParser();
            JsonArray itemsArray = parser.parse(response.body().string()).getAsJsonArray();

            for (JsonElement element : itemsArray) {
                JsonObject itemJson = element.getAsJsonObject();
                String itemType = itemJson.get("name").getAsString();
                int typeId = itemJson.get("type_id").getAsInt();
                String itemName = itemJson.get("name").getAsString();

                Itemtype item = new Itemtype(typeId, itemName);

                if (!marche.containsKey(item)) {
                    marche.put(item.getName(), new ArrayList<>());
                    strname.put(Integer.toString(item.getTypeId()),item);
                }

            }

            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return marche;
    }



    private void marketFetcher(String region){
        OkHttpClient client = new OkHttpClient();

        // Construct the URL for fetching market prices in the FORGE region
        String url = API_BASE_URL + MARKET_PRICES_ENDPOINT.replace("{region_id}", region);

        // Create a request
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            // Execute the request
            Response response = client.newCall(request).execute();

            // Parse the response JSON
            JsonParser parser = new JsonParser();
            JsonArray ordersArray = parser.parse(response.body().string()).getAsJsonArray();

            // Print out the prices
            for (JsonElement element : ordersArray) {

                JsonObject order = element.getAsJsonObject();

                Item item = new Item(order.get("duration").getAsInt(), order.get("is_buy_order").getAsBoolean(),order.get("issued").getAsInt(), order.get("location_id").getAsLong(), order.get("min_volume").getAsInt(), order.get("order_id").getAsLong(), order.get("price").getAsDouble(), order.get("range").getAsString(), order.get("system_id").getAsInt(), order.get("type_id").getAsInt(), order.get("volume_remain").getAsInt(), order.get("volume_total").getAsInt());

                if(system!=0 && item.getSystemId()==system){
                    this.marche.get(item.getTypeId()).add(item);
                }
                else{
                    this.marche.get(item.getTypeId()).add(item);
                }
            }

            // Close the response
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
