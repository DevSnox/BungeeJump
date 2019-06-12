package me.devsnox.bungeejump.commands;

import me.devsnox.bungeejump.utils.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class DirectConnectCommand extends Command {

    public DirectConnectCommand(final String name) {
        super(name);
    }

    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("bungeejump.directconnect")) {
            if (sender instanceof ProxiedPlayer) {
                ProxiedPlayer proxiedPlayer = (ProxiedPlayer) sender;

                if (proxiedPlayer.getServer().getInfo().getName().equalsIgnoreCase(args[0])) {
                    sender.sendMessage(Messages.ALREADY_CONNECTED.get().replace("%server%", args[0]).asComponent());
                    return;
                }

                ((ProxiedPlayer) sender).connect(ProxyServer.getInstance().getServerInfo(args[0]));
                sender.sendMessage(Messages.WARPED_TO_SERVER.get().replace("%server%", args[0]).asComponent());

            } else {
                sender.sendMessage(Messages.CONSOLE_MESSAGE.get().asComponent());
            }
        } else {
            sender.sendMessage(Messages.NO_PERMISSIONS.get().asComponent());
        }
    }
}
