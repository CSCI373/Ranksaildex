package edu.unca.csci373.Ranksaildex;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import edu.unca.csci373.Ranksaildex.RanksaildexTerrainGenerator;
import edu.unca.csci373.Ranksaildex.Ranksaildex;

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
        
        // Create the Listener
        new RanksaildexListener(this);
        
        // set the command executor for siege
        this.getCommand("siege").setExecutor(new RanksaildexCommandExecutor(this));
        
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
    	logger.info("plugin disabled");
    }
    
    //recognizes the terrain generator and implements it
    public ChunkGenerator getDefaultWorldGenerator (String worldName, String uid) {
		return new RanksaildexTerrainGenerator(this);
	}
    
    //sets the meta data for the player
    public void setMetadata(Player player, String key, Object value,
			Ranksaildex plugin) {
		player.setMetadata(key, new FixedMetadataValue(plugin, value));
	}
	
	/*This checks to see if the player has a metadata value assigned to them.
	 *If they do, the boolean value will return true or false, depending on
	 *what the program default is. 
	 */

	public Object getMetadata(Player player, String key, Ranksaildex plugin) {
		List<MetadataValue> values = player.getMetadata(key);
		for (MetadataValue value : values) {
			if (value.getOwningPlugin().getDescription().getName()
					.equals(plugin.getDescription().getName())) {
				return (value.asBoolean());
			}
		}
		return null;
	}
}
