package com.forgetutorials.multientity.extra;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class HeatHandler {
	public static double getEnvHeat(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		double heat = world.getBiomeGenForCoords(x, z).temperature * 30;
		if (block == Blocks.lava) {
			heat += 2000;
		} else if (block == Blocks.lava) {
			heat += 1500;
		} else if (block == Blocks.water) {
			heat -= 15;
		} else if (block == Blocks.water) {
			heat -= 30;
		}
		return heat;
	}

	public static double getEnvHeatAround(World world, int x, int y, int z) {

		double heat = HeatHandler.getEnvHeat(world, x, y, z) + HeatHandler.getEnvHeat(world, x, y - 1, z) + HeatHandler.getEnvHeat(world, x + 1, y, z)
				+ HeatHandler.getEnvHeat(world, x - 1, y, z) + HeatHandler.getEnvHeat(world, x, y, z + 1) + HeatHandler.getEnvHeat(world, x, y, z - 1);

		return heat / 6d;
	}
}
