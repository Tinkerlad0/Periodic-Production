package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemDebug extends Item {

	public ItemDebug() {
		setUnlocalizedName("debug");
		setTextureName(Chemistry.MODID + ":debug");
		setCreativeTab(CreativeTab.MACHINE_TAB);
	}

	@SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {

		info.add("This item is for DEBUGGING only");
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

//		if (world.getTileEntity(x, y, z) != null) {
//			TileEntity tileEntity = world.getTileEntity(x, y, z);
//			player.addChatComponentMessage(new ChatComponentText(tileEntity.toString()));
//		} else {
//			player.addChatComponentMessage(new ChatComponentText("null"));
//		}

		for (int i = -25; i <= 25; i++) {
			for (int j = 0; j <= 25; j++) {
				for (int k = -25; k <= 25; k++) {
					if ((world.getBlock(x + i, y - j, z + k) == Blocks.stone) ||
							    (world.getBlock(x + i, y - j, z + k) == Blocks.sand ||
									     (world.getBlock(x + i, y - j, z + k) == Blocks.gravel)) ||
							    (world.getBlock(x + i, y - j, z + k) == Blocks.grass) ||
							    (world.getBlock(x + i, y - j, z + k) == Blocks.dirt)) {
						world.setBlockToAir(x + i, y - j, z + k);
					}
				}
			}
		}


		return true;
	}
}
