package com.mycompany.eveonlinemarket;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketFetcher {

    private static final String API_BASE_URL = "https://esi.evetech.net/latest";
    private static final String MARKET_PRICES_ENDPOINT = "/markets/{region_id}/orders/";

    protected ArrayList<Item> buyOrders = new ArrayList<>();
    protected ArrayList<Item> sellOrders = new ArrayList<>();


    public MarketFetcher(){
        this.Fetch();
    }

    public void Fetch() {
        OkHttpClient client = new OkHttpClient();

        // Replace {region_id} with the ID of the FORGE region
        String forgeRegionId = "10000002"; // FORGE region ID

        // Construct the URL for fetching market prices in the FORGE region
        String url = API_BASE_URL + MARKET_PRICES_ENDPOINT.replace("{region_id}", forgeRegionId);


        // Create lists to store buy orders and sell orders

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

            // Iterate through the orders
            for (JsonElement element : ordersArray) {
                JsonObject order = element.getAsJsonObject();

                // Extract order details
                int duration = order.get("duration").getAsInt();
                boolean isBuyOrder = order.get("is_buy_order").getAsBoolean();
                String issued = order.get("issued").getAsString();
                long locationId = order.get("location_id").getAsLong();
                int minVolume = order.get("min_volume").getAsInt();
                long orderId = order.get("order_id").getAsLong();
                double price = order.get("price").getAsDouble();
                String range = order.get("range").getAsString();
                int systemId = order.get("system_id").getAsInt();
                int typeId = order.get("type_id").getAsInt();
                int volumeRemain = order.get("volume_remain").getAsInt();
                int volumeTotal = order.get("volume_total").getAsInt();

                // Create Item object
                Item item = new Item(EveItemTypeStore.getItemNameByTypeId(typeId),duration, isBuyOrder, issued, locationId, minVolume, orderId, price, range, systemId, typeId, volumeRemain, volumeTotal);

                // Add to appropriate list
                if (isBuyOrder) {
                    buyOrders.add(item);
                } else {
                    sellOrders.add(item);
                }
            }

            // Close the response
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // At this point, buyOrders and sellOrders ArrayLists are populated
        // You can use these ArrayLists as needed
    }

    public void getBuyOrders(){
        for(Item i: buyOrders){
            System.out.println(i);
        }
    }

    public void getSellOrders(){
        for(Item i: sellOrders){
            System.out.println(i);
        }
    }
}