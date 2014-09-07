package com.tinkerlad.chemistry.gui;

import com.tinkerlad.chemistry.block.machine.alloyMaker.ContainerAlloyMaker;
import com.tinkerlad.chemistry.block.machine.alloyMaker.GuiAlloyMaker;
import com.tinkerlad.chemistry.reference.GuiID;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case GuiID.ALLOY_MAKER:
                return new ContainerAlloyMaker(player.inventory, world, x, y, z);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case GuiID.ALLOY_MAKER:
                return new GuiAlloyMaker(player.inventory, world, x, y, z);
        }
        return null;
    }
}
