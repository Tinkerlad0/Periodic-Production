package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

public class ItemElementPickaxe extends ItemPickaxe {

	protected ElementToolPart TOOLPART;

	public ItemElementPickaxe(ElementToolPart toolPart) {
		super(Chemistry.elementMaterials.getMaterialFromToolPart(toolPart));
		setCreativeTab(CreativeTab.ELEMENTS_TAB);
		setUnlocalizedName(toolPart.getUnlocalisedName() + "_pick");
		setTextureName(Chemistry.MODID + ":pick");
		TOOLPART = toolPart;
		String localisedName = toolPart.getName() + " Pickaxe";
		Chemistry.localiser.addItemLocalisation(this.getUnlocalizedName() + ".name", toolPart.getName() + " Pickaxe");
		LogHelper.log(Level.INFO, "Registering " + this.getUnlocalizedName() + ".name as " + localisedName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return TOOLPART.getColor();
	}
}
