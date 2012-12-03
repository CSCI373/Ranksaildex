package edu.unca.csci373.Ranksaildex;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class RanksaildexWaterPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;//height;
		Block waterBlock;//, sandBlock;

		for (y=0; y<68; ++y){
			for(x=0;x<16; ++x){
				for (z=0;z<16;++z){
					
					//if (chunk.getBlock(x, y, z).getType()== Material.AIR){
						for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR; --y){
						waterBlock = chunk.getBlock(x, y, z);
						waterBlock.setType(Material.WATER);
						}
						/*for(height=y; height>0;--height){
							for (y = 255; chunk.getBlock(x, y, z).getType() == Material.AIR; --y){
							//if (chunk.getBlock(x, height, z).getType()!= Material.WATER){
								sandBlock = chunk.getBlock(x, height, z);
								sandBlock.setType(Material.SAND);
							}
							}*/
						}
					}


				}
			}

		}