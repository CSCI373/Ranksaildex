package edu.unca.csci373.Ranksaildex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class RanksaildexTerrainGenerator extends ChunkGenerator {

	private Ranksaildex plugin;

	public RanksaildexTerrainGenerator(Ranksaildex instance) {
		this.plugin = instance;
	}

	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		//populators.add(new RanksaildexGrassPopulator());
		//populators.add(new RanksaildexTreePopulator());
		populators.add(new RanksaildexWaterPopulator());

		return populators;
	}

	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0, 70, 0);
	}

	private int coordsToInt(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}

	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		byte[] blocks = new byte[32768];
		int x, y, z;

		Random rand = new Random(world.getSeed());

		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);

		// 64 is the distance between the high points and the low points
		// assign a random for that number to generate differently set hills
		// increasing the number will make the hills closer together
		//
		// make this like the tree loop, if above a certain point, spawn a hill
		// want flat lands for some areas, if possible
		octave.setScale(1 / 96.0);

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {
				blocks[this.coordsToInt(x, 0, z)] = (byte) Material.BEDROCK.getId();

				// frequency is used to control steepness of the hills; higher
				// number = higher hills
				// this should be a random number too (first number, 16)
				// 12 at the end is the height of the hill (*12 at the end)
				double noise = Math.abs(octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 12);

				for (y = 1; y < 64 + noise; ++y) {
					blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
				}

				for (y = 1; y < 67; ++y) {
					if (y == 1) {
						if (random.nextInt(100) <= 85) {
							int block = (random.nextInt(100) <= 85) ? Material.DIAMOND_ORE.getId() : Material.LAVA.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 2 || y == 3) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.DIAMOND_ORE.getId() : Material.LAVA.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 4) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 25) ? Material.DIAMOND_ORE.getId() : Material.LAVA.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 5) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 6 || y == 7) {
						if (random.nextInt(100) <= 85) {
							int block = (random.nextInt(100) <= 85) ? Material.REDSTONE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 7 || y == 8) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.REDSTONE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 9) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.REDSTONE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}

					} else if (y == 10 || y == 11) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 12 || y == 13) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.DIAMOND_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 14) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 15 || y == 16) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.EMERALD_ORE.getId() : Material.LAPIS_ORE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 17) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 18 || y == 19) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.EMERALD_ORE.getId() : Material.LAPIS_ORE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 20 || y == 21) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GLOWSTONE.getId();
					} else if (y == 22 || y == 23) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.GOLD_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 24 || y == 25) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.IRON_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 26) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.IRON_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 27 || y == 28) {
						if (random.nextInt(100) <= 85) {
							int block = (random.nextInt(100) <= 85) ? Material.COAL_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 29 || y == 30 || y == 31) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.IRON_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 32 || y == 33) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.STONE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 34) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.COAL_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 35) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.STONE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 36 || y == 37) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 38 || y == 39) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GRAVEL.getId();
					} else if (y == 36 || y == 37) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 38 || y == 39) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GRAVEL.getId();
					} else if (y == 40 || y == 41) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 42 || y == 43 || y == 44) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.IRON_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 45) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
					} else if (y == 46) {
						if (random.nextInt(100) <= 85) {
							int block = (random.nextInt(100) <= 85) ? Material.COAL_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 47 || y == 48) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.IRON_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 49) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
					} else if (y == 50) {
						if (random.nextInt(100) <= 55) {
							int block = (random.nextInt(100) <= 55) ? Material.IRON_ORE.getId() : Material.STONE.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 51 || y == 52) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.IRON_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 53 || y == 54) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 55 || y == 56 || y == 57) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.COAL_ORE.getId() : Material.DIRT.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 58 || y == 59) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
					} else if (y == 60) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GRAVEL.getId();
					} else if (y == 61 || y == 62) {
						if (random.nextInt(100) <= 35) {
							int block = (random.nextInt(100) <= 35) ? Material.GOLD_ORE.getId() : Material.GRAVEL.getId();
							blocks[this.coordsToInt(x, y, z)] = (byte) block;
						}
					} else if (y == 63) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GRAVEL.getId();
					} else if (y == 63 || y == 64) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 65) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.SAND.getId();
					} else if (66 == y || y == 67) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					}
				}
				blocks[this.coordsToInt(x, y, z)] = (byte) Material.GRASS.getId();
			}

		}
		return blocks;
	}
}
