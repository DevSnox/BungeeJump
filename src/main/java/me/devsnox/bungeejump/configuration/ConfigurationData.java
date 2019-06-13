package me.devsnox.bungeejump.configuration;

import java.util.Map;

public class ConfigurationData {

    private static Map<String, ConfigurationServerData> serverConfigurations;

    public static Map<String, ConfigurationServerData> getServers() {
        return serverConfigurations;
    }

    public static void setServers(Map<String, ConfigurationServerData> serverConfigurations) {
        ConfigurationData.serverConfigurations = serverConfigurations;
    }
}
