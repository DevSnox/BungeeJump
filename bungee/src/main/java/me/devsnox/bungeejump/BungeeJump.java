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

package me.devsnox.bungeejump;

import me.devsnox.bungeejump.commands.DirectConnectCommand;
import me.devsnox.bungeejump.commands.ListCommand;
import me.devsnox.bungeejump.commands.WarpCommand;
import me.devsnox.bungeejump.configuration.AdvancedPlugin;
import me.devsnox.bungeejump.configuration.ConfigurationManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.YamlConfiguration;
import org.bstats.bungeecord.Metrics;

import java.io.File;
import java.io.IOException;

// TODO: 03.09.2018 Better logging!

/**
 * @author Yasin Dalal (DevSnox)
 * Created by Yasin Dalal (DevSnox) on 02.05.2018 00:00.
 */
public final class BungeeJump extends AdvancedPlugin {

    private ConfigurationManager configurationManager;
    private WarpManager warpManager;

    @Override
    public void onEnable() {
        new Metrics(this);

        try {
            if(!YamlConfiguration.getProvider(YamlConfiguration.class)
                    .load(new File(this.getDataFolder() + File.separator + "config.yml")).contains("config-version")) {

                new File(this.getDataFolder() + File.separator + "config.yml")
                        .renameTo(new File(this.getDataFolder() + File.separator + "old-config.txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.saveResource("config.yml", false);
        this.saveResource("messages.yml", false);

        this.configurationManager = new ConfigurationManager(this.getDataFolder());

        try {
            this.configurationManager.loadMainConfiguration();
            this.configurationManager.loadMessageConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.warpManager = new WarpManager();

        this.registerCommands();
    }

    private void registerCommands() {
        final PluginManager pluginManager = this.getProxy().getPluginManager();

        pluginManager.registerCommand(this, new WarpCommand("server", this.warpManager));
        pluginManager.registerCommand(this, new ListCommand("servers"));


        for (String name : ProxyServer.getInstance().getServers().keySet()) {
            pluginManager.registerCommand(this, new DirectConnectCommand(name, this.warpManager));
        }
    }
}