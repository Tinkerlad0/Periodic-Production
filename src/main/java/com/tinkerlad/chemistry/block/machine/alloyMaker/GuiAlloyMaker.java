package com.tinkerlad.chemistry.block.machine.alloyMaker;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiAlloyMaker extends GuiContainer {

    private ResourceLocation resourceLocation = new ResourceLocation(Chemistry.MODID, "textures/gui/alloy_maker.png");

    public GuiAlloyMaker(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
        super(new ContainerAlloyMaker(inventoryplayer, world, i, j, k));
        xSize = 176;
        ySize = 187;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Alloy"), 120, 5, 0x404040);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Crafting"), 120, 20, 0x404040);
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
    }
}
