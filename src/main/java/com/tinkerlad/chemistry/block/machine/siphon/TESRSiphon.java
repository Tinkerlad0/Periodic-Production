package com.tinkerlad.chemistry.block.machine.siphon;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class TESRSiphon extends TileEntitySpecialRenderer {

    private IModelCustom modelCustom;
    private ResourceLocation texture;

    public TESRSiphon() {
        modelCustom = AdvancedModelLoader.loadModel(new ResourceLocation(Chemistry.MODID, "/models/machine/siphon.obj"));
        texture = new ResourceLocation(Chemistry.MODID, "models/machine/siphon.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {

        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        this.bindTexture(texture);
        modelCustom.renderAll();
        GL11.glPopMatrix();
    }
}
