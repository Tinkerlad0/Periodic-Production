package com.tinkerlad.chemistry.item.tools;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemElementSword extends ItemSword {

    protected ElementToolPart TOOLPART;

    public ItemElementSword(ElementToolPart toolPart) {
        super(Chemistry.ELEMENT_MATERIALS.getMaterialFromToolPart(toolPart));
        setCreativeTab(null);
        setUnlocalizedName(toolPart.getUnlocalisedName() + "_sword");
        setTextureName(Chemistry.MODID + ":sword");
        TOOLPART = toolPart;
        Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), toolPart.getName() + " Sword");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return TOOLPART.getColor();
    }
}
