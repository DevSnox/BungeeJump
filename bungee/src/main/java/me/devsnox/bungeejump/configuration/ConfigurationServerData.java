package me.devsnox.bungeejump.configuration;

import java.util.Map;

public class ConfigurationServerData {

    private String name;
    private Map<String, Object> configurations;

    public ConfigurationServerData(String name, Map<String, Object> configurations) {
        this.name = name;
        this.configurations = configurations;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getConfigurations() {
        return configurations;
    }
}
