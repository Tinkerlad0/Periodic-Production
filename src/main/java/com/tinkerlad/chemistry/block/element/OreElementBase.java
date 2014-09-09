package com.tinkerlad.chemistry.block.element;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockGeneric;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.reference.Enums;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;

import java.util.ArrayList;
import java.util.Random;

public class OreElementBase extends BlockGeneric {

    public Element ELEMENT;

    public OreElementBase(Element element) {
        super(Material.rock);
        this.ELEMENT = element;
        this.setBlockName(element.NAME);
        this.setBlockTextureName("minecraft" + ":" + "stone");
        this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
        this.setHardness(ELEMENT.DENSITY);
        Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), element.NAME + " Ore");
        setTickRandomly(true);
        this.setHarvestLevel("pickaxe", Utils.getHarvestLevel(element.HARDNESS.getValue(), element.DENSITY));
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (world.getBlock(x + i, y + j, z + k) instanceof BlockFluidFinite) {
                        fluidContacted(world, x, y, z, random);
                    }
                    if (world.getBlock(x + i, y + j, z + k) instanceof BlockFluidClassic) {
                        fluidContacted(world, x, y, z, random);
                    }
                    if (world.getBlock(x + i, y + j, z + k) instanceof BlockFluidBase) {
                        fluidContacted(world, x, y, z, random);
                    }
                }
            }
        }
    }

    @Override
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
        return ELEMENT.COLOR;
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion) {
        switch (ELEMENT.ElementTYPE) {

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
        drops.add(new ItemStack(Chemistry.ELEMENT_REGISTRY.getOreFromElement(ELEMENT)));
        if (Chemistry.RANDOM.nextInt(40 / (fortune > 1 ? fortune - 1 : 1)) == 0 && ELEMENT.STATE != Enums.State.GAS
                && metadata == 1) {
            drops.add(new ItemStack(Chemistry.ELEMENT_REGISTRY.getBaseItemFromElement(ELEMENT)));
        }

        return drops;
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
        if (ELEMENT.ElementTYPE == Enums.ElementType.ALKALINE_METAL) {
            world.createExplosion(explosion.exploder, x, y, z, 1.5F * ELEMENT.SERIES, ELEMENT.SERIES > 4);
            world.setBlockToAir(x, y, z);
        }
    }

    protected void fluidContacted(World world, int x, int y, int z, Random random) {
        world.setBlockToAir(x, y, z);
        world.createExplosion((Entity) null, x, y, z, random.nextFloat() * 2, true);
    }
}
