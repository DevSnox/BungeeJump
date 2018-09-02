/*
 * Copyright (C) 2018 Yasin Dalal (DevSnox)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.devsnox.bungeejump.commands;

import me.devsnox.bungeejump.utils.Colors;
import me.devsnox.bungeejump.utils.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * @author Yasin Dalal (DevSnox)
 * Created by Yasin Dalal (DevSnox) on 02.05.2018 00:00.
 */
public final class WarpCommand extends Command {

    public WarpCommand(final String name) {
        super(name);
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("bungeejump.connect")) {
            if (args.length == 0) {
                sender.sendMessage(Colors.convertStringWithColors(Messages.SERVER_MESSAGE.asString()));
            } else {
                if (sender instanceof ProxiedPlayer) {
                    if (ProxyServer.getInstance().getServerInfo(args[0]) != null) {
                        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) sender;
                        if (proxiedPlayer.getServer().getInfo().getName().equalsIgnoreCase(args[0])) {
                            sender.sendMessage(Colors.convertStringWithColors(Messages.ALREADY_CONNECTED.asString().replaceAll("%server%", args[0])));
                            return;
                        } else {
                            ((ProxiedPlayer) sender).connect(ProxyServer.getInstance().getServerInfo(args[0]));
                            sender.sendMessage(Colors.convertStringWithColors(Messages.WARPED_TO_SERVER.asString().replaceAll("%server%", args[0])));
                            return;
                        }
                    } else {
                        sender.sendMessage(Colors.convertStringWithColors(Messages.SERVER_NOT_EXISTS.asString().replaceAll("%server%", args[0])));
                        return;
                    }
                } else {
                    sender.sendMessage(Colors.convertStringWithColors(Messages.CONSOLE_MESSAGE.asString()));
                    return;
                }
            }
        } else {
            sender.sendMessage(Colors.convertStringWithColors(Messages.NO_PERMISSIONS.asString()));
            return;
        }
    }
}
