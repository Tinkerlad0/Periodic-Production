package com.tinkerlad.chemistry.rendering;

import com.tinkerlad.chemistry.item.alloy.ItemAlloy;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderer implements IItemRenderer {

	private static RenderItem renderItem = new RenderItem();

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		Item item = itemStack.getItem();
		if ((item instanceof ItemElementIngot || item instanceof ItemElementBase || item instanceof ItemAlloy) && type
				                                                                                                          == ItemRenderType.INVENTORY) {
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

		String text = "";

		if (itemStack.getItem() instanceof ItemElementBase) {
			ItemElementBase item = (ItemElementBase) itemStack.getItem();
			text = item.ELEMENT.SYMBOL;
		} else if (itemStack.getItem() instanceof ItemAlloy) {
			ItemAlloy item = (ItemAlloy) itemStack.getItem();
			text = item.ALLOY.getChemicalFormula();
		} else if (itemStack.getItem() instanceof ItemElementIngot) {
			ItemElementIngot item = (ItemElementIngot) itemStack.getItem();
			text = item.ELEMENT.SYMBOL;
		}


		fontRenderer.drawStringWithShadow(text, 1, 1, 0xFFFFFF);
	}
}
