package me.wizzledonker.plugins.problockgaurd;

import me.wizzledonker.plugins.problockgaurd.util.ProBlockConfigHelper;
import org.bukkit.plugin.java.JavaPlugin;

public class ProBlockGaurd extends JavaPlugin {
    ProBlockConfigHelper strings = new ProBlockConfigHelper(this);

    public void onEnable() {
        System.out.println(strings.getPluginName() + "has been successfully initialised on server!");
    }
    
    public void onDisable() {
        System.out.println(strings.getPluginName() + "has been disabled on server.");
    }

}
