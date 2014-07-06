package com.tinkerlad.chemistry.block.element;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class OreElementBase extends Block {

	public Element ELEMENT;

	public OreElementBase(Element element) {
		super(Material.rock);
		this.ELEMENT = element;
		this.setBlockName(element.NAME);
		this.setBlockTextureName("minecraft" + ":" + "stone");
		this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
		this.setHardness(ELEMENT.DENSITY);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Chemistry.converter.getBaseItemFromElement(ELEMENT);
	}

	@Override
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
		return ELEMENT.COLOR;
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		switch (ELEMENT.TYPE) {

			case ALKALINE_METAL:
				return explosion.isFlaming ? false : true;

			case EARTH_METAL:
				return true;

			case TRANSITION:
				return true;

			case NON_METAL:
				return true;

			case METALLOID:
				return true;

			case GAS:
				return false;

			case HALOGEN:
				return false;

			case NOBLE_GAS:
				return false;
		}
		return false;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		int drops = 1;
		if (fortune >= 1) {
			drops += random.nextInt(3 * fortune);
		}
		return drops;
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
		if (ELEMENT.TYPE == Element.Type.ALKALINE_METAL) {
			world.createExplosion(explosion.exploder, x, y, z, 1.5F * ELEMENT.SERIES, ELEMENT.SERIES > 4);
			world.setBlockToAir(x, y, z);
		}
	}
}
