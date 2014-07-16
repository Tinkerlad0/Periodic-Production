package com.tinkerlad.chemistry.block.element;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
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
		Chemistry.localiser.addLocalisation(this.getUnlocalizedName(), element.NAME + " Ore");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		if (random.nextInt(50) == 0) {
			return Chemistry.converter.getBaseItemFromElement(ELEMENT);
		} else {
			return Item.getItemFromBlock(this);
		}
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
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.clear();
		drops.add(new ItemStack(Chemistry.converter.getOreFromElement(ELEMENT)));
		if (Chemistry.RANDOM.nextInt(40 / fortune) == 0 && ELEMENT.STATE != Element.State.GAS) {
			drops.add(new ItemStack(Chemistry.converter.getBaseItemFromElement(ELEMENT)));
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
