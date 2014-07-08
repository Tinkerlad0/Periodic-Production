package com.tinkerlad.chemistry.rendering;

import com.tinkerlad.chemistry.item.ItemElementBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class PhialItemRender implements IItemRenderer {

	private static RenderItem renderItem = new RenderItem();

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		Item item = itemStack.getItem();
		if (item instanceof ItemElementBase && type == ItemRenderType.INVENTORY) {
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {

		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

		// ====================== Render item texture ======================
		IIcon icon = itemStack.getIconIndex();
		renderItem.renderIcon(0, 0, icon, 16, 16);

		// ====================== Render text ======================
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		ItemElementBase item = (ItemElementBase) itemStack.getItem();
		String text = item.ELEMENT.SYMBOL;
		fontRenderer.drawStringWithShadow(text, 1, 1, 0xFFFFFF);
	}
}
