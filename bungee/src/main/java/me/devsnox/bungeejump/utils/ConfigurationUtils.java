package me.devsnox.bungeejump.utils;

import net.md_5.bungee.config.Configuration;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationUtils {

    public static Map<String, Object> toMap(Configuration configuration) {
        Map<String, Object> map = new HashMap<>();

        configuration.getKeys().forEach(name -> map.put(name, configuration.get(name)));

        return map;
    }
}
