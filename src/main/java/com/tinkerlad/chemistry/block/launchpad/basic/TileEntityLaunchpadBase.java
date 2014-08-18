package com.tinkerlad.chemistry.block.launchpad.basic;

import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.utils.DimensionalPattern;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

import static com.tinkerlad.chemistry.utils.DimensionalPattern.*;

public class TileEntityLaunchpadBase extends TileEntity {

	DimensionalPattern dimensionalPattern;

	public TileEntityLaunchpadBase() {

		Row row11 = DimensionalPattern.createRow("IIIII");

		Row row21 = DimensionalPattern.createRow("IBBBI");
		Row row22 = DimensionalPattern.createRow("BBBBB");

		Row row31 = DimensionalPattern.createRow("IIIII");
		Row row33 = DimensionalPattern.createRow("IICII");

		Layer layer3 = DimensionalPattern.createLayer(row31, row31, row33, row31, row31);
		Layer layer2 = DimensionalPattern.createLayer(row21, row22, row22, row22, row21);
		Layer layer1 = DimensionalPattern.createLayer(row11, row11, row11, row11, row11);

		BlockState ironBlock = DimensionalPattern.createBlockState('I', Blocks.iron_block);
		BlockState ironBars = DimensionalPattern.createBlockState('B', Blocks.iron_bars);
		BlockState controller = DimensionalPattern.createBlockState('C', BlockList.LAUNCHPAD_BASIC);

		dimensionalPattern = DimensionalPattern.createPattern("launchpadBasic", layer1, layer2, layer3, ironBlock,
				                                                     ironBars, controller);
	}

	public boolean checkMultiblock() {

		return (dimensionalPattern.hasFormed(worldObj, xCoord - 2, yCoord - 2, zCoord - 2));
	}

	public void createMultiblock() {
		dimensionalPattern.convert(worldObj, xCoord - 2, yCoord - 2, zCoord - 2, Flag.IGNORE);
	}
}
