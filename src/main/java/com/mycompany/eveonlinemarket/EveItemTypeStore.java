package com.mycompany.eveonlinemarket;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EveItemTypeStore {

    private static final String API_BASE_URL = "https://esi.evetech.net/latest";
    private static final String ALL_ITEMS_ENDPOINT = "/universe/types/";

    private static final Map<Integer, String> itemTypeMap = new HashMap<>();

    static {
        populateItemTypeMap();
    }

    private static void populateItemTypeMap() {
        OkHttpClient client = new OkHttpClient();

        String url = API_BASE_URL + ALL_ITEMS_ENDPOINT;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            JsonParser parser = new JsonParser();
            JsonArray itemsArray = parser.parse(responseBody).getAsJsonArray();

            for (JsonElement element : itemsArray) {
                JsonObject itemJson = element.getAsJsonObject();
                int typeId = itemJson.get("type_id").getAsInt();
                String itemName = itemJson.get("name").getAsString();

                // Check if item type is already present in the HashMap
                if (!itemTypeMap.containsKey(typeId)) {
                    itemTypeMap.put(typeId, itemName);
                }
            }

            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get item name by type ID.
     *
     * @param typeId the type ID of the item
     * @return the item name corresponding to the type ID, or null if not found
     */
    public static String getItemNameByTypeId(int typeId) {
        return itemTypeMap.get(typeId);
    }

    /**
     * Get type ID by item name.
     *
     * @param itemName the name of the item
     * @return the type ID corresponding to the item name, or null if not found
     */
    public static Integer getTypeIdByItemName(String itemName) {
        for (Map.Entry<Integer, String> entry : itemTypeMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(itemName)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
