package com.training.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmazonPurchase {

    public static void main(String... args) {
        int[] connection = determineRecommendation("ABC", new String[]
                {
                        "first:ABC",
                        "first:HIJ",
                        "sec:HIJ",
                        "sec:KLM",
                        "third:NOP",
                        "fourth:ABC",
                        "fourth:QRS",
                        "first:DEF",
                        "fifth:KLM",
                        "fifth:TUV"});
        System.out.println(connection[0] + " " + connection[1]);
    }

    static int[] determineRecommendation(String itemId, String[] purchases) {

        if (null == itemId || "".equals(itemId.trim())) {
            return new int[]{0, 0};
        }

        if (null == purchases || purchases.length == 0) {
            return new int[]{0, 0};
        }

        Map<String, List<String>> purchaseMap = new HashMap<String, List<String>>();
        for (String purchase : purchases) {
            String[] purchaseSplit = purchase.split(":");
            String customer = purchaseSplit[0].trim();
            String item = purchaseSplit[1].trim();
            if (null == purchaseMap.get(customer)) {
                purchaseMap.put(customer, new ArrayList<String>());
            }
            purchaseMap.get(customer).add(item);
        }

        Set<String> strongConnection = new HashSet<String>();
        Set<String> firstWeakConnection = new HashSet<String>();
        Set<String> secondWeakConnection = new HashSet<String>();

        for (Map.Entry<String, List<String>> entry : purchaseMap.entrySet()) {
            if (entry.getValue().contains(itemId)) {
                strongConnection.addAll(entry.getValue());
            }
        }

        for (Map.Entry<String, List<String>> entry : purchaseMap.entrySet()) {
            if (!entry.getValue().contains(itemId)) {
                for (String s : entry.getValue()) {
                    if (strongConnection.contains(s)) {
                        firstWeakConnection.addAll(entry.getValue());
                        break;
                    }
                }
            }
        }

        for (Iterator<String> itr = firstWeakConnection.iterator(); itr.hasNext(); ) {
            String s = itr.next();
            if (strongConnection.contains(s)) {
                itr.remove();
            }
        }

        for (Map.Entry<String, List<String>> entry : purchaseMap.entrySet()) {
            if (!entry.getValue().contains(itemId)) {
                for (String s : entry.getValue()) {
                    if (firstWeakConnection.contains(s)) {
                        secondWeakConnection.addAll(entry.getValue());
                        break;
                    }
                }
            }
        }

        for (Iterator<String> itr = secondWeakConnection.iterator(); itr.hasNext(); ) {
            String s = itr.next();
            if (strongConnection.contains(s) || firstWeakConnection.contains(s)) {
                itr.remove();
            }
        }

        return new int[]{strongConnection.size() - 1, firstWeakConnection.size() + secondWeakConnection.size()};
    }
}
