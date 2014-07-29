package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemElementPickaxe extends ItemPickaxe {

	protected ElementToolPart TOOLPART;

	public ItemElementPickaxe(ElementToolPart toolPart) {
		super(Chemistry.ELEMENT_MATERIALS.getMaterialFromToolPart(toolPart));
		setCreativeTab(null);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_pick");
		setTextureName(Chemistry.MODID + ":pick");
		TOOLPART = toolPart;
		Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), toolPart.getName() + " Pickaxe");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return TOOLPART.getColor();
	}
}
