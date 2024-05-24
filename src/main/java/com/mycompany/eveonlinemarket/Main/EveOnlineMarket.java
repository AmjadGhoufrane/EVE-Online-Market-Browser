/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eveonlinemarket.Main;

import com.mycompany.eveonlinemarket.serverInteractions.MarketFetcher;

public class EveOnlineMarket {
    public static void main(String[] args) {
        MarketFetcher MarketData = new MarketFetcher();
        MarketData.getSellOrders();
    }
}
