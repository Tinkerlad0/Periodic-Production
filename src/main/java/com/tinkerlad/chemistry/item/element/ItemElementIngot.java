package com.tinkerlad.chemistry.item.element;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.entity.EntityElementItem;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemElementIngot extends Item {

    public Element ELEMENT;

    public ItemElementIngot(Element element) {
        super();
        this.ELEMENT = element;
        this.setUnlocalizedName("ingot_" + element.NAME);
        this.setCreativeTab(CreativeTab.ELEMENTS_TAB);
        this.setTextureName(Chemistry.MODID + ":ingot");
        Chemistry.LOCALISATIONS.addLocalisation(this.getUnlocalizedName(), element.NAME + " Ingot");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return ELEMENT.COLOR;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {
        info.add(ELEMENT.SYMBOL);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        EntityElementItem entity = new EntityElementItem(world, location.posX, location.posY, location.posZ, itemstack);
        return entity;
    }
}
