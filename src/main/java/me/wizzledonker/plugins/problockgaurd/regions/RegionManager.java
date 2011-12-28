/**
 * Region Manager for PBG
 * (c) WizzleDonker @ 2/12/11
 */
package me.wizzledonker.plugins.problockgaurd.regions;

import java.util.HashMap;
import java.util.Map;
import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigHelper;
import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class RegionManager {
    public static ProBlockGaurd plugin;
    private static ProBlockConfigHelper strings;
    private static ProBlockConfigManager configs;
    
    public Map<Player,Location> PrimaryRegions = new HashMap<Player,Location>();
    public Map<Player,Location> SecondaryRegions = new HashMap<Player,Location>();
    
    FileConfiguration pbgRegions = configs.getRegionsConfig();
    
    /* 
     * This class is named RegionManager, you can use it in your plugin as an API
     * but I recommend you use the official API classes, however tempting these strong methods
     * may be to use. This is because this section is likely to dramatically change in the
     * future and this would obviously alter the outcome of your plugins, as well as whether
     * they actually work.
     */
    
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
    
    private boolean getCreationPossible(Player player) {
        if (PrimaryRegions.containsKey(player) && SecondaryRegions.containsKey(player)) {
            return true;
        }
        return false;
    }
    
    public void create(Player player, String name) {
        if (!getCreationPossible(player)) {
            player.sendMessage(ChatColor.RED + "Region creation not possible! Are both selections defined?");
            return;
        }
        Region region = new Region(name, player, player.getWorld(), PrimaryRegions.get(player), SecondaryRegions.get(player));
        player.sendMessage("Not implemented yet! Wait for us to go out of planning stage.");
    }
}
