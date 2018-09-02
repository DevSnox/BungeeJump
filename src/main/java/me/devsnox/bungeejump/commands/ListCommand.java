package me.devsnox.bungeejump.commands;

import me.devsnox.bungeejump.configuration.JumpConfiguration;
import me.devsnox.bungeejump.utils.Colors;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

import java.util.Map;

public class ListCommand extends Command {

    private JumpConfiguration jumpConfiguration;

    public ListCommand(JumpConfiguration jumpConfiguration, String name) {
        super(name);
        this.jumpConfiguration = jumpConfiguration;
    }

    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission("bungeejump.list")) {
            String serverList = "none";

            Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();

            if(servers.size() > 0) {
                serverList = "";

                int count = 1;

                for(Map.Entry<String, ServerInfo> serverInfo : servers.entrySet()) {
                    if(count == servers.size()) {
                        serverList += serverInfo.getValue().getName();
                    } else {
                        serverList += serverInfo.getValue().getName() + ", ";
                    }
                    count++;
                }
            }

            sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getListOfServers().replaceAll("%servers%", serverList)));
        }
    }
}
