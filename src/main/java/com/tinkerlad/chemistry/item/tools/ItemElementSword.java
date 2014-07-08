package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemElementSword extends ItemSword {

	protected int color;

	public ItemElementSword(ElementToolPart toolPart) {
		super(Chemistry.elementMaterials.getMaterialFromToolPart(toolPart));
		setCreativeTab(CreativeTab.ELEMENTS_TAB);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_sword");
		setTextureName(Chemistry.MODID + ":pickaxe");
		color = toolPart.getColor();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return color;
	}
}
