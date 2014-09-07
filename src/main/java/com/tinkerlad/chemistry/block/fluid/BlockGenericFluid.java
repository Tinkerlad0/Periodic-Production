package com.tinkerlad.chemistry.block.fluid;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockGenericFluid extends BlockFluidClassic {
    public int COLOR;
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BlockGenericFluid(Fluid fluid, int color) {
        super(fluid, Material.water);
        this.setBlockName(fluid.getName());
        this.COLOR = color;
        this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
    }

    public BlockGenericFluid(Fluid fluid, Material material, int color) {
        super(fluid, material);
        this.COLOR = color;
        this.setBlockName(fluid.getName());
        this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
    }

    @Override
    public int getBlockColor() {
        return COLOR;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(Chemistry.MODID + ":" + this.getUnlocalizedName().substring(5) + "_still");
        flowingIcon = register.registerIcon(Chemistry.MODID + ":" + this.getUnlocalizedName().substring(5) + "_flowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }
}
