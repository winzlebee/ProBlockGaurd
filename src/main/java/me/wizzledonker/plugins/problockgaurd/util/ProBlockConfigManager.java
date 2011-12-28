/*
 * ProBlockGaurd config manager, for custom configurations/loading.
 * (c) WizzleDonker @ 26/12/11
 */
package me.wizzledonker.plugins.problockgaurd.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.wizzledonker.plugins.problockgaurd.ProBlockGaurd;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ProBlockConfigManager {
    private FileConfiguration pbgRegions = null;
    private File pbgRegionsFile = null;
    
    private static ProBlockGaurd plugin;
    private static ProBlockConfigHelper strings;
    
    //Start custom region config code
    public void reloadRegionsConfig() {
        if (pbgRegions == null) {
            pbgRegionsFile = new File(plugin.getDataFolder(), "regions.yml");
        }
        pbgRegions = YamlConfiguration.loadConfiguration(pbgRegionsFile);
    }
    
    public FileConfiguration getRegionsConfig() {
        if (pbgRegions == null) {
            reloadRegionsConfig();
        }
        return pbgRegions;
    }
    
    public void saveRegionsConfig() {
        if (pbgRegions == null || pbgRegionsFile == null) {
            return;
        }
        try {
            pbgRegions.save(pbgRegionsFile);
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
                    strings.getPluginName() + "Problem with config: " + pbgRegionsFile, ex);
        }
    }
    //End custom config saving/management code
}
