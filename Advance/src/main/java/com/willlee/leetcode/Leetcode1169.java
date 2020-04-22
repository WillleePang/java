package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Set<Integer> delSet = new HashSet<Integer>();
        HashMap<String, ArrayList<TransactionInfo>> dataMap = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            TransactionInfo info = new TransactionInfo(i, transactions[i]);
            if (info.amount > 1000) {
                delSet.add(i);
            }
            if (!dataMap.containsKey(info.name)) {
                dataMap.put(info.name, new ArrayList<TransactionInfo>());

            } else {
                ArrayList<TransactionInfo> list = dataMap.get(info.name);
                for (TransactionInfo t : list) {
                    if (!t.city.equals(info.city) && Math.abs(t.time - info.time) <= 60) {
                        delSet.add(t.idx);
                        delSet.add(info.idx);
                    }
                }
            }
            dataMap.get(info.name).add(info);
        }

        List<String> ansList = new ArrayList<String>();
        for (Integer idx : delSet) {
            ansList.add(transactions[idx]);
        }
        return ansList;
    }
}

class TransactionInfo {
    int idx;
    String name;
    int time;
    int amount;
    String city;

    public TransactionInfo(int idx, String str) {
        String[] arr = str.split(",");
        this.idx = idx;
        this.name = arr[0];
        this.time = Integer.parseInt(arr[1]);
        this.amount = Integer.parseInt(arr[2]);
        this.city = arr[3];
    }
}