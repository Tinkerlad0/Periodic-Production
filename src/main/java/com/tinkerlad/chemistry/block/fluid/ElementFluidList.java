package com.tinkerlad.chemistry.block.fluid;

import com.tinkerlad.chemistry.registry.annotations.RegisterFluid;
import net.minecraftforge.fluids.Fluid;

public class ElementFluidList {

    @RegisterFluid(fluidName = "testingFluid")
    Fluid TEST_FLUID = new Fluid("testingFluid");
}
