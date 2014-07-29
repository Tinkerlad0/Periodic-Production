package com.tinkerlad.chemistry.world;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.config.ConfigHandler;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.registry.annotations.RegisterOreGen;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OreGen implements IWorldGenerator {

	public static Map<Block, Double> oresToGen = new HashMap<Block, Double>();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				//Nether
				break;
			case 0:
				//Surface
				doOreSpawn(world, random, chunkX << 4, chunkZ << 4, 6);
				break;
			case 1:
				//End
				break;
			default:
				//Custom Dimensions
				break;
		}
	}

	public void addOreToSpawn(Block block, double chancesToSpawn) {
		if (block != null) {
			if (chancesToSpawn < 2D) {
				chancesToSpawn = 1D;
			}
			oresToGen.put(block, chancesToSpawn);
			LogHelper.info(block.getLocalizedName() + " " + chancesToSpawn);
		}
	}

	public void doOreSpawn(World world, Random random, int blockXPos, int blockZPos,
	                       int maxVeinSize) {

		for (Map.Entry<Block, Double> oreEntry : oresToGen.entrySet()) {
			Block ore = oreEntry.getKey();
			double chancesToSpawn = oreEntry.getValue();
			if (ConfigHandler.VERBOSE) {LogHelper.log(Level.INFO, "Ore Genning " + ore.getLocalizedName());}
			WorldGenMinable genMinable = new WorldGenMinable(ore, 1, maxVeinSize, Blocks.stone);
			for (int j = 0; j < (int) chancesToSpawn; j++) {
				int posX = blockXPos + random.nextInt(16);
				int posY = 2 + random.nextInt(100);
				int posZ = blockZPos + random.nextInt(16);
				genMinable.generate(world, random, posX, posY, posZ);
			}
		}
	}

	public void populateDefaultOres() {
		for (Field field : BlockList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterOreGen.class)) {
				RegisterOreGen annotation = field.getAnnotation(RegisterOreGen.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(BlockList.class, Chemistry.BLOCK_LIST,
						                                                        field.getName());
				if (obj instanceof Block) {
					if (ConfigHandler.DEBUG) {
						LogHelper.info(((Block) obj).getLocalizedName() + " added to world " +
								               "generation in overworld");
					}
					addOreToSpawn((Block) obj, annotation.partsPerMillion() * 350);
				}
			}
		}
	}
}
