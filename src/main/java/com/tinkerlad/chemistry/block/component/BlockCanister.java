package com.tinkerlad.chemistry.block.component;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockGeneric;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.reference.Enums;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockCanister extends BlockGeneric {

    protected Enums.FUEL_TYPE fuelType;

    public BlockCanister(String name, Enums.FUEL_TYPE fuel) {
        super(name, Material.iron);
        this.fuelType = fuel;
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1F, 0.9F);

        String texture = "";
        switch (fuel) {
            case EMPTY:
                texture = Chemistry.MODID + ":" + "canister_empty";
                break;
            case CANDY:
                texture = Chemistry.MODID + ":" + "canister_candy";
                break;
            case ZINC_SULFUR:
                texture = Chemistry.MODID + ":" + "canister_zinc-sulphur";
                break;
        }
        setBlockTextureName(texture);
    }

    @Override
    public boolean isBlockSolid(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        Item drops = ItemList.CANISTER_EMPTY;
        switch (fuelType) {
            case CANDY:
                drops = ItemList.CANISTER_CANDY;
                break;
            case ZINC_SULFUR:
                drops = ItemList.CANISTER_ZINC_SULFUR;
                break;
        }
        return drops;
    }
}
