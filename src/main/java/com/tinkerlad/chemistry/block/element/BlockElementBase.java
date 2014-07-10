package com.tinkerlad.chemistry.block.element;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockElementBase extends Block {

	public Element ELEMENT;

	public BlockElementBase(Element element) {
		super(Material.iron);
		ELEMENT = element;
		setBlockName(ELEMENT.NAME + "Block");
		setBlockTextureName(Chemistry.MODID + ":block");
		setCreativeTab(CreativeTab.ELEMENTS_TAB);
		Chemistry.localiser.addLocalisation(this.getUnlocalizedName(), element.NAME + " Block");
	}

	@Override
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
		return ELEMENT.COLOR;
	}
}
