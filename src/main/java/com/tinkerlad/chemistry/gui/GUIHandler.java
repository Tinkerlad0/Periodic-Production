package com.tinkerlad.chemistry.gui;

import com.tinkerlad.chemistry.block.launchpad.basic.ContainerLaunchpadBasic;
import com.tinkerlad.chemistry.block.launchpad.basic.GuiLaunchpadBasic;
import com.tinkerlad.chemistry.block.machine.alloyMaker.ContainerAlloyMaker;
import com.tinkerlad.chemistry.block.machine.alloyMaker.GuiAlloyMaker;
import com.tinkerlad.chemistry.block.machine.rocketMaker.ContainerRocketMaker;
import com.tinkerlad.chemistry.block.machine.rocketMaker.GuiRocketMaker;
import com.tinkerlad.chemistry.block.machine.siphon.ContainerSiphon;
import com.tinkerlad.chemistry.block.machine.siphon.GuiSiphon;
import com.tinkerlad.chemistry.block.machine.siphon.TileEntitySiphon;
import com.tinkerlad.chemistry.reference.GuiID;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		switch (id) {
			case GuiID.SIPHON:
				TileEntitySiphon tileEntitySiphon = (TileEntitySiphon) world.getTileEntity(x, y, z);
				return new ContainerSiphon(player.inventory, tileEntitySiphon);
			case GuiID.ALLOY_MAKER:
				return new ContainerAlloyMaker(player.inventory, world, x, y, z);
			case GuiID.LAUNCHPAD_BASIC:
				return new ContainerLaunchpadBasic(player.inventory, world, x, y, z);
			case GuiID.ROCKET_MAKER:
				return new ContainerRocketMaker(player.inventory, world, x, y, z);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		switch (id) {
			case GuiID.SIPHON:
				TileEntitySiphon tileEntitySiphon = (TileEntitySiphon) world.getTileEntity(x, y, z);
				return new GuiSiphon(player.inventory, tileEntitySiphon);
			case GuiID.ALLOY_MAKER:
				return new GuiAlloyMaker(player.inventory, world, x, y, z);
			case GuiID.LAUNCHPAD_BASIC:
				return new GuiLaunchpadBasic(player.inventory, world, x, y, z);
			case GuiID.ROCKET_MAKER:
				return new GuiRocketMaker(player.inventory, world, x, y, z);
		}
		return null;
	}
}
