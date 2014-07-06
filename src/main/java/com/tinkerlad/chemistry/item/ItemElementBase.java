package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemElementBase extends Item {

	public Element ELEMENT;

	public ItemElementBase(Element element) {
		super();
		this.ELEMENT = element;
		this.setUnlocalizedName(element.NAME);
		this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
		this.setTextureName(Chemistry.MODID + ":dust");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return ELEMENT.COLOR;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add(ELEMENT.SYMBOL);
	}
}
