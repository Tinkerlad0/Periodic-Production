package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.reference.Enums;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCanister extends ItemGeneric {

	Enums.FUEL_TYPE FUEL;

	Block field_150935_a;

	public ItemCanister(String itemName, Enums.FUEL_TYPE fuel) {
		super(itemName);
		this.FUEL = fuel;
		String texture = "";
		switch (fuel) {
			default:
				texture = Chemistry.MODID + ":" + "canister_empty";
				field_150935_a = BlockList.CANISTER_EMPTY;
				break;
			case CANDY:
				texture = Chemistry.MODID + ":" + "canister_candy";
				field_150935_a = BlockList.CANISTER_CANDY;
				break;
			case ZINC_SULFUR:
				texture = Chemistry.MODID + ":" + "canister_zinc-sulphur";
				field_150935_a = BlockList.CANISTER_ZINC_SULPHUR;
				break;
		}
		setTextureName(texture);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(xPos, yPos, zPos);

		if (block == Blocks.snow_layer && (world.getBlockMetadata(xPos, yPos, zPos) & 7) < 1) {
			side = 1;
		} else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
			if (side == 0) {
				--yPos;
			}

			if (side == 1) {
				++yPos;
			}

			if (side == 2) {
				--zPos;
			}

			if (side == 3) {
				++zPos;
			}

			if (side == 4) {
				--xPos;
			}

			if (side == 5) {
				++xPos;
			}
		}

		if (!player.canPlayerEdit(xPos, yPos, zPos, side, itemStack)) {
			return false;
		} else if (itemStack.stackSize == 0) {
			return false;
		} else {
			if (world.canPlaceEntityOnSide(this.field_150935_a, xPos, yPos, zPos, false, side, (Entity) null, itemStack)) {
				int i1 = this.field_150935_a.onBlockPlaced(world, xPos, yPos, zPos, side, hitX, hitY, hitY, 0);

				if (world.setBlock(xPos, yPos, zPos, this.field_150935_a, i1, 3)) {
					if (world.getBlock(xPos, yPos, zPos) == this.field_150935_a) {
						this.field_150935_a.onBlockPlacedBy(world, xPos, yPos, zPos, player, itemStack);
						this.field_150935_a.onPostBlockPlaced(world, xPos, yPos, zPos, i1);
					}

					world.playSoundEffect((double) ((float) xPos + 0.5F), (double) ((float) yPos + 0.5F), (double) ((float) zPos + 0.5F), this.field_150935_a.stepSound.func_150496_b(), (this.field_150935_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150935_a.stepSound.getPitch() * 0.8F);
					--itemStack.stackSize;
				}
			}

			return true;
		}
	}
}
