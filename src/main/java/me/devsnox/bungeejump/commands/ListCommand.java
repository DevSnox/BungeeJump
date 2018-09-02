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
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

import java.util.Map;

/**
 * @author Yasin Dalal (DevSnox)
 * Created by Yasin Dalal (DevSnox) on 02.05.2018 00:00.
 */
public final class ListCommand extends Command {

    public ListCommand(final String name) {
        super(name);
    }

    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("bungeejump.list")) {

            final Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
            final StringBuilder stringBuilder = new StringBuilder();

            if (servers.size() > 0) {
                int count = 1;

                for (final Map.Entry<String, ServerInfo> serverInfo : servers.entrySet()) {
                    if (count == servers.size()) {
                        stringBuilder.append(serverInfo.getValue().getName());
                        break;
                    }
                    stringBuilder.append(serverInfo.getValue().getName() + ", ");

                    count++;
                }
            } else
                stringBuilder.append("none"); // TODO: 03.09.2018 Add posibility to define "none" in the configuration file

            sender.sendMessage(Colors.convertStringWithColors(Messages.LIST_OF_SERVERS.asString().replaceAll("%servers%", stringBuilder.toString())));
        }
    }
}
