package com.tinkerlad.chemistry.item.alloy;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemAlloy extends Item {

	public Alloy ALLOY;
	public String NAME;

	public ItemAlloy(Alloy alloy, String name) {
		super();
		this.ALLOY = alloy;
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTab.ALLOYS_TAB);
		if (ALLOY.getSTATE() == Alloy.State.SOLID) {
			this.setTextureName(Chemistry.MODID + ":dust");
		} else {
			this.setTextureName(Chemistry.MODID + ":phial");
		}
		this.NAME = name;
		Chemistry.localiser.addLocalisation(this.getUnlocalizedName(), alloy.getNAME());
	}

	public Alloy getALLOY() {
		return ALLOY;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return ALLOY.getCOLOR();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add(ALLOY.getChemicalFormula());
	}
}
