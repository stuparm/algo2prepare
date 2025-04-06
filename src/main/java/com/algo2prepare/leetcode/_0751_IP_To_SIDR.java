package com.algo2prepare.leetcode;

import java.util.List;

public class _0751_IP_To_SIDR implements Task {

    @Override
    public boolean status() { return false; }

    @Override
    public String name() { return "IP to CIDR"; }

    @Override
    public int id() { return 751; }



    public List<String> ipToCIDR(String ip, int n) {

        // Convert the IP address to a long integer
        long ipLong = ipToLong(ip);


        long[] candidates = new long[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = ipLong + i;
        }

        for (long candidate : candidates) {
            System.out.println(candidate);
        }

        return null;
    }

    public long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(String.format("%03d", Integer.parseInt(parts[i])));
        }
        String ipLongStr = sb.toString();

        return Long.parseLong(ipLongStr);
    }

    public static void main(String[] args) {
        _0751_IP_To_SIDR obj = new _0751_IP_To_SIDR();
        obj.ipToCIDR("117.145.102.62", 8);
        System.out.println();


    }

}
