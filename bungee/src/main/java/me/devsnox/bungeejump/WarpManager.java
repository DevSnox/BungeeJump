package me.devsnox.bungeejump;

import me.devsnox.bungeejump.configuration.ConfigurationData;
import me.devsnox.bungeejump.configuration.ConfigurationServerData;
import me.devsnox.bungeejump.utils.Messages;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Map;

public class WarpManager {

    public void teleportPlayer(ProxiedPlayer player, String server) {
        if (player.getServer().getInfo().getName().equalsIgnoreCase(server)) {
            player.sendMessage(Messages.ALREADY_CONNECTED.get().replace("%server%", server).asComponent());
            return;
        }

        Map<String, ConfigurationServerData> servers = ConfigurationData.getServers();
        boolean value = false;

        if (servers.containsKey(server)) {
            value = ((Boolean) servers.get(server).getConfigurations().get("permission-join"));
        } else {
            value = ((Boolean) servers.get("default").getConfigurations().get("permission-join"));
        }

        if (value && !player.hasPermission("bungeejump.join." + server)) {
            player.sendMessage(Messages.NO_JOIN_PERMISSIONS.get().replace("%server%", server).asComponent());
            return;
        }

        player.connect(ProxyServer.getInstance().getServerInfo(server));
        player.sendMessage(Messages.WARPED_TO_SERVER.get().replace("%server%", server).asComponent());
    }
}
