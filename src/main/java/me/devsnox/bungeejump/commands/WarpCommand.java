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

import me.devsnox.bungeejump.WarpManager;
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

    private WarpManager warpManager;

    public WarpCommand(final String name, WarpManager warpManager) {
        super(name);
        this.warpManager = warpManager;
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("bungeejump.connect")) {
            if (args.length == 0) {
                sender.sendMessage(Messages.SERVER_MESSAGE.get().asComponent());
            } else {
                if (sender instanceof ProxiedPlayer) {
                    if (ProxyServer.getInstance().getServerInfo(args[0]) != null) {
                        this.warpManager.teleportPlayer((ProxiedPlayer)sender, args[0]);
                    } else {
                        sender.sendMessage(Messages.SERVER_NOT_EXISTS.get().replace("%server%", args[0]).asComponent());
                    }
                } else {
                    sender.sendMessage(Messages.CONSOLE_MESSAGE.get().asComponent());
                }
            }
        } else {
            sender.sendMessage(Messages.NO_PERMISSIONS.get().asComponent());
        }
    }
}
