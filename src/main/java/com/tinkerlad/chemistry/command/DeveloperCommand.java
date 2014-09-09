package com.tinkerlad.chemistry.command;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.recipe.alloy.AlloyCraftingManager;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.registry.referenceRegistries.ElementRegister;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeveloperCommand implements ICommand {
    private List<String> aliases;

    public DeveloperCommand() {
        this.aliases = new ArrayList<>();
        this.aliases.add("ppdev");
        this.aliases.add("ppd");
    }

    @Override
    public String getCommandName() {
        return "PPDeveloper";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender) {
        return "ppdev <command>";
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] strings) {
        if (strings.length == 0) {
            icommandsender.addChatMessage(new ChatComponentText("Invalid arguments"));
            return;
        }

        switch (strings[0]) {
            case "alloyRecipes":
                Integer size = AlloyCraftingManager.getInstance().getRecipeList().size();
                icommandsender.addChatMessage(new ChatComponentText(size.toString()));
                break;
            case "elementDump":
                try {
                    FileWriter fileWriter = new FileWriter(Chemistry.CONFIGURATION_DIR.getParent().replaceAll("config", "") + "dump.csv");

                    for (Map.Entry<Element, ItemElementBase> entry : ElementRegister.elementBaseMap.entrySet()) {
                        String name, hardness, density;
                        name = entry.getKey().NAME;
                        hardness = String.valueOf(entry.getKey().HARDNESS.getValue());
                        density = String.valueOf(entry.getKey().DENSITY);
                        fileWriter.append(name + "," + hardness + "," + density);
                        fileWriter.append('\n');
                    }

                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "invDump":
                if (icommandsender instanceof EntityPlayer) {
                    try {
                        FileWriter writer = new FileWriter(Chemistry.CONFIGURATION_DIR.getParent().replaceAll("config", "") + "dump.csv");

                        EntityPlayer player = (EntityPlayer) icommandsender;
                        for (int slot = 0; slot < player.inventory.getSizeInventory() - 1; slot++) {
                            ItemStack item = player.inventory.getStackInSlot(slot);
                            if (item != null) {
                                writer.append(item.getDisplayName() + ",");

                                if (item.stackTagCompound != null) {
                                    writer.append(item.stackTagCompound.toString());
                                }
                                writer.append('\n');
                            }

                        }

                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }

    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender icommandsender,
                                        String[] strings) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
