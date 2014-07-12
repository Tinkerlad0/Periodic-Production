package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemElementHoe extends ItemHoe {

	protected ElementToolPart TOOLPART;

	public ItemElementHoe(ElementToolPart toolPart) {
		super(Chemistry.elementMaterials.getMaterialFromToolPart(toolPart));
		setCreativeTab(null);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_hoe");
		setTextureName(Chemistry.MODID + ":hoe");
		TOOLPART = toolPart;
		Chemistry.localiser.addLocalisation(this.getUnlocalizedName(), toolPart.getName() + " Hoe");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return TOOLPART.getColor();
	}
}
