package com.tinkerlad.chemistry.registry.referenceRegistries;

import com.tinkerlad.chemistry.block.fluid.BlockGenericFluid;
import com.tinkerlad.chemistry.config.ConfigHandler;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.HashMap;
import java.util.Map;

public class FluidRegister {
    public static Map<Element, Fluid> elementFluidHashMap = new HashMap<Element, Fluid>();
    public static Map<Fluid, BlockGenericFluid> genericFluidMap = new HashMap<Fluid, BlockGenericFluid>();
    public static Map<String, Fluid> fluidMap = new HashMap<String, Fluid>();

    public static boolean addFluid(Element element, Fluid fluid) {
        if (elementFluidHashMap.containsKey(element)) {
            return false;
        }
        FluidRegistry.registerFluid(fluid);
        elementFluidHashMap.put(element, fluid);

        fluid.setGaseous(element.STATE == Element.State.GAS);

        BlockGenericFluid fluidBlock = new BlockGenericFluid(fluid, Material.coral, element.COLOR);
        GameRegistry.registerBlock(fluidBlock, element.NAME);
        genericFluidMap.put(fluid, fluidBlock);

        fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName());

        if (ConfigHandler.VERBOSE) {
            LogHelper.info("--Registered " + fluid.getName() + " as a " + (fluid.isGaseous() ? "gas" : "liquid"));
        }

        return true;
    }

    public Fluid getFluid(Alloy alloy) {
        return elementFluidHashMap.get(alloy);
    }
}
