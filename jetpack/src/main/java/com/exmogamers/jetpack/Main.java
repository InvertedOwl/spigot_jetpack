package com.exmogamers.jetpack;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin {
    public static Main mainInstance;
    public static Main getInstance() {
        return mainInstance;
    }


    @Override
    public void onLoad() {
        mainInstance = this;
    }

    @Override
    public void onEnable() {


        getServer().getPluginManager().registerEvents(new Listeners(), this);
        //getCommand("yeet").setExecutor(this);
        this.getCommand("jetpack").setExecutor(new Commands());

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()){
                    if(player.getScoreboardTags().contains("jetpack")) {

                        if (player.isSneaking()) {

                            player.setVelocity(new Vector(player.getVelocity().getX(), 0.8, player.getVelocity().getZ()));
                            player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 50, 0.1, 0.1, 0.1, 0);
                            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 0.1f, 1);
                        }
                    }
                }
            }
        }, 0, 1);


    }
    @Override
    public void onDisable() {

    }
}
