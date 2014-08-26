package com.tinkerlad.chemistry.block.launchpad.basic;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.entity.rockets.EntityBasicRocket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiLaunchpadBase extends GuiContainer {

	private ResourceLocation resourceLocation = new ResourceLocation(Chemistry.MODID, "textures/gui/launchpad.png");

	private World earth;
	private int x, y, z;
	private boolean launched = false;

	public GuiLaunchpadBase(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
		super(new ContainerLaunchpadBase(inventoryplayer, world, i, j, k));
		xSize = 176;
		ySize = 187;
		this.earth = world;
		x = i;
		y = j;
		z = k;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Launchpad"), 60, 11, 0x404040);

		this.buttonList.add(new GuiButton(0, guiLeft + 61, guiTop + 53, 53, 17, "LAUNCH!"));
		//this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 - 14, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(resourceLocation);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
	}

	public void onGuiClosed() {
		super.onGuiClosed();
		launched = false;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public void actionPerformed(GuiButton button) {

		switch (button.id) {
			case 0:
				if (launched) { break; }
				System.out.println("Launched");
				EntityBasicRocket rocket = new EntityBasicRocket(earth);
				rocket.posX = x;
				rocket.posY = y + 1;
				rocket.posZ = z;
				earth.spawnEntityInWorld(rocket);
				launched = true;
				break;
		}
	}
}
