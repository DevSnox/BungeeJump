package me.devsnox.bungeejump.configuration;

import me.devsnox.bungeejump.utils.ConfigurationUtils;
import me.devsnox.bungeejump.utils.Messages;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    private File dataFolder;

    public ConfigurationManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    public void loadMainConfiguration() throws IOException {
        final Configuration configuration = YamlConfiguration.getProvider(YamlConfiguration.class)
                .load(new File(this.dataFolder + File.separator + "config.yml"));

        Configuration serverSection = configuration.getSection("servers");

        Map<String, ConfigurationServerData> servers = new HashMap<>();

        serverSection.getKeys().forEach(name -> servers.put(name, new ConfigurationServerData(name, ConfigurationUtils.toMap(serverSection.getSection(name)))));

        ConfigurationData.setServers(servers);
    }

    public void loadMessageConfiguration() throws IOException {

        final Configuration configuration = YamlConfiguration.getProvider(YamlConfiguration.class)
                .load(new File(this.dataFolder + File.separator + "messages.yml"));

        final boolean prefixEnabled = configuration.getBoolean("prefix-enabled");

        for (final Messages message : Messages.values()) {
            final StringBuilder stringBuilder
                    = new StringBuilder(ChatColor.translateAlternateColorCodes('&', configuration.getString(message.formatedName())));

            if (message != Messages.PREFIX && prefixEnabled) {
                stringBuilder.insert(0, Messages.PREFIX.get().asComponent());
            } else {
                stringBuilder.append(ChatColor.RESET + " ");
            }

            Messages.valueOf(message.name()).set(stringBuilder.toString());
        }
    }
}
