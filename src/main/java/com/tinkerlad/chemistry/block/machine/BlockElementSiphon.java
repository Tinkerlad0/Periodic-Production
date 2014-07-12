package com.tinkerlad.chemistry.block.machine;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.GuiID;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockElementSiphon extends BlockMachine implements ITileEntityProvider {

	public BlockElementSiphon() {
		super(Material.anvil);
		this.setHardness(5.0f);
		this.setBlockName("elementSiphon");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntitySiphon();
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntitySiphon) {
			if (((TileEntitySiphon) tile).getState() == 1) {
				world.spawnParticle("flame", (double) x + 0.5F, (double) y + 0.33F, (double) z + 0.825F, 0.0D, 0.0D,
						                   0.0D);

				String smoke = "smoke";
				world.spawnParticle(smoke, (double) x + 0.5F, (double) y + 0.7F, (double) z + 0.0F, 0.0D, 0.05D,
						                   0.0D);
				world.spawnParticle(smoke, (double) x + 0.5F, (double) y + 0.7F, (double) z + 1.0F, 0.0D, 0.05D, 0.0D);
				world.spawnParticle(smoke, (double) x + 0.0F, (double) y + 0.7F, (double) z + 0.5F, 0.0D, 0.05D, 0.0D);
				world.spawnParticle(smoke, (double) x + 1.0F, (double) y + 0.7F, (double) z + 0.5F, 0.0D, 0.05D, 0.0D);
			}
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int faceHit, float par7, float par8, float par9) {
		if (player.isSneaking()) {
			return false;
		} else {
			if (!world.isRemote) {
				if (world.getTileEntity(x, y, z) instanceof TileEntitySiphon) {
					player.openGui(Chemistry.instance, GuiID.SIPHON, world, x, y, z);
				}
			}
			return true;
		}
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if (world.getTileEntity(x, y, z) instanceof TileEntitySiphon) {
			if (((TileEntitySiphon) world.getTileEntity(x, y, z)).getState() == 1) {
				return 15;
			}
		}

		return super.getLightValue(world, x, y, z);
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
}
