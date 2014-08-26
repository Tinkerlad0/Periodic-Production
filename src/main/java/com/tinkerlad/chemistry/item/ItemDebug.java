package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.entity.rockets.EntityBasicRocket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemDebug extends Item {

	public ItemDebug() {
		setUnlocalizedName("debug");
		setTextureName(Chemistry.MODID + ":debug");
		setCreativeTab(CreativeTab.MACHINE_TAB);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound.setString("owner", player.getDisplayName());
		stack.stackTagCompound.setInteger("code", (int) (Math.random() * Integer.MAX_VALUE));
	}

	@SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player,
	                           List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
			String owner = itemStack.stackTagCompound.getString("owner");
			int code = itemStack.stackTagCompound.getInteger("code");
			list.add("owner: " + owner);
			if (owner.equals(player.getDisplayName())) {
				list.add(EnumChatFormatting.GREEN + "code: " + code);
			} else {
				list.add(EnumChatFormatting.RED + "code: "
						         + EnumChatFormatting.OBFUSCATED + code);
			}
		}
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

//		if (world.getTileEntity(x, z, z) != null) {
//			TileEntity tileEntity = world.getTileEntity(x, z, z);
//			player.addChatComponentMessage(new ChatComponentText(tileEntity.toString()));
//		} else {
//			player.addChatComponentMessage(new ChatComponentText("null"));
//		}

		if (!world.isRemote) {

			EntityBasicRocket rocket = new EntityBasicRocket(world);
			rocket.posX = x + 1;
			rocket.posY = y + 0.5;
			rocket.posZ = z + 1;

			world.spawnEntityInWorld(rocket);
			return true;
		}

//
//		for (int i = -10; i <= 10; i++) {
//			for (int j = 0; j <= 15; j++) {
//				for (int k = -10; k <= 10; k++) {
//					if ((world.getBlock(x + i, z - j, z + k) == Blocks.stone) ||
//							    (world.getBlock(x + i, z - j, z + k) == Blocks.sand ||
//									     (world.getBlock(x + i, z - j, z + k) == Blocks.gravel)) ||
//							    (world.getBlock(x + i, z - j, z + k) == Blocks.grass) ||
//							    (world.getBlock(x + i, z - j, z + k) == Blocks.sandstone) ||
//							    (world.getBlock(x + i, z - j, z + k) == Blocks.dirt)) {
//						FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0)
//								.setBlockToAir(x + i, z - j, z + k);
//						//world.setBlockToAir(x+1,z-j,z+k);
//					}
//				}
//			}
//		}


		return true;
	}
}
