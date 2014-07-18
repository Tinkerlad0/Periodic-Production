package com.tinkerlad.chemistry.block.machine.alloyMaker;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.machine.BlockMachine;
import com.tinkerlad.chemistry.reference.GuiID;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAlloyMaker extends BlockMachine implements ITileEntityProvider {

	public BlockAlloyMaker() {
		super(Material.anvil);
		this.setHardness(5.0f);
		this.setBlockName("alloyMaker");
		this.setBlockTextureName(Chemistry.MODID + ":alloy_maker");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityAlloyMaker();
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int faceHit, float par7, float par8, float par9) {
		if (player.isSneaking()) {
			return false;
		} else {
			if (!world.isRemote) {
				if (world.getTileEntity(x, y, z) instanceof TileEntityAlloyMaker) {
					player.openGui(Chemistry.instance, GuiID.ALLOY_MAKER, world, x, y, z);
				}
			}
			return true;
		}
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
}
