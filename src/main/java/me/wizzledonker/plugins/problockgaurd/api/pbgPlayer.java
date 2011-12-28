/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.wizzledonker.plugins.problockgaurd.api;

import org.bukkit.entity.Player;

/**
 * 
 * @author Win Holzapfel
 */
public interface pbgPlayer extends Player {
    
    /**
     * Gets if the player is in a region
     * 
     * @param region
     * @return boolean
     */
    public boolean isInRegion(String region);
    
}
