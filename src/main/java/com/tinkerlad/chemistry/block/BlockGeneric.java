package com.tinkerlad.chemistry.block;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGeneric extends Block {

	public BlockGeneric(String name, Material material) {
		super(material);
		setCreativeTab(CreativeTab.MACHINE_TAB);
		setBlockName(name);
		setBlockTextureName(Chemistry.MODID + ":" + name);
	}

	public BlockGeneric(Material material) {
		super(material);
		setCreativeTab(CreativeTab.MACHINE_TAB);
	}
}
