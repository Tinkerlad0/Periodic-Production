package com.tinkerlad.chemistry.block.alloy;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockGeneric;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockAlloyBricks extends BlockGeneric {

	public Alloy ALLOY;

	public BlockAlloyBricks(Alloy alloy) {
		super(Material.iron);
		this.ALLOY = alloy;
		setBlockName(ALLOY.getNAME() + "Block");
		setBlockTextureName(Chemistry.MODID + ":block");
		setCreativeTab(CreativeTab.ELEMENTS_TAB);
		Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), alloy.getNAME() + " Block");
	}

	@Override
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
		return ALLOY.getCOLOR();
	}
}
