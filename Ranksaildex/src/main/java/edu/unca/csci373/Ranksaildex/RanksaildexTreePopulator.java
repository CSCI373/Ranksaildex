package edu.unca.csci373.Ranksaildex;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class RanksaildexTreePopulator extends BlockPopulator {


	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;
		
		
		//this is the code to randomly spawn trees
		//there are four possible tree types to be spawned
		//these spawn from level 69 and up
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				if (random.nextInt(100) < 5){
					for (y = 100; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 69; --y);
					
					
					TreeType type  = (random.nextInt(100) < 85) ? TreeType.BIRCH : TreeType.TREE;
					TreeType type2 = (random.nextInt(100) < 25) ? TreeType.REDWOOD : TreeType.TALL_REDWOOD;
					
					world.generateTree(chunk.getBlock(75 + random.nextInt(16), y, 75 + random.nextInt(20)).getLocation(), type);
					world.generateTree(chunk.getBlock(75 + random.nextInt(16), y, 75 + random.nextInt(20)).getLocation(), type2);
					
				}
			}
		}
	}
}	


