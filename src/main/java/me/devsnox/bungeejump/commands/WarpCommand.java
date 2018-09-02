package me.devsnox.bungeejump.commands;

import me.devsnox.bungeejump.configuration.JumpConfiguration;
import me.devsnox.bungeejump.utils.Colors;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WarpCommand extends Command {

    private JumpConfiguration jumpConfiguration;

    public WarpCommand(JumpConfiguration jumpConfiguration, String name) {
        super(name);
        this.jumpConfiguration = jumpConfiguration;
    }

    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission("bungeejump.connect")) {
            if(args.length == 0) {
                sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getServerMessage()));
            } else {
                if(sender instanceof ProxiedPlayer) {
                    if(ProxyServer.getInstance().getServerInfo(args[0]) != null) {
                        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) sender;
                        if(proxiedPlayer.getServer().getInfo().getName().equalsIgnoreCase(args[0])) {
                            sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getAlreadyConnected().replaceAll("%server%", args[0])));
                            return;
                        } else {
                            ((ProxiedPlayer) sender).connect(ProxyServer.getInstance().getServerInfo(args[0]));
                            sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getWarpedToServer().replaceAll("%server%", args[0])));
                            return;
                        }
                    } else {
                        sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getServerNotExists().replaceAll("%server%", args[0])));
                        return;
                    }
                } else {
                    sender.sendMessage(Colors.convertStringWithColors(this.jumpConfiguration.getConsoleMessage()));
                    return;
                }
            }
        } else {
            sender.sendMessage(Colors.convertStringWithColors(jumpConfiguration.getNoPermissions()));
            return;
        }
    }
}
