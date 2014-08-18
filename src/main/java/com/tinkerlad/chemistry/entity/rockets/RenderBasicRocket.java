package com.tinkerlad.chemistry.entity.rockets;

import com.tinkerlad.chemistry.Chemistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBasicRocket extends Render {

	private static final ResourceLocation texture = new ResourceLocation(Chemistry.MODID,
			                                                                    "textures/model/basicRocket.png");

	protected IModelCustom modelCustom;

	public RenderBasicRocket() {
		shadowSize = 0.5F;
		modelCustom = AdvancedModelLoader.loadModel(new ResourceLocation(Chemistry.MODID,
				                                                                "models/basicRocket.obj"));
	}

	public void renderRocket(EntityBasicRocket rocket, double x, double y, double z, float yaw, float partialTickTime) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180 - rocket.rotationPitch, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180 - rocket.rotationYaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);


		bindEntityTexture(rocket);

		modelCustom.renderAll();

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		this.renderRocket((EntityBasicRocket) entity, x, y, z, yaw, partialTickTime);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 *
	 * @param var1
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
}
