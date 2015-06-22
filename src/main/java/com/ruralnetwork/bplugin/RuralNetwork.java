package com.ruralnetwork.bplugin;

import com.ruralnetwork.bplugin.command.HubCommand;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class RuralNetwork extends Plugin {

    @Override
    public void onEnable() {

        this.getProxy().getPluginManager().registerCommand(this, new HubCommand());

        this.getLogger().log(Level.INFO, "Enable");
    }
}
