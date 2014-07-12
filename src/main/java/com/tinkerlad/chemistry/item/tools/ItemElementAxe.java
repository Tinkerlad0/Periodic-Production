package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemElementAxe extends ItemAxe {

	protected ElementToolPart TOOLPART;

	public ItemElementAxe(ElementToolPart toolPart) {
		super(Chemistry.elementMaterials.getMaterialFromToolPart(toolPart));
		setCreativeTab(null);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_axe");
		setTextureName(Chemistry.MODID + ":axe");
		TOOLPART = toolPart;
		Chemistry.localiser.addLocalisation(this.getUnlocalizedName(), toolPart.getName() + " Axe");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return TOOLPART.getColor();
	}
}
