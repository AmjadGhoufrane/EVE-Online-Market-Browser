/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eveonlinemarket;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class EveOnlineMarket {

    private static final String API_BASE_URL = "https://esi.evetech.net/latest";
    private static final String MARKET_PRICES_ENDPOINT = "/markets/{region_id}/orders/";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        // Replace {region_id} with the ID of the FORGE region
        String forgeRegionId = "10000002"; // FORGE region ID

        // Construct the URL for fetching market prices in the FORGE region
        String url = API_BASE_URL + MARKET_PRICES_ENDPOINT.replace("{region_id}", forgeRegionId);

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
                String type = order.get("type_id").getAsString();
                double price = order.get("price").getAsDouble();
                System.out.println("Type: " + type + ", Price: " + price);
            }

            // Close the response
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
