package edu.unca.csci373.Ranksaildex;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/*
 * This is a sample event listener
 */
public class RanksaildexListener implements Listener {
    private final Ranksaildex plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public RanksaildexListener(Ranksaildex plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void decraft(PlayerInteractEvent event) {
    	if(event.getClickedBlock().getType() == Material.WORKBENCH && event.getAction().equals(Action.LEFT_CLICK_BLOCK) == true){
    		event.getPlayer().sendMessage("yay you clicked a bench");
    		World world = event.getPlayer().getWorld();
    		Location dropLoc = event.getPlayer().getLocation();
    		int itemID = event.getPlayer().getItemInHand().getTypeId();
    		short durOfinHand =  event.getPlayer().getItemInHand().getType().getMaxDurability();
    		if(event.getPlayer().getItemInHand().getDurability() < (durOfinHand - (durOfinHand * .90))){
    		switch(itemID){
    		case 276:
    			ItemStack items = new ItemStack( Material.DIAMOND.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			int numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    				event.getPlayer().sendMessage("last one");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    		}
    		}else{
    			event.getPlayer().sendMessage(" in hand dur is : " + (event.getPlayer().getItemInHand().getDurability() + " Max is: " + durOfinHand));
    			event.getPlayer().sendMessage("Item was to used");
    		}
    
    		
    	}else{
    		
    	}
    	}
    	
    }

