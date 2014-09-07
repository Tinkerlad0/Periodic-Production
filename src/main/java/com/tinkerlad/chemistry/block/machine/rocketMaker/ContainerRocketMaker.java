package com.tinkerlad.chemistry.block.machine.rocketMaker;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.machine.alloyMaker.SlotCraftingAlloy;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.rocketry.base.BaseCanister;
import com.tinkerlad.chemistry.item.rocketry.base.BaseFin;
import com.tinkerlad.chemistry.item.rocketry.base.BaseModule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ContainerRocketMaker extends Container {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerRocketMaker(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
        craftMatrix = new InventoryCrafting(this, 9, 3);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = i;
        posY = j;
        posZ = k;
        this.addSlotToContainer(new SlotCraftingAlloy(inventoryplayer.player, craftMatrix, craftResult, 0, 8, 79,
                worldObj));

        List<Item> fins = new ArrayList<Item>();
        fins.add(ItemList.FIN);

        List<Item> modules = new ArrayList<Item>();
        modules.add(ItemList.INVENTORY_MODULE);
        modules.add(ItemList.NOSE_CONE);

        List<Item> engines = new ArrayList<Item>();
        engines.add(ItemList.CANISTER_CANDY);
        engines.add(ItemList.CANISTER_ZINC_SULFUR);

        List<Item> edges = fins;
        edges.addAll(engines);

        List<Item> middle = modules;
        middle.addAll(engines);

        for (int t = 0; t < 5; t++) {
            this.addSlotToContainer(new SlotRocketry(craftMatrix, 5 + t, 80 + t * 18, 34, edges));
        }

        for (int m = 0; m < 9; m++) {
            this.addSlotToContainer(new SlotRocketry(craftMatrix, 10 + m, 8 + m * 18, 52, middle));
        }

        for (int b = 0; b < 5; b++) {
            this.addSlotToContainer(new SlotRocketry(craftMatrix, 22 + b, 80 + b * 18, 70, edges));
        }

        for (int i1 = 0; i1 < 3; i1++) {
            for (int l1 = 0; l1 < 9; l1++) {
                this.addSlotToContainer(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18,
                        106 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18, 164));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par2 == 0) {
                if (!mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }
            } else if (par2 >= 10 && par2 < 37) {
                if (!mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (par2 >= 37 && par2 < 46) {
                if (!mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize != itemstack.stackSize) {
                slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            } else {
                return null;
            }
        }
        return itemstack;
    }

    public void onContainerClosed(EntityPlayer entityplayer) {
        super.onContainerClosed(entityplayer);
        if (worldObj.isRemote) {
            return;
        }
        for (int i = 0; i < 25; i++) {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if (itemstack != null) {
                entityplayer.entityDropItem(itemstack, (float) (Chemistry.RANDOM.nextFloat() * Math.PI));
            }
        }
    }

    public void onCraftMatrixChanged(IInventory iinventory) {

        if (!isValid()) {
            craftResult.setInventorySlotContents(0, null);
            return;
        }
        int stability, thrust, time, slots;
        stability = thrust = time = slots = 0;

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (craftMatrix.getStackInSlot(i) == null) continue;
            if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseModule) {
                stability += 2;
                if (craftMatrix.getStackInSlot(i).getItem() == ItemList.INVENTORY_MODULE) {
                    slots += 1;
                }
            }

            if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseCanister) {
                thrust += 50;
                time += 25;
                stability -= 10;
                if (craftMatrix.getStackInSlot(i).getItem() == ItemList.CANISTER_CANDY) {
                    time += 5;
                } else if (craftMatrix.getStackInSlot(i).getItem() == ItemList.CANISTER_ZINC_SULFUR) {
                    thrust -= 10;
                    time -= 5;
                    stability += 5;
                }
            }

            if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseFin) {
                stability += 10;
                if (!(time == 0)) {
                    time += 2;
                }
            }
        }

        craftResult.setInventorySlotContents(0, null);

        ItemStack result = new ItemStack(ItemList.CUSTOM_ROCKET);
        result.stackTagCompound = new NBTTagCompound();
        result.stackTagCompound.setInteger("Stability", stability);
        result.stackTagCompound.setInteger("Thrust", thrust);
        result.stackTagCompound.setInteger("BurnTime", time);
        result.stackTagCompound.setInteger("Slots", slots);

        craftResult.setInventorySlotContents(0, result);
    }

    public boolean canInteractWith(EntityPlayer entityplayer) {
        return entityplayer.getDistanceSq((double) posX + 0.5D, (double) posY + 0.5D, (double) posZ + 0.5D) <= 64D;
    }

    public boolean isValid() {
        boolean fins, engine, nose;

        fins = engine = nose = false;

        //check integrity
        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (craftMatrix.getStackInSlot(i) != null) {
                if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseFin) {
                    fins = true;
                }

                if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseModule) {
                    nose = true;
                }

                if (craftMatrix.getStackInSlot(i).getItem() instanceof BaseCanister) {
                    engine = true;
                }
            }
        }

        return (fins && engine && nose);
    }
}
