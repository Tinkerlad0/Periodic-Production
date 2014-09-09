package com.tinkerlad.chemistry.registry;

import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.reference.Enums;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.registry.referenceRegistries.ElementRegister;
import com.tinkerlad.chemistry.utils.Utils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

public class ToolRegister {

    public static void init() {
        initPicks();
        initAxes();
        initHoes();
        initShovels();
        initSwords();
    }

    private static void initPicks() {

        for (Map.Entry<Element, ItemElementIngot> entry1 : ElementRegister.elementIngotMap.entrySet()) {
            for (Map.Entry<Element, ItemElementIngot> entry2 : ElementRegister.elementIngotMap.entrySet()) {
                ItemElementIngot edge = entry1.getValue();
                ItemElementIngot core = entry2.getValue();

                if (edge == null || core == null || edge.ELEMENT.STATE != Enums.State.SOLID) continue;
                ItemStack result;
                switch (Utils.getHarvestLevel(edge.ELEMENT.HARDNESS.getValue(), edge.ELEMENT.DENSITY)) {
                    default:
                        result = new ItemStack(ItemList.PICK1);
                        break;
                    case 2:
                        result = new ItemStack(ItemList.PICK2);
                        break;
                    case 3:
                        result = new ItemStack(ItemList.PICK3);
                        break;
                    case 4:
                        result = new ItemStack(ItemList.PICK4);
                        break;
                }

                float speed = (float) (1 + (10.0 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0))));
                int durability = (int) (3124 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0)));
                int color = (3 * edge.ELEMENT.COLOR + core.ELEMENT.COLOR) / 4;
                String name = edge.ELEMENT.NAME + " tipped " + core.ELEMENT.NAME + " Pickaxe";

                result.stackTagCompound = new NBTTagCompound();

                result.stackTagCompound.setFloat("pp_speed", speed);
                result.stackTagCompound.setInteger("pp_damage", durability);
                result.stackTagCompound.setInteger("pp_color", color);
                result.stackTagCompound.setString("pp_name", name);

                GameRegistry.addRecipe(result, "ECE", " S ", " S ", 'E', edge, 'C', core, 'S', Items.stick);

            }
        }

    }

    public static void initAxes() {

        for (Map.Entry<Element, ItemElementIngot> entry1 : ElementRegister.elementIngotMap.entrySet()) {
            for (Map.Entry<Element, ItemElementIngot> entry2 : ElementRegister.elementIngotMap.entrySet()) {
                ItemElementIngot edge = entry1.getValue();
                ItemElementIngot core = entry2.getValue();

                if (edge == null || core == null || edge.ELEMENT.STATE != Enums.State.SOLID) continue;
                ItemStack result;
                switch (Utils.getHarvestLevel(edge.ELEMENT.HARDNESS.getValue(), edge.ELEMENT.DENSITY)) {
                    default:
                        result = new ItemStack(ItemList.AXE1);
                        break;
                    case 2:
                        result = new ItemStack(ItemList.AXE2);
                        break;
                    case 3:
                        result = new ItemStack(ItemList.AXE3);
                        break;
                    case 4:
                        result = new ItemStack(ItemList.AXE4);
                        break;
                }

                float speed = (float) (1 + (10.0 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0))));
                int durability = (int) (3124 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0)));
                int color = (3 * edge.ELEMENT.COLOR + core.ELEMENT.COLOR) / 4;
                String name = edge.ELEMENT.NAME + " tipped " + core.ELEMENT.NAME + " Axe";

                result.stackTagCompound = new NBTTagCompound();

                result.stackTagCompound.setFloat("pp_speed", speed);
                result.stackTagCompound.setInteger("pp_damage", durability);
                result.stackTagCompound.setInteger("pp_color", color);
                result.stackTagCompound.setString("pp_name", name);

                GameRegistry.addRecipe(result, "EC ", "ES ", " S ", 'E', edge, 'C', core, 'S', Items.stick);
                GameRegistry.addRecipe(result, " CE", " SE", " S ", 'E', edge, 'C', core, 'S', Items.stick);
            }
        }
    }

    public static void initHoes() {

        for (Map.Entry<Element, ItemElementIngot> entry1 : ElementRegister.elementIngotMap.entrySet()) {
            for (Map.Entry<Element, ItemElementIngot> entry2 : ElementRegister.elementIngotMap.entrySet()) {
                ItemElementIngot edge = entry1.getValue();
                ItemElementIngot core = entry2.getValue();

                if (edge == null || core == null || edge.ELEMENT.STATE != Enums.State.SOLID) continue;
                ItemStack result;
                switch (Utils.getHarvestLevel(edge.ELEMENT.HARDNESS.getValue(), edge.ELEMENT.DENSITY)) {
                    default:
                        result = new ItemStack(ItemList.HOE1);
                        break;
                    case 2:
                        result = new ItemStack(ItemList.HOE2);
                        break;
                    case 3:
                        result = new ItemStack(ItemList.HOE3);
                        break;
                    case 4:
                        result = new ItemStack(ItemList.HOE4);
                        break;
                }

                float speed = (float) (1 + (10.0 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0))));
                int durability = (int) (3124 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0)));
                int color = (3 * edge.ELEMENT.COLOR + core.ELEMENT.COLOR) / 4;
                String name = edge.ELEMENT.NAME + " tipped " + core.ELEMENT.NAME + " Hoe";

                result.stackTagCompound = new NBTTagCompound();

                result.stackTagCompound.setFloat("pp_speed", speed);
                result.stackTagCompound.setInteger("pp_damage", durability);
                result.stackTagCompound.setInteger("pp_color", color);
                result.stackTagCompound.setString("pp_name", name);

                GameRegistry.addRecipe(result, "EC ", " S ", " S ", 'E', edge, 'C', core, 'S', Items.stick);
                GameRegistry.addRecipe(result, " CE", " S ", " S ", 'E', edge, 'C', core, 'S', Items.stick);
            }
        }
    }

    public static void initShovels() {

        for (Map.Entry<Element, ItemElementIngot> entry1 : ElementRegister.elementIngotMap.entrySet()) {
            for (Map.Entry<Element, ItemElementIngot> entry2 : ElementRegister.elementIngotMap.entrySet()) {
                ItemElementIngot edge = entry1.getValue();
                ItemElementIngot core = entry2.getValue();

                if (edge == null || core == null || edge.ELEMENT.STATE != Enums.State.SOLID) continue;
                ItemStack result;
                switch (Utils.getHarvestLevel(edge.ELEMENT.HARDNESS.getValue(), edge.ELEMENT.DENSITY)) {
                    default:
                        result = new ItemStack(ItemList.SHOVEL1);
                        break;
                    case 2:
                        result = new ItemStack(ItemList.SHOVEL2);
                        break;
                    case 3:
                        result = new ItemStack(ItemList.SHOVEL3);
                        break;
                    case 4:
                        result = new ItemStack(ItemList.SHOVEL4);
                        break;
                }

                float speed = (float) (1 + (10.0 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0))));
                int durability = (int) (3124 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0)));
                int color = (3 * edge.ELEMENT.COLOR + core.ELEMENT.COLOR) / 4;
                String name = edge.ELEMENT.NAME + " tipped " + core.ELEMENT.NAME + " Shovel";

                result.stackTagCompound = new NBTTagCompound();

                result.stackTagCompound.setFloat("pp_speed", speed);
                result.stackTagCompound.setInteger("pp_damage", durability);
                result.stackTagCompound.setInteger("pp_color", color);
                result.stackTagCompound.setString("pp_name", name);

                GameRegistry.addRecipe(result, " E ", "ECE", " S ", 'E', edge, 'C', core, 'S', Items.stick);
            }
        }
    }

    public static void initSwords() {

        for (Map.Entry<Element, ItemElementIngot> entry1 : ElementRegister.elementIngotMap.entrySet()) {
            for (Map.Entry<Element, ItemElementIngot> entry2 : ElementRegister.elementIngotMap.entrySet()) {
                ItemElementIngot edge = entry1.getValue();
                ItemElementIngot core = entry2.getValue();

                if (edge == null || core == null || edge.ELEMENT.STATE != Enums.State.SOLID) continue;
                ItemStack result;
                switch (Utils.getHarvestLevel(edge.ELEMENT.HARDNESS.getValue(), edge.ELEMENT.DENSITY)) {
                    default:
                        result = new ItemStack(ItemList.SWORD1);
                        break;
                    case 2:
                        result = new ItemStack(ItemList.SWORD2);
                        break;
                    case 3:
                        result = new ItemStack(ItemList.SWORD3);
                        break;
                    case 4:
                        result = new ItemStack(ItemList.SWORD4);
                        break;
                }

                float speed = (float) (1 + (10.0 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0))));
                int durability = (int) (3124 * Utils.getHardnessModifier((int) (10.0 * edge.ELEMENT.HARDNESS.getValue() + 3.0 * core.ELEMENT.HARDNESS.getValue() / 13.0)));
                int color = (3 * edge.ELEMENT.COLOR + core.ELEMENT.COLOR) / 4;
                String name = edge.ELEMENT.NAME + " tipped " + core.ELEMENT.NAME + " Sword";

                result.stackTagCompound = new NBTTagCompound();

                result.stackTagCompound.setFloat("pp_speed", speed);
                result.stackTagCompound.setInteger("pp_damage", durability);
                result.stackTagCompound.setInteger("pp_color", color);
                result.stackTagCompound.setString("pp_name", name);

                GameRegistry.addRecipe(result, " E ", " C ", " S ", 'E', edge, 'C', core, 'S', Items.stick);
            }
        }
    }
}