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
			for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 68; --y);
			if (chunk.getBlock(x, y, z).getType() != Material.WATER && chunk.getBlock(x, y, z).getType() != Material.LONG_GRASS && chunk.getBlock(x, y, z).getType() != Material.LEAVES){
			//randomize coords
			block = chunk.getBlock(x, y +1, z);
			block.setType(Material.LONG_GRASS);
			block.setData((byte)0x1);
			}
			}
			}
			}
			for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
			if (random.nextInt(100) < 01){
			for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 68; --y);
			if (chunk.getBlock(x, y, z).getType() != Material.WATER && chunk.getBlock(x, y, z).getType() != Material.LONG_GRASS && chunk.getBlock(x, y, z).getType() != Material.LEAVES){
			//randomize coords
			block = chunk.getBlock(x, y +1, z);
			block.setType(Material.RED_ROSE);
			block.setData((byte)0x1);
			}
			}
			}
			}
			
			
			
			for (x = 0; x < 16; ++x){
				for (z = 0; z < 16; ++z){
			if (random.nextInt(500) < 01){
				for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 68; --y);
				if (chunk.getBlock(x, y, z).getType() != Material.WATER && chunk.getBlock(x, y, z).getType() != Material.LONG_GRASS && chunk.getBlock(x, y, z).getType() != Material.LEAVES){
				//randomize coords
				block = chunk.getBlock(x, y+1, z);
				block.setType(Material.YELLOW_FLOWER);
				block.setData((byte)0x1);
				}
			}
			}
		}
			
			for (x = 0; x < 16; ++x){
				for (z = 0; z < 16; ++z){
				if (random.nextInt(100) < 01){
				for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 68; --y);
				if (chunk.getBlock(x, y, z).getType() == Material.WATER){
				//randomize coords
				block = chunk.getBlock(x, y +1, z);
				block.setType(Material.WATER_LILY);
				block.setData((byte)0x1);
				}
				}
				}
				}
			
			for (x = 0; x < 16; ++x){
				for (z = 0; z < 16; ++z){
				if (random.nextInt(100) < 20){
				for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR && y > 68; --y);
				if (chunk.getBlock(x, y, z).getType() == Material.GRASS && (chunk.getBlock(x+1,y, z).getType() == Material.WATER)){
				block = chunk.getBlock(x, y+1, z);
				block.setType(Material.SUGAR_CANE_BLOCK);
				block.setData((byte)0x1);
				}
				}
				}
				} 
	}

}
