package me.wizzledonker.plugins.problockgaurd.util;
/**
 *  ProBlockGaurd string helper
 *  (C) WizzleDonker @ 2/12/11
 */
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import org.bukkit.ChatColor;

public class ProBlockConfigHelper {
    Calendar calendar = new GregorianCalendar();
    public static ProBlockGaurd plugin;
    
    public String getCurrentTime() {
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        
        String am_pm = "NaN";
        switch (calendar.get(Calendar.AM_PM)) {
            case 1:
                am_pm = "PM";
            case 0:
                am_pm = "AM";
        }
        
        return hour + ":" + minutes + am_pm;
    }
    
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
            return 318;
        }
        return finalInt;
    }
    
    public void generateDefaults() {
        if (!new File(plugin.getDataFolder(), "plugin.yml").exists()) {
            
            //Config file header
            plugin.getConfig().options().header("ProBlockGaurd Configuration file (config.yml)");
            plugin.getConfig().options().header("This file was Automatically generated on " + getCurrentTime());
            
            //Messages defaults
            plugin.getConfig().addDefault("messages.select.primary", ChatColor.GREEN + "Selected primary selection point %loc%");
            plugin.getConfig().addDefault("messages.select.secondary", ChatColor.GREEN + "Selected secondary selection point %loc%");
            plugin.getConfig().addDefault("messages.error", ChatColor.RED + "There was an error with PBG, contact WizzleDonker.");
            
            //Selection defaults
            plugin.getConfig().addDefault("selection.tool_id", 318);
            
            //Copy the config defaults/header
            plugin.getConfig().options().copyHeader(true);
            plugin.getConfig().options().copyDefaults(true);
        }
        
        System.out.println(plugin + " has loaded the config file.");
    }
    
    
}
