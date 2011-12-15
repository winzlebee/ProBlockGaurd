/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.wizzledonker.plugins.problockgaurd.listeners;

import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import me.wizzledonker.plugins.problockgaurd.regions.RegionManager;
import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigHelper;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

/**
 *
 * @author Win
 */
public class PBGPListener extends PlayerListener {
    public static ProBlockGaurd plugin;
    private static RegionManager regions;
    private static ProBlockConfigHelper configs;
    
    public PBGPListener(ProBlockGaurd instance) {
        plugin = instance;
    }
    
    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (!player.hasPermission("PBG.create.wand")) {
                return;
            }
            if (!(player.getItemInHand().getTypeId() == configs.getInt("selections.tool_id"))) {
                return;
            }
            Block block = event.getClickedBlock();
            regions.setSecondarySelection(player, block);
        }
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (!player.hasPermission("PBG.create.wand")) {
                return;
            }
            if (!(player.getItemInHand().getTypeId() == configs.getInt("selections.tool_id"))) {
                return;
            }
            Block block = event.getClickedBlock();
            regions.setPrimarySelection(player, block);
            event.setCancelled(true);
        }
    }
    
}
