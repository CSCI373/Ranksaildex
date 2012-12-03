package edu.unca.csci373.Ranksaildex;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import edu.unca.csci373.Ranksaildex.RanksaildexTerrainGenerator;

/*
 * This is the main class of the sample plug-in
 */
public final class Ranksaildex extends JavaPlugin {
	
	RanksaildexLogger logger;
    /*
     * This is called when your plug-in is enabled
     */
    @Override
    public void onEnable() {
    	
    	// set up the logger
    	logger = new RanksaildexLogger(this);
    	logger.info("plugin enabled");
    	
        // save the configuration file
        saveDefaultConfig();
        
        // Create the SampleListener
        new RanksaildexListener(this);
        
        // set the command executor for sample
        this.getCommand("sample").setExecutor(new RanksaildexCommandExecutor(this));
        
    }
    
	public void logMessage(String message){
		PluginDescriptionFile pdFile = this.getDescription();
		this.logger.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + message);
	}
    
    /*
     * This is called when your plug-in shuts down
     */
    @Override
    public void onDisable() {
    	logger.info("plugin enabled");
    }
    
    public ChunkGenerator getDefaultWorldGenerator (String worldName, String uid) {
		return new RanksaildexTerrainGenerator(this);
	}

}
