package com.tinkerlad.chemistry.rendering.gui;

import com.tinkerlad.chemistry.block.machine.siphon.ContainerSiphon;
import com.tinkerlad.chemistry.block.machine.siphon.TileEntitySiphon;
import com.tinkerlad.chemistry.reference.GuiID;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GuiID.SIPHON) {
			TileEntitySiphon tileEntitySiphon = (TileEntitySiphon) world.getTileEntity(x, y, z);
			return new ContainerSiphon(player.inventory, tileEntitySiphon);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GuiID.SIPHON) {
			TileEntitySiphon tileEntitySiphon = (TileEntitySiphon) world.getTileEntity(x, y, z);
			return new GuiSiphon(player.inventory, tileEntitySiphon);
		}
		return null;
	}
}
