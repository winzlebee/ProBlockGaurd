/**
 * Region Manager for PBG
 * (c) WizzleDonker @ 2/12/11
 */
package me.wizzledonker.plugins.problockgaurd.regions;

import java.util.HashMap;
import java.util.Map;
import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigHelper;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class RegionManager {
    public static ProBlockGaurd plugin;
    private static ProBlockConfigHelper strings;
    
    public Map<Player,Location> PrimaryRegions = new HashMap<Player,Location>();
    public Map<Player,Location> SecondaryRegions = new HashMap<Player,Location>();
    
    public void setSecondarySelection(Player player, Block block) {
        Location loc = block.getLocation();
        SecondaryRegions.put(player, loc);
        player.sendMessage(ChatColor.GREEN + strings.getStrings("messages.select.secondary").replace("%loc%", ChatColor.WHITE + loc.toString()));
    }
    
    public void setPrimarySelection(Player player, Block block) {
        Location loc = block.getLocation();
        PrimaryRegions.put(player, loc);
        player.sendMessage(ChatColor.GREEN + strings.getStrings("messages.select.primary").replace("%loc%", ChatColor.WHITE + loc.toString()));
    }
}
