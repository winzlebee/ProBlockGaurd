/*
 * public class Region, where all the magic happens.
 * (c) Winfried Holzapfel 29/12/2011
 */
package me.wizzledonker.plugins.problockgaurd.regions;

import java.util.ArrayList;
import java.util.List;
import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigHelper;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Region {
    private String regionName;
    private World regionWorld;
    private Player regionOwner;
    
    private Location regionPrimary;
    private Location regionSecondary;
    
    private ProBlockConfigHelper strings;
    
    public Region(String name, Player owner, World world, Location PrimaryLoc, Location SecondaryLoc) {
        regionWorld = world;
        regionOwner = owner;
        regionPrimary = PrimaryLoc;
        regionSecondary = SecondaryLoc;
    }
    
    public Location getPrimary() {
        return regionPrimary;
    }
    
    public Location getSecondary() {
        return regionSecondary;
    }
    
    public World getWorld() {
        return regionWorld;
    }
    
    public String getName() {
        return regionName;
    }
    
    public Player getOwner() {
        return regionOwner;
    }
    
    public boolean writeToConfig(FileConfiguration config) {
        if (config.contains(regionName)) {
            System.out.println(strings.getPluginName() + "Region already exists in config");
            return false;
        }
        String suffix = "regions." + regionName;
        
        //Set primary location
        config.set(suffix + ".primary.X", getPrimary().getX());
        config.set(suffix + ".primary.Y", getPrimary().getY());
        config.set("regions." + regionName + ".primary.Z", getPrimary().getZ());
        //Set secondary location
        config.set(suffix + ".secondary.X", getSecondary().getX());
        config.set(suffix + ".secondary.Y", getSecondary().getY());
        config.set(suffix + ".secondary.Z", getSecondary().getZ());
        //Set other properties
        //TODO: Custom properties for the API
        config.set(suffix + ".owner", getOwner().getName());
        config.set(suffix + ".world", getWorld().getName());
        return true;
    }
    
    public void setOwner(Player player) {
        regionOwner = player;
    }
    
    public void setName(String name) {
        regionName = name;
    }
    
    public void setPrimary(Location loc) {
        regionPrimary = loc;
    }
    
    public void setSecondary(Location loc) {
        regionSecondary = loc;
    }
    
    public List<Block> getBlocks() {
        //This method gets all the blocks in the region
        //And returns them in a list.
        List<Block> blockList = new ArrayList<Block>();
        
        for (int x = (int) getPrimary().getX() ; x < getSecondary().getX() ; x++) {
            for (int y = (int) getPrimary().getY() ; y < getSecondary().getY() ; y++ ) {
                for (int z = (int) getPrimary().getZ() ; z < getSecondary().getZ() ; z++) {
                    blockList.add(new Location(getWorld(), x, y, z).getBlock());
                }
            }
        }
        
        return blockList;
    }
}
