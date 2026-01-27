package com.vn2bs.common.utils;

public class NameUtil {
    public static String toFileNameSafe(String input, String... args) {
        if (args == null || args.length == 0) {
            return input.replaceAll("[^a-zA-Z0-9\\.\\-]", "-");
        }

        String[] params = new String[args.length + 1];
        params[0] = input;
        for (int i = 1; i < params.length; i++) {
            params[i] = args[i - 1];
        }
        return String.join("-", params).replaceAll("[^a-zA-Z0-9\\.\\-]", "-");
    }

    public static String toBucketNameSafe(String input, String... args) {
        if (args == null || args.length == 0) {
            return input.toLowerCase().replaceAll("[^a-z0-9\\-]", "-");
        }
        String[] params = new String[args.length + 1];
        params[0] = input;
        for (int i = 1; i < params.length; i++) {
            params[i] = args[i - 1];
        }
        return String.join("-", params).toLowerCase().replaceAll("[^a-z0-9\\-]", "-");
    }
}
