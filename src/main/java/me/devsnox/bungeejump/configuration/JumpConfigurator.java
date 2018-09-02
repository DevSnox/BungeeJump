package me.devsnox.bungeejump.configuration;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class JumpConfigurator {

    private File config;
    private ConfigurationProvider configurationProvider;
    private Configuration configuration;

    private JumpConfiguration jumpConfiguration;

    public JumpConfigurator() {
        this.config = new File("plugins" + File.separator + "BungeeJump" + File.separator + "config.yml");
        this.configurationProvider = YamlConfiguration.getProvider(YamlConfiguration.class);

        try {
            this.configuration = this.configurationProvider.load(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String prefix = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("prefix") + "§r ");
        String noPermissions = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("no-permissions"));
        String consoleMessage = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("console-message"));
        String listOfServers = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("list-of-servers"));
        String warpedToServer = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("warped-to-server"));
        String serverMessage = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("server-message"));
        String serverNotExists = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("server-not-exists"));
        String alreadyConnected = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("already-connected"));

        if(configuration.getBoolean("prefix-enabled")) {
            noPermissions = prefix + noPermissions;
            consoleMessage = prefix + consoleMessage;
            listOfServers = prefix + listOfServers;
            warpedToServer= prefix + warpedToServer;
            serverMessage = prefix + serverMessage;
            serverNotExists = prefix + serverNotExists;
            alreadyConnected = prefix + alreadyConnected;
        }

        this.jumpConfiguration = new JumpConfiguration(prefix, noPermissions, consoleMessage, serverMessage, warpedToServer, listOfServers, serverNotExists, alreadyConnected);
    }

    public JumpConfiguration getJumpConfiguration() {
        return jumpConfiguration;
    }
}
