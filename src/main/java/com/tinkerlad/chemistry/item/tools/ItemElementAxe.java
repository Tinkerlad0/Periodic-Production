package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemElementAxe extends ItemAxe {

	protected ElementToolPart TOOLPART;

	public ItemElementAxe(ElementToolPart toolPart) {
		super(Chemistry.elementMaterials.getMaterialFromToolPart(toolPart));
		setCreativeTab(CreativeTab.ELEMENTS_TAB);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_axe");
		setTextureName(Chemistry.MODID + ":axe");
		TOOLPART = toolPart;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return TOOLPART.getColor();
	}
}
