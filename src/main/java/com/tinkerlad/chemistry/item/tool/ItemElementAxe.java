package com.tinkerlad.chemistry.item.tool;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemElementAxe extends ItemAxe {
    public ItemElementAxe(ToolMaterial material) {
        super(material);
        this.setCreativeTab(null);
        this.setTextureName(Chemistry.MODID + ":axe");
        this.setUnlocalizedName("elementAxe");
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        return stack.getTagCompound().getFloat("pp_speed");
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return stack.getTagCompound().getInteger("pp_damage");
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int dmg) {
        return (stack.getTagCompound().getInteger("pp_color"));
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();

            stack.stackTagCompound.setFloat("pp_speed", 1);
            stack.stackTagCompound.setInteger("pp_damage", 2);
            stack.stackTagCompound.setInteger("pp_color", 3);
            stack.stackTagCompound.setString("pp_name", "4");
        }
    }
}
