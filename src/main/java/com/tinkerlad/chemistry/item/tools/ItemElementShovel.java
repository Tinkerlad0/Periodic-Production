package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemElementShovel extends ItemSpade {

    protected ElementToolPart TOOLPART;

    public ItemElementShovel(ElementToolPart toolPart) {
        super(Chemistry.ELEMENT_MATERIALS.getMaterialFromToolPart(toolPart));
        setCreativeTab(null);
        setUnlocalizedName(toolPart.getUnlocalisedName() + "_shovel");
        setTextureName(Chemistry.MODID + ":shovel");
        TOOLPART = toolPart;
        Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), toolPart.getName() + " Shovel");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return TOOLPART.getColor();
    }
}
