package com.tinkerlad.chemistry.block.machine;

import com.tinkerlad.chemistry.item.ItemElementBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerSiphon extends Container {

	private final int PLAYER_INVENTORY_ROWS = 3;
	private final int PLAYER_INVENTORY_COLUMNS = 9;
	private TileEntitySiphon tileEntitySiphon;
	private int lastDeviceCookTime;
	private int lastFuelBurnTime;
	private int lastItemCookTime;

	public ContainerSiphon(InventoryPlayer inventoryPlayer, TileEntitySiphon tileEntitySiphon) {
		this.tileEntitySiphon = tileEntitySiphon;

		this.addSlotToContainer(new Slot(tileEntitySiphon, TileEntitySiphon.FUEL_INVENTORY_INDEX, 44, 74));
		this.addSlotToContainer(new Slot(tileEntitySiphon, TileEntitySiphon.INPUT_INVENTORY_INDEX, 44, 18));
		this.addSlotToContainer(new Slot(tileEntitySiphon, TileEntitySiphon.DUST_INVENTORY_INDEX, 44, 39));
		this.addSlotToContainer(new SlotSiphonOutput(tileEntitySiphon, TileEntitySiphon.OUTPUT_INVENTORY_INDEX, 120, 39));

		// Add the player's inventory slots to the container
		for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex) {
			for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex) {
				this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 106 + inventoryRowIndex * 18));
			}
		}

		// Add the player's action bar slots to the container
		for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex) {
			this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 164));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.tileEntitySiphon.deviceCookTime);
		iCrafting.sendProgressBarUpdate(this, 1, this.tileEntitySiphon.fuelBurnTime);
		iCrafting.sendProgressBarUpdate(this, 2, this.tileEntitySiphon.itemCookTime);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (Object crafter : this.crafters) {
			ICrafting icrafting = (ICrafting) crafter;

			if (this.lastDeviceCookTime != this.tileEntitySiphon.deviceCookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntitySiphon.deviceCookTime);
			}

			if (this.lastFuelBurnTime != this.tileEntitySiphon.fuelBurnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntitySiphon.fuelBurnTime);
			}

			if (this.lastItemCookTime != this.tileEntitySiphon.itemCookTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileEntitySiphon.itemCookTime);
			}
		}

		this.lastDeviceCookTime = this.tileEntitySiphon.deviceCookTime;
		this.lastFuelBurnTime = this.tileEntitySiphon.fuelBurnTime;
		this.lastItemCookTime = this.tileEntitySiphon.itemCookTime;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {
			ItemStack slotItemStack = slot.getStack();
			itemStack = slotItemStack.copy();

			/**
			 * If we are shift-clicking an item out of the Siphon's container,
			 * attempt to put it in the first available slot in the player's
			 * inventory
			 */
			if (slotIndex < TileEntitySiphon.INVENTORY_SIZE) {
				if (!this.mergeItemStack(slotItemStack, TileEntitySiphon.INVENTORY_SIZE, inventorySlots.size(), false)) {
					return null;
				}
			} else {
				/**
				 * If the stack being shift-clicked into the Siphon's container
				 * is a fuel, first try to put it in the fuel slot. If it cannot
				 * be merged into the fuel slot, try to put it in the input
				 * slot.
				 */
				if (TileEntityFurnace.isItemFuel(slotItemStack)) {
					if (!this.mergeItemStack(slotItemStack, TileEntitySiphon.FUEL_INVENTORY_INDEX, TileEntitySiphon.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				/**
				 * If the stack being shift-clicked into the Siphon's container
				 * is a dust, first try to put it in the dust slot. If it cannot
				 * be merged into the dust slot, try to put it in the input
				 * slot.
				 */
				else if (slotItemStack.getItem() instanceof ItemElementBase) {
					if (!this.mergeItemStack(slotItemStack, TileEntitySiphon.DUST_INVENTORY_INDEX, TileEntitySiphon.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				/**
				 * Finally, attempt to put stack into the input slot
				 */
				else if (!this.mergeItemStack(slotItemStack, TileEntitySiphon.INPUT_INVENTORY_INDEX, TileEntitySiphon.DUST_INVENTORY_INDEX, false)) {
					return null;
				}
			}

			if (slotItemStack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemStack;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int valueType, int updatedValue) {
		if (valueType == 0) {
			this.tileEntitySiphon.deviceCookTime = updatedValue;
		}

		if (valueType == 1) {
			this.tileEntitySiphon.fuelBurnTime = updatedValue;
		}

		if (valueType == 2) {
			this.tileEntitySiphon.itemCookTime = updatedValue;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return false;
	}
}
