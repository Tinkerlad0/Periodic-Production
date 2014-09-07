package com.tinkerlad.chemistry.recipe.backend;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WrappedStack implements Comparable<WrappedStack> {

    private final Object wrappedStack;
    public static Comparator<WrappedStack> comparator = new Comparator<WrappedStack>() {

        @Override
        public int compare(WrappedStack wrappedStack1, WrappedStack wrappedStack2) {

            if (wrappedStack1.wrappedStack instanceof ItemStack) {
                if (wrappedStack2.wrappedStack instanceof ItemStack) {
                    return ItemHelper.compare((ItemStack) wrappedStack1.wrappedStack, (ItemStack) wrappedStack2.wrappedStack);
                } else {
                    return 1;
                }
            } else if (wrappedStack1.wrappedStack instanceof OreStack) {
                if (wrappedStack2.wrappedStack instanceof ItemStack) {
                    return -1;
                } else if (wrappedStack2.wrappedStack instanceof OreStack) {
                    return OreStack.compare((OreStack) wrappedStack1.wrappedStack, (OreStack) wrappedStack2.wrappedStack);
                } else {
                    return 1;
                }
            } else if (wrappedStack1.wrappedStack instanceof FluidStack) {
                if (wrappedStack2.wrappedStack instanceof ItemStack || wrappedStack2.wrappedStack instanceof OreStack) {
                    return -1;
                } else if (wrappedStack2.wrappedStack instanceof FluidStack) {
                    return FluidHelper.compare((FluidStack) wrappedStack1.wrappedStack, (FluidStack) wrappedStack2.wrappedStack);
                } else {
                    return 1;
                }
            } else if (wrappedStack1.wrappedStack == null) {
                if (wrappedStack2.wrappedStack != null) {
                    return -1;
                } else {
                    return 0;
                }
            }

            return 0;
        }
    };
    private int stackSize;

    /**
     *
     */
    public WrappedStack() {
        stackSize = -1;
        wrappedStack = null;
    }

    public WrappedStack(Object object) {
        if (object instanceof Item) {
            object = new ItemStack((Item) object);
        } else if (object instanceof Block) {
            object = new ItemStack((Block) object);
        } else if (object instanceof Fluid) {
            object = new FluidStack((Fluid) object, 1000);
        }

        if (object instanceof ItemStack) {
            ItemStack itemStack = ((ItemStack) object).copy();

            stackSize = itemStack.stackSize;
            itemStack.stackSize = 1;
            wrappedStack = itemStack;
        } else if (object instanceof OreStack) {
            OreStack oreStack = (OreStack) object;

            stackSize = oreStack.stackSize;
            oreStack.stackSize = 1;
            wrappedStack = oreStack;
        } else if (object instanceof ArrayList) {
            ArrayList<?> objectList = (ArrayList<?>) object;

            OreStack possibleOreStack = OreStack.getOreStackFromList(objectList);

            if (possibleOreStack != null) {
                stackSize = possibleOreStack.stackSize;
                possibleOreStack.stackSize = 1;
                wrappedStack = possibleOreStack;
            } else {
                stackSize = -1;
                wrappedStack = null;
            }
        } else if (object instanceof FluidStack) {
            FluidStack fluidStack = ((FluidStack) object).copy();

            stackSize = fluidStack.amount;
            fluidStack.amount = 1;
            wrappedStack = fluidStack;
        } else if (object instanceof WrappedStack) {
            WrappedStack wrappedStackObject = (WrappedStack) object;

            if (wrappedStackObject.getWrappedStack() != null) {
                this.stackSize = wrappedStackObject.stackSize;
                this.wrappedStack = wrappedStackObject.wrappedStack;
            } else {
                stackSize = -1;
                wrappedStack = null;
            }
        } else {
            stackSize = -1;
            wrappedStack = null;
        }
    }

    public WrappedStack(Object object, int stackSize) {
        if (object instanceof Item) {
            object = new ItemStack((Item) object);
        } else if (object instanceof Block) {
            object = new ItemStack((Block) object);
        } else if (object instanceof Fluid) {
            object = new FluidStack((Fluid) object, 1000);
        }

        if (object instanceof ItemStack) {
            ItemStack itemStack = ((ItemStack) object).copy();

            this.stackSize = stackSize;
            itemStack.stackSize = 1;
            wrappedStack = itemStack;
        } else if (object instanceof OreStack) {
            OreStack oreStack = (OreStack) object;

            this.stackSize = stackSize;
            oreStack.stackSize = 1;
            wrappedStack = oreStack;
        } else if (object instanceof ArrayList) {
            ArrayList<?> objectList = (ArrayList<?>) object;

            OreStack possibleOreStack = OreStack.getOreStackFromList(objectList);

            if (possibleOreStack != null) {
                this.stackSize = stackSize;
                possibleOreStack.stackSize = 1;
                wrappedStack = possibleOreStack;
            } else {
                this.stackSize = -1;
                wrappedStack = null;
            }
        } else if (object instanceof FluidStack) {
            FluidStack fluidStack = (FluidStack) object;

            this.stackSize = stackSize;
            fluidStack.amount = 1;
            wrappedStack = fluidStack;
        } else if (object instanceof WrappedStack) {
            WrappedStack wrappedStackObject = (WrappedStack) object;

            if (wrappedStackObject.getWrappedStack() != null) {
                this.stackSize = stackSize;
                this.wrappedStack = wrappedStackObject.wrappedStack;
            } else {
                this.stackSize = -1;
                wrappedStack = null;
            }
        } else {
            this.stackSize = -1;
            wrappedStack = null;
        }
    }

    public static boolean canBeWrapped(Object object) {
        if (object instanceof WrappedStack) {
            return true;
        } else if (object instanceof Item || object instanceof Block || object instanceof ItemStack) {
            return true;
        } else if (object instanceof OreStack) {
            return true;
        } else if (object instanceof List) {
            if (OreStack.getOreStackFromList((List<?>) object) != null) {
                return true;
            }
        } else if (object instanceof Fluid || object instanceof FluidStack) {
            return true;
        }

        return false;
    }

    public Object getWrappedStack() {

        return wrappedStack;
    }

    public int getStackSize() {

        return stackSize;
    }

    public void setStackSize(int stackSize) {

        this.stackSize = stackSize;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (37 * hashCode) + stackSize;

        if (wrappedStack instanceof ItemStack) {
            hashCode = (37 * hashCode) + Item.getIdFromItem(((ItemStack) wrappedStack).getItem());
            hashCode = (37 * hashCode) + ((ItemStack) wrappedStack).getItemDamage();

            if (((ItemStack) wrappedStack).getTagCompound() != null) {
                hashCode = (37 * hashCode) + ((ItemStack) wrappedStack).getTagCompound().hashCode();
            }
        } else if (wrappedStack instanceof OreStack) {
            if (((OreStack) wrappedStack).oreName != null) {
                hashCode = (37 * hashCode) + ((OreStack) wrappedStack).oreName.hashCode();
            }
        } else if (wrappedStack instanceof FluidStack) {
            hashCode = (37 * hashCode) + wrappedStack.hashCode();

            if (((FluidStack) wrappedStack).tag != null) {
                hashCode = (37 * hashCode) + ((FluidStack) wrappedStack).tag.hashCode();
            }
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof WrappedStack && (this.compareTo((WrappedStack) object) == 0);
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        if (wrappedStack instanceof ItemStack) {
            return String.format("%sxitemStack[%s@%s, %s]", stackSize, ((ItemStack) wrappedStack).getUnlocalizedName(), ((ItemStack) wrappedStack).getItemDamage(), Item.getIdFromItem(((ItemStack) wrappedStack).getItem()));
        } else if (wrappedStack instanceof OreStack) {
            OreStack oreStack = (OreStack) wrappedStack;
            return String.format("%sxoreStack.%s", stackSize, oreStack.oreName);
        } else if (wrappedStack instanceof FluidStack) {
            FluidStack fluidStack = (FluidStack) wrappedStack;
            return String.format("%sxfluidStack.%s", stackSize, fluidStack.getFluid().getName());
        } else {
            return "null";
        }
    }

    /*
     * Sort order (class-wise) goes ItemStack, OreStack, EnergyStack,
     * FluidStack, null
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(WrappedStack wrappedStack) {
        return comparator.compare(this, wrappedStack);
    }
}

class ItemHelper {

    public static Comparator<ItemStack> comparator = new Comparator<ItemStack>() {
        public int compare(ItemStack itemStack1, ItemStack itemStack2) {
            if (itemStack1 != null && itemStack2 != null) {
                // Sort on itemID
                if (Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem()) == 0) {
                    // Then sort on meta
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage()) {
                        // Then sort on NBT
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound()) {
                            // Then sort on stack size
                            if (itemStack1.getTagCompound().equals(itemStack2.getTagCompound())) {
                                return (itemStack1.stackSize - itemStack2.stackSize);
                            } else {
                                return (itemStack1.getTagCompound().hashCode() - itemStack2.getTagCompound().hashCode());
                            }
                        } else if (!(itemStack1.hasTagCompound()) && itemStack2.hasTagCompound()) {
                            return -1;
                        } else if (itemStack1.hasTagCompound() && !(itemStack2.hasTagCompound())) {
                            return 1;
                        } else {
                            return (itemStack1.stackSize - itemStack2.stackSize);
                        }
                    } else {
                        return (itemStack1.getItemDamage() - itemStack2.getItemDamage());
                    }
                } else {
                    return Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem());
                }
            } else if (itemStack1 != null && itemStack2 == null) {
                return -1;
            } else if (itemStack1 == null && itemStack2 != null) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    /**
     * Compares two ItemStacks for equality, testing itemID, metaData, stackSize, and their NBTTagCompounds (if they are
     * present)
     *
     * @param first  The first ItemStack being tested for equality
     * @param second The second ItemStack being tested for equality
     * @return true if the two ItemStacks are equivalent, false otherwise
     */
    public static boolean equals(ItemStack first, ItemStack second) {
        return (comparator.compare(first, second) == 0);
    }

    public static int compare(ItemStack itemStack1, ItemStack itemStack2) {
        return comparator.compare(itemStack1, itemStack2);
    }

    public static String toString(ItemStack itemStack) {
        if (itemStack != null) {
            return String.format("%sxitemStack[%s@%s]", itemStack.stackSize, itemStack.getUnlocalizedName(), itemStack.getItemDamage());
        }

        return "null";
    }
}

class FluidHelper {

    public static Comparator<FluidStack> comparator = new Comparator<FluidStack>() {

        public int compare(FluidStack fluidStack1, FluidStack fluidStack2) {

            if (fluidStack1 != null) {
                if (fluidStack2 != null) {
                    if (fluidStack1.fluidID == fluidStack2.fluidID) {
                        if (fluidStack1.amount == fluidStack2.amount) {
                            if (fluidStack1.tag != null) {
                                if (fluidStack2.tag != null) {
                                    return (fluidStack1.tag.hashCode() - fluidStack2.tag.hashCode());
                                } else {
                                    return -1;
                                }
                            } else {
                                if (fluidStack2.tag != null) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            }
                        } else {
                            return (fluidStack1.amount - fluidStack2.amount);
                        }
                    } else {
                        return (fluidStack1.fluidID - fluidStack2.fluidID);
                    }
                } else {
                    return -1;
                }
            } else {
                if (fluidStack2 != null) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    };

    public static void registerFluids() {
        // Register Milk in the FluidRegistry if it hasn't already been done
        if (!FluidRegistry.isFluidRegistered("milk")) {
            Fluid milk = new Fluid("milk") {
                @Override
                public String getLocalizedName() {
                    return StatCollector.translateToLocal("item.milk.name");
                }
            }.setUnlocalizedName(Items.milk_bucket.getUnlocalizedName());
            FluidRegistry.registerFluid(milk);
            FluidContainerRegistry.registerFluidContainer(new FluidStack(milk, 1000), new ItemStack(Items.milk_bucket), new ItemStack(Items.bucket));
        }
    }

    public static int compare(FluidStack fluidStack1, FluidStack fluidStack2) {
        return comparator.compare(fluidStack1, fluidStack2);
    }

    public static String toString(FluidStack fluidStack) {

        if (fluidStack != null) {
            return String.format("%sxfluidStack.%s", fluidStack.amount, fluidStack.getFluid().getName());
        }

        return "fluidStack[null]";
    }
}