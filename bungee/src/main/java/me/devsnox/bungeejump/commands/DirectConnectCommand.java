package me.devsnox.bungeejump.commands;

import me.devsnox.bungeejump.WarpManager;
import me.devsnox.bungeejump.utils.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class DirectConnectCommand extends Command {

    private WarpManager warpManager;

    public DirectConnectCommand(final String name, WarpManager warpManager) {
        super(name);
        this.warpManager = warpManager;
    }

    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("bungeejump.directconnect")) {
            if (sender instanceof ProxiedPlayer) {
                this.warpManager.teleportPlayer((ProxiedPlayer) sender, this.getName());
            } else {
                sender.sendMessage(Messages.CONSOLE_MESSAGE.get().asComponent());
            }
        } else {
            sender.sendMessage(Messages.NO_PERMISSIONS.get().asComponent());
        }
    }
}
