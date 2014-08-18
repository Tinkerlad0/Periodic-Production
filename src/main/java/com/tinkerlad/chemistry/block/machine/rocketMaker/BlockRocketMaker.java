package com.tinkerlad.chemistry.block.machine.rocketMaker;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockGeneric;
import com.tinkerlad.chemistry.reference.GuiID;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRocketMaker extends BlockGeneric implements ITileEntityProvider {

	public BlockRocketMaker() {
		super(Material.anvil);
		setBlockName("rocketMaker");
		setBlockTextureName(Chemistry.MODID + ":rocketMaker");
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 *
	 * @param var1
	 * @param var2
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityRocketMaker();
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
	                                EntityPlayer player, int side, float par7, float par8,
	                                float par9) {
		if (player.isSneaking()) {
			return false;
		} else {
			if (!world.isRemote) {
				if (world.getTileEntity(x, y, z) instanceof TileEntityRocketMaker) {
					player.openGui(Chemistry.instance, GuiID.ROCKET_MAKER, world, x, y, z);
				}
			}
			return true;
		}
	}
}
