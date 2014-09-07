package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGeneric extends Item {

    private int Color = 0xFFFFFF;

    public ItemGeneric(String itemName) {
        super();
        setCreativeTab(CreativeTab.MACHINE_TAB);
        setUnlocalizedName(itemName);
        setTextureName(Chemistry.MODID + ":" + itemName);
    }

    public ItemGeneric(String itemName, int colour) {
        super();
        setCreativeTab(CreativeTab.MACHINE_TAB);
        setUnlocalizedName(itemName);
        setTextureName(Chemistry.MODID + ":" + itemName);
        Color = colour;
        Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), itemName.toLowerCase());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return Color;
    }
}
