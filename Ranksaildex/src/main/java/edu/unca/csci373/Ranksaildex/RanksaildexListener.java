package edu.unca.csci373.Ranksaildex;


import java.text.MessageFormat;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/*
 * This is a sample event listener
 */
public class RanksaildexListener implements Listener {
    private final Ranksaildex plugin;
    Random random;

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

   	public void onPlayerJoin(PlayerJoinEvent event) {
		plugin.setMetadata(event.getPlayer(), "on", false, plugin);
		event.getPlayer().sendMessage(this.plugin.getConfig().getString("siege.message"));

	}
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void ZeldaDrops(BlockDamageEvent event) {
        if(event.getBlock().getType() == Material.LONG_GRASS){
        	Random random = new Random();
        			if(random.nextInt(50) == 1){
        				ItemStack items = new ItemStack(Material.EMERALD);
            			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), items);
        			} else if(random.nextInt(20) == 1){
        				ItemStack items = new ItemStack(Material.WHEAT);
            			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), items);

        			}
        }
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void LeafDrops(BlockDamageEvent event) {
        if(event.getBlock().getType() == Material.LEAVES){
        	Random random = new Random();
        			if(random.nextInt(25) == 3){
        				ItemStack items = new ItemStack(Material.APPLE);
            			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), items);
        			} else if(random.nextInt(50) == 1) {
        				final EntityType bat = EntityType.BAT;
        				event.getPlayer().getWorld().spawnEntity(event.getBlock().getLocation(), bat);
        			}
        }
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */

    @EventHandler(priority = EventPriority.HIGH)
    public void decraft(BlockDamageEvent event) {
   
		//event.getPlayer().sendMessage("Pre-Test");
    	if(event.getBlock().getType()== Material.WORKBENCH){
			//event.getPlayer().sendMessage("Test Passed");
    		World world = event.getPlayer().getWorld();
    		
    		Location dropLoc = event.getPlayer().getLocation();
    		int itemID = event.getPlayer().getItemInHand().getTypeId();
    		short durOfinHand =  event.getPlayer().getItemInHand().getType().getMaxDurability();
    	//	event.getPlayer().sendMessage("Got durabillty");
    		if(event.getPlayer().getItemInHand().getDurability() < (durOfinHand - (durOfinHand * .90)) || event.getPlayer().getItemInHand().getDurability() == 0){
    			ItemStack items = new ItemStack( Material.DIAMOND.getId());
    			int numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    		switch(itemID){
    		case 276:
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    		
    		case 277:
    			items = new ItemStack( Material.DIAMOND.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items); 
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    		
    		case 278:
    			items = new ItemStack( Material.DIAMOND.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    		case 279:
    			items = new ItemStack( Material.DIAMOND.getId());
    			 
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    		case 283:
    			items = new ItemStack( Material.GOLD_INGOT.getId());
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    				//event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 256:
    			items = new ItemStack( Material.IRON_INGOT.getId());
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    				//event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 257:
    			items = new ItemStack( Material.IRON_INGOT.getId());
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    				//event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 258:
    			items = new ItemStack( Material.IRON_INGOT.getId());
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 267:
    			items = new ItemStack( Material.IRON_INGOT.getId(), 2);
    			
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    			
    		case 284:

    			items = new ItemStack( Material.GOLD_INGOT.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 285:
    			items = new ItemStack( Material.GOLD_INGOT.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 286:
    			
    			items = new ItemStack( Material.GOLD_INGOT.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 292:
    			
    			items = new ItemStack( Material.IRON_INGOT.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items); 
    			numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 293:
    			
    			items = new ItemStack( Material.DIAMOND.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			 numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 294:
    			
    			items = new ItemStack( Material.GOLD_INGOT.getId());
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			 numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    		case 325:
    			
    			items = new ItemStack( Material.IRON_INGOT.getId(), 3);
    			world.dropItemNaturally(dropLoc.getBlock().getLocation().add(1, 0, 0), items);
    			 numOf = event.getPlayer().getItemInHand().getAmount() - 1;
    			if(numOf == 0){
    				ItemStack air = new ItemStack(Material.AIR);
    			//	event.getPlayer().sendMessage("Last item");
    			 event.getPlayer().getInventory().setItemInHand(air);		
    			}else{
    			 event.getPlayer().getItemInHand().setAmount(numOf);
    			}
    			break;
    			
    			
    			
    		} 		
    		}else{
    			event.getPlayer().sendMessage("The item in hand has the durability: " + (event.getPlayer().getItemInHand().getDurability() + " Maximum durability is: " + durOfinHand));
    			event.getPlayer().sendMessage("Item was too damaged to salvage. Sorry.");
    		}
    
    		
    	}else{
    		
    	}//catch goes after here
    	
    	}
    
    
    
   

	//This will give the player a 'blessing' if 'bless' is typed and then a block is clicked
	//Items, food and a flower will appear, as will the ability to fly
    
	@EventHandler(priority = EventPriority.HIGHEST)
	public void demoEvent(PlayerInteractEvent event) {
	try {
		if(event.getClickedBlock().getType() == Material.YELLOW_FLOWER) {
		
				if ((Boolean) plugin.getMetadata(event.getPlayer(), "siege", plugin)) {
		
			
					}
		
					Location loc = event.getPlayer().getLocation();
				    loc.getWorld().dropItem(loc, new ItemStack(Material.IRON_SWORD, 1));
					loc.getWorld().dropItem(loc, new ItemStack(Material.LEATHER_BOOTS, 1));
					loc.getWorld().dropItem(loc, new ItemStack(Material.IRON_HELMET, 1));
					loc.getWorld().dropItem(loc, new ItemStack(Material.LEATHER_LEGGINGS, 1));
					loc.getWorld().dropItem(loc, new ItemStack(Material.IRON_CHESTPLATE, 1));
					event.getPlayer().sendMessage("It's not much, but it'll help. Be safe.");
					plugin.logger.info(event.getPlayer()+ " has been given aid.");

				}
      } catch (Exception e) {	
    	  // TODO Auto-generated catch block
      e.printStackTrace(); 
      }
						
			}

}

    
    	
    //}

