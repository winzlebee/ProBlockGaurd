package me.wizzledonker.plugins.problockgaurd.util;
/**
 *  ProBlockGaurd string helper
 *  (C) WizzleDonker @ 2/12/11
 */
import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import org.bukkit.ChatColor;

public class ProBlockConfigHelper {
    public static ProBlockGaurd plugin;
    
    public ProBlockConfigHelper(ProBlockGaurd instance) {
        plugin = instance;
    }
    
    public String getPluginName() {
        return ChatColor.BLUE + "[" + plugin + "]";
    }
    
    public String getStrings(String message) {
        String returnMsg = plugin.getConfig().getString(message);
        if (returnMsg.isEmpty()) {
            return getPluginName() + " failed to display message! (Contact wizzledonker)";
        }
        return returnMsg;
    }
    
    public int getInt(String path) {
        int finalInt = 0;
        finalInt = plugin.getConfig().getInt(path);
        if (finalInt == 0) {
            return 278;
        }
        return finalInt;
    }
    
    
}
