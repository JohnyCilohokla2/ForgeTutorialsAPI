package com.forgetutorials.lib.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;

public class BlockTessallator {
	public static void addToTessallator(Tessellator tessellator, double x, double y, double z, Icon topIcon, Icon bottomIcon, Icon side1Icon, Icon side2Icom,
			Icon side3Icom, Icon side4Icon) {

		// top
		tessellator.addVertexWithUV(x, y + 1, z, topIcon.getMinU(), topIcon.getMaxV());
		tessellator.addVertexWithUV(x, y + 1, z + 1, topIcon.getMinU(), topIcon.getMinV());
		tessellator.addVertexWithUV(x + 1, y + 1, z + 1, topIcon.getMaxU(), topIcon.getMinV());
		tessellator.addVertexWithUV(x + 1, y + 1, z, topIcon.getMaxU(), topIcon.getMaxV());

		// bottom
		tessellator.addVertexWithUV(x, y, z + 1, bottomIcon.getMinU(), bottomIcon.getMaxV());
		tessellator.addVertexWithUV(x, y, z, bottomIcon.getMinU(), bottomIcon.getMinV());
		tessellator.addVertexWithUV(x + 1, y, z, bottomIcon.getMaxU(), bottomIcon.getMinV());
		tessellator.addVertexWithUV(x + 1, y, z + 1, bottomIcon.getMaxU(), bottomIcon.getMaxV());

		// sides
		tessellator.addVertexWithUV(x, y, z, side1Icon.getMinU(), side1Icon.getMaxV());
		tessellator.addVertexWithUV(x, y + 1, z, side1Icon.getMinU(), side1Icon.getMinV());
		tessellator.addVertexWithUV(x + 1, y + 1, z, side1Icon.getMaxU(), side1Icon.getMinV());
		tessellator.addVertexWithUV(x + 1, y, z, side1Icon.getMaxU(), side1Icon.getMaxV());

		tessellator.addVertexWithUV(x + 1, y, z + 1, side2Icom.getMinU(), side2Icom.getMaxV());
		tessellator.addVertexWithUV(x + 1, y + 1, z + 1, side2Icom.getMinU(), side2Icom.getMinV());
		tessellator.addVertexWithUV(x, y + 1, z + 1, side2Icom.getMaxU(), side2Icom.getMinV());
		tessellator.addVertexWithUV(x, y, z + 1, side2Icom.getMaxU(), side2Icom.getMaxV());

		tessellator.addVertexWithUV(x + 1, y, z, side3Icom.getMinU(), side3Icom.getMaxV());
		tessellator.addVertexWithUV(x + 1, y + 1, z, side3Icom.getMinU(), side3Icom.getMinV());
		tessellator.addVertexWithUV(x + 1, y + 1, z + 1, side3Icom.getMaxU(), side3Icom.getMinV());
		tessellator.addVertexWithUV(x + 1, y, z + 1, side3Icom.getMaxU(), side3Icom.getMaxV());

		tessellator.addVertexWithUV(x, y, z + 1, side4Icon.getMinU(), side4Icon.getMaxV());
		tessellator.addVertexWithUV(x, y + 1, z + 1, side4Icon.getMinU(), side4Icon.getMinV());
		tessellator.addVertexWithUV(x, y + 1, z, side4Icon.getMaxU(), side4Icon.getMinV());
		tessellator.addVertexWithUV(x, y, z, side4Icon.getMaxU(), side4Icon.getMaxV());
	}

	public static void addToTessallator(Tessellator tessellator, double x, double y, double z, Icon icon) {
		BlockTessallator.addToTessallator(tessellator, x, y, z, icon, icon, icon, icon, icon, icon);
	}
	
	public static void addToRenderer(Block block, VertexRenderer v, RenderBlocks blockRenderer, double x, double y, double z, Icon icon, Icon icon2, int trueX, int trueY, int trueZ) {
		
		
		v.renderBlockInWorld(block, blockRenderer, (int)trueX, (int)trueY, (int)trueZ, icon, icon2, x, y, z, 1, 1, 1);
	}
}
