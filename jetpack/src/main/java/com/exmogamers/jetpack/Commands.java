package com.exmogamers.jetpack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && label.equalsIgnoreCase("jetpack") && sender.hasPermission("jetpack.jetpack")) {


            if(args.length == 0) {
                Player player = (Player) sender;

                Configuration config = Main.getInstance().getConfig();
                if (player.getScoreboardTags().contains("jetpack")) {

                    player.sendMessage(fString(config.getString("toggle-off")));
                    player.removeScoreboardTag("jetpack");
                } else {
                    player.sendMessage(fString(config.getString("toggle-on")));
                    player.addScoreboardTag("jetpack");
                }
                //player.setVelocity(new Vector(5, 5, 5));
            } else
                if (args.length == 1){

                Player player = Bukkit.getPlayer(args[0]);
                if(player == null){
                    sender.sendMessage("§4This player is not online!");
                    return true;
                }

                Configuration config = Main.getInstance().getConfig();
                if (player.getScoreboardTags().contains("jetpack")) {

                    player.sendMessage(fString(config.getString("toggle-off")));
                    player.removeScoreboardTag("jetpack");
                } else {
                    player.sendMessage(fString(config.getString("toggle-on")));
                    player.addScoreboardTag("jetpack");
                }


            }

        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
    public String fString (String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
