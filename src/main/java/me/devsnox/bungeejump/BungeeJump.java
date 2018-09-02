package me.devsnox.bungeejump;

import me.devsnox.bungeejump.commands.ListCommand;
import me.devsnox.bungeejump.commands.WarpCommand;
import me.devsnox.bungeejump.configuration.AdvancedPlugin;
import me.devsnox.bungeejump.configuration.JumpConfigurator;
import net.md_5.bungee.api.ProxyServer;
import org.bstats.bungeecord.Metrics;


public class BungeeJump extends AdvancedPlugin {

    private JumpConfigurator jumpConfigurator;

    @Override
    public void onEnable() {
        new Metrics(this);

        this.saveResource("config.yml", false);

        this.jumpConfigurator = new JumpConfigurator();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new WarpCommand(jumpConfigurator.getJumpConfiguration(), "server"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ListCommand(jumpConfigurator.getJumpConfiguration(), "servers"));
    }
}
