package edu.unca.csci373.Ranksaildex;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class RanksaildexWaterPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;
		Block block;

		for (y=66; y<68; ++y){
			for(x=0;x<16; ++x){
				for (z=0; z<16;++z){
						for (y = 68; chunk.getBlock(x, y, z).getType() == Material.AIR; --y){
						block = chunk.getBlock(x, y, z);
						block.setType(Material.WATER);
						
					
						}

						}
					}


				}
	}
}

		