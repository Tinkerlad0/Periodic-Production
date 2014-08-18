package com.tinkerlad.chemistry.item.rocketry;

import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.item.ItemGeneric;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class ItemCustomRocket extends ItemGeneric {

	public ItemCustomRocket() {
		super("customRocket");
		this.setCreativeTab(CreativeTab.ROCKETRY_TAB);
		this.setTextureName("custom_rocket");
	}

	/**
	 * Called when item is crafted/smelted. Used only by maps so far.
	 */
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger("Stability", 0);
		stack.stackTagCompound.setInteger("Thrust", 0);
		stack.stackTagCompound.setInteger("Burn Time", 20);
		stack.stackTagCompound.setInteger("Slots", 1);
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (stack.stackTagCompound != null) {
			int stability = stack.stackTagCompound.getInteger("Stability");
			int thrust = stack.stackTagCompound.getInteger("Thrust");
			int time = stack.stackTagCompound.getInteger("Burn Time");
			int slots = stack.stackTagCompound.getInteger("Slots");
			list.add("Stability: " + stability);
			list.add("Thrust: " + thrust);
			list.add("Time: " + time);
			list.add("Slots: " + slots);
		}
	}
}
