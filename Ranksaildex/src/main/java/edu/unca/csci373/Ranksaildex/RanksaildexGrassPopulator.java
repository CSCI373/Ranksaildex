package edu.unca.csci373.Ranksaildex;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class RanksaildexGrassPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				if (random.nextInt(100) < 25){
					for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR; --y) ;
						//for(y = 255; chunk.getBlock(x, y, z).getType() == Material.WATER; ++y);
					
					block = chunk.getBlock(x, y + 1, z);
				    block.setType(Material.LONG_GRASS);
					block.setData((byte)0x1);
				}
			}
		}
			//for (x = 0; x < 16; ++x){
				//for (z = 0; z < 16; ++z){
			//if (random.nextInt(100) < 02){
				//for (y = 68; chunk.getBlock(x, y, z).getType() == Material.AIR; ++y);
				//for (y = 255; chunk.getBlock(x, y, z).getType() == Material.WATER; ++y);
				//randomize coords
				//block = chunk.getBlock(x, y + 1, z);
				//block.setType(Material.RED_ROSE);
				//block.setData((byte)0x1);
				
			//}
				//}
			//}
			
			
			
			/*for (x = 0; x < 16; ++x){
				for (z = 0; z < 16; ++z){
			if (random.nextInt(100) < 01){
				for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR; --y);
				
				//randomize coords
				block = chunk.getBlock(x, y + 1, z);
				block.setType(Material.YELLOW_FLOWER);
				block.setData((byte)0x1);
			}
			}
		}*/
	}

}
