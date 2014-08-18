package com.tinkerlad.chemistry.block.launchpad.basic;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockGeneric;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.entity.rockets.EntityBasicRocket;
import com.tinkerlad.chemistry.reference.GuiID;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLaunchpadBasic extends BlockGeneric implements ITileEntityProvider {

	public BlockLaunchpadBasic() {
		super(Material.iron);
		this.setBlockName("launchpadBasic");
		this.setBlockTextureName(Chemistry.MODID + ":launchpad1");
		this.setCreativeTab(CreativeTab.MACHINE_TAB);
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 *
	 * @param var1
	 * @param var2
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityLaunchpadBasic();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		//FORM MULTIBLOCK

		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (player.isSneaking()) {
			if (tileEntity instanceof TileEntityLaunchpadBasic) {
				if (!world.isRemote) {
					((TileEntityLaunchpadBasic) tileEntity).createMultiblock();
					return true;
				}
			}
		}


		if (tileEntity instanceof TileEntityLaunchpadBasic) {
			if (((TileEntityLaunchpadBasic) tileEntity).checkMultiblock()) {
				if (!world.isRemote) {
					EntityBasicRocket rocket = new EntityBasicRocket(world);
					rocket.posX = x;
					rocket.posY = y + 1;
					rocket.posZ = z;
					world.spawnEntityInWorld(rocket);
					player.openGui(Chemistry.instance, GuiID.LAUNCHPAD_BASIC, world, x, y, z);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return false;
	}
}
