package me.miko.cowdupefix;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CowDupeFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(ignoreCancelled = true)
    public void onShear(PlayerShearEntityEvent event) {
        if (event.getEntity().getType() == EntityType.MUSHROOM_COW) {
            if (event.getPlayer().hasCooldown(Material.SHEARS)) {
                event.setCancelled(true);
                return;
            }
            event.getPlayer().setCooldown(Material.SHEARS, 2);
        }
    }
}