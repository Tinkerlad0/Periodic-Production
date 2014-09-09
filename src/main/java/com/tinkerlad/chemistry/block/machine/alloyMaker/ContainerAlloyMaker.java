package com.tinkerlad.chemistry.block.machine.alloyMaker;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.recipe.alloy.AlloyCraftingManager;
import com.tinkerlad.chemistry.recipe.backend.ShapelessRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ContainerAlloyMaker extends Container {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerAlloyMaker(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
        craftMatrix = new InventoryCrafting(this, 5, 5);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = i;
        posY = j;
        posZ = k;
        this.addSlotToContainer(new SlotCraftingAlloy(inventoryplayer.player, craftMatrix, craftResult, 0, 134, 43,
                worldObj));
        for (int l = 0; l < 5; l++) {
            for (int k1 = 0; k1 < 5; k1++) {
                this.addSlotToContainer(new Slot(craftMatrix, k1 + l * 5, 8 + k1 * 18, 7 + l * 18));
            }
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
        ItemStack result = AlloyCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj);

        if (result == null) {
            craftResult.setInventorySlotContents(0, null);
            return;
        } else if (result.getItem() == null) {
            craftResult.setInventorySlotContents(0, null);
            return;
        }

        List recipeList = AlloyCraftingManager.getInstance().getRecipeList();
        for (Object obj : recipeList) {
            if (obj instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes) obj;
                Item output = recipe.getRecipeOutput().getItem();
                if (output == result.getItem()) {
                    int count = recipe.getRecipeSize();
                    int matches = 0;
                    for (Object obj2 : recipe.recipeItems) {
                        for (int slot = 0; slot < this.craftMatrix.getSizeInventory(); slot++) {
                            ItemStack currentStack = this.craftMatrix.getStackInSlot(slot);
                            ItemStack desiredStack = (ItemStack) obj2;

                            if (currentStack != null) {
                                if (currentStack.getItem() == desiredStack.getItem() && currentStack.stackSize >= desiredStack.stackSize) {
                                    matches++;
                                }
                            }
                        }
                    }
                    if (matches == count) {
                        craftResult.setInventorySlotContents(0, AlloyCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
                    }
                    return;
                }
            }
        }
        craftResult.setInventorySlotContents(0, null);
    }

    public boolean canInteractWith(EntityPlayer entityplayer) {
        return entityplayer.getDistanceSq((double) posX + 0.5D, (double) posY + 0.5D, (double) posZ + 0.5D) <= 64D;
    }
}
