package com.ruralnetwork.bplugin.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {

    public HubCommand() {
        super("hub");
    }

    @Override
    public void execute(CommandSender source, String[] args) {
        if (source instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) source;
            if (!player.getServer().toString().equalsIgnoreCase("hub")) {
                ServerInfo target = ProxyServer.getInstance().getServerInfo("hub");
                player.connect(target);
            } else {
                player.sendMessage(new ComponentBuilder("You are already connected to the Hub!").color(ChatColor.RED).create());
            }
        } else {
            source.sendMessage(new ComponentBuilder("This command can only be run by a player.").color(ChatColor.RED).create());
        }
    }
}
