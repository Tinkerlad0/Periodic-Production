package com.tinkerlad.chemistry.recipe;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyDust;
import com.tinkerlad.chemistry.recipe.alloy.AlloyCraftingManager;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.registry.annotations.RegisterAlloy;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Recipes {

    public static void initRecipes() {
        initElementCommonRecipes();
        initGameRecipes();
        initAlloyRecipes();
    }

    public static void initGameRecipes() {

        GameRegistry.addShapelessRecipe(new ItemStack(ItemList.DEBUG), new ItemStack(Blocks.dirt));
    }

    public static void initElementCommonRecipes() {

        for (Field field : Chemistry.ELEMENT_LIST.getClass().getDeclaredFields()) {
            Object obj = ObfuscationReflectionHelper.getPrivateValue(ElementList.class, Chemistry.ELEMENT_LIST,
                    field.getName());
            if (obj instanceof Element) {
                Element element = (Element) obj;

                if (Chemistry.ELEMENT_REGISTRY.getBlockFromElement(element) != null && Chemistry.ELEMENT_REGISTRY
                        .getBaseItemFromElement
                                (element) != null) {
                    ItemStack itemStackInput = new ItemStack(Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element));
                    ItemStack itemStackOutput = new ItemStack(Chemistry.ELEMENT_REGISTRY.getBlockFromElement(element));
                    GameRegistry.addShapedRecipe(itemStackOutput, "XXX", "XXX", "XXX", 'X', itemStackInput);
                }

                if (Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element) != null && Chemistry.ELEMENT_REGISTRY
                        .getBaseItemFromElement
                                (element) != null) {
                    GameRegistry.addSmelting(Chemistry.ELEMENT_REGISTRY.getBaseItemFromElement(element),
                            new ItemStack(Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element)), 2F);
                }
            }
        }
    }

    public static void initAlloyRecipes() {
        for (Field field : ItemList.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(RegisterAlloy.class)) {
                RegisterAlloy annotation = field.getAnnotation(RegisterAlloy.class);
                Object obj = ObfuscationReflectionHelper.getPrivateValue(ItemList.class, Chemistry.ITEM_LIST,
                        field.getName());
                if (obj instanceof ItemAlloyDust) {
                    ItemAlloyDust alloy = (ItemAlloyDust) obj;
                    switch (annotation.type()) {
                        case Shapeless:
                            List itemStackInputs = new ArrayList();
                            for (AlloyComponent alloyComponent : alloy.ALLOY.getCOMPONENTS()) {
                                ItemStack inputStack = new ItemStack(Chemistry.ELEMENT_REGISTRY.getBaseItemFromElement(alloyComponent.ELEMENT), alloyComponent.AMOUNT);
                                itemStackInputs.add(inputStack);
                            }
                            AlloyCraftingManager.getInstance().addShapelessRecipe(new ItemStack(alloy), itemStackInputs);
                            break;
                        case Shaped:
                            break;
                    }
                }
            }
        }
    }
}
