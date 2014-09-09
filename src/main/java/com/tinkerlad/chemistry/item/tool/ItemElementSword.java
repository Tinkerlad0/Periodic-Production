package com.tinkerlad.chemistry.item.tool;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class ItemElementSword extends ItemSword {
    public ItemElementSword(ToolMaterial material) {
        super(material);
        this.setCreativeTab(null);
        this.setTextureName(Chemistry.MODID + ":sword");
        this.setUnlocalizedName("elementSword");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean someBool) {
        if (stack.stackTagCompound != null) {
            list.add("Damage: " + stack.stackTagCompound.getFloat("pp_speed"));
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase enemy, EntityLivingBase player) {
        if (enemy.canAttackWithItem() && stack.hasTagCompound()) {
            enemy.attackEntityFrom(DamageSource.causeMobDamage(player), stack.getTagCompound().getFloat("pp_speed"));
        }
        return true;
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
