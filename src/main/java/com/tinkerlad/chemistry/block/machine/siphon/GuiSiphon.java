package com.tinkerlad.chemistry.block.machine.siphon;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiSiphon extends GuiContainer {

	private TileEntitySiphon tileEntitySiphon;

	public GuiSiphon(InventoryPlayer inventoryPlayer, TileEntitySiphon entitySiphon) {
		super(new ContainerSiphon(inventoryPlayer, entitySiphon));
		this.tileEntitySiphon = entitySiphon;
		xSize = 176;
		ySize = 187;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
	}

	@Override
	public void drawGuiContainerForegroundLayer(int x, int y) {
		String containerName = StatCollector.translateToLocal(tileEntitySiphon.getInventoryName());
		fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Chemistry.MODID, "textures/gui/siphon.png"));
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
		int scaleAdjustment;

		if (this.tileEntitySiphon.getState() == 1) {
			scaleAdjustment = this.tileEntitySiphon.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(xStart + 45, yStart + 36 + 34 - scaleAdjustment, 176, 12 - scaleAdjustment, 14, scaleAdjustment + 2);
		}

		scaleAdjustment = this.tileEntitySiphon.getCookProgressScaled(24);
		this.drawTexturedModalRect(xStart + 76, yStart + 39, 176, 14, scaleAdjustment + 1, 16);
	}
}
