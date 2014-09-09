package com.tinkerlad.chemistry;

import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.block.machine.alloyMaker.TileEntityAlloyMaker;
import com.tinkerlad.chemistry.command.DeveloperCommand;
import com.tinkerlad.chemistry.config.ConfigHandler;
import com.tinkerlad.chemistry.gui.GUIHandler;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.logging.LogFile;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.proxies.CommonProxy;
import com.tinkerlad.chemistry.recipe.Recipes;
import com.tinkerlad.chemistry.reference.AlloyList;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.registry.DynamicLocalisations;
import com.tinkerlad.chemistry.registry.Register;
import com.tinkerlad.chemistry.registry.ToolRegister;
import com.tinkerlad.chemistry.registry.referenceRegistries.AlloyRegister;
import com.tinkerlad.chemistry.registry.referenceRegistries.ElementRegister;
import com.tinkerlad.chemistry.utils.DevUtils;
import com.tinkerlad.chemistry.utils.Ticker;
import com.tinkerlad.chemistry.world.OreGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import java.io.File;
import java.util.Random;

import static cpw.mods.fml.common.Mod.EventHandler;
import static cpw.mods.fml.common.Mod.Instance;

@Mod(modid = Chemistry.MODID, name = "Periodic Production", version = "@VERSION@",
        guiFactory = "com.tinkerlad.chemistry.gui.GuiFactory")
public class Chemistry {

    public static final String MODID = "tnkchem";
    public static File CONFIGURATION_DIR;
    public static DynamicLocalisations LOCALISATIONS;
    public static OreGen ORE_GEN;
    public static BlockList BLOCK_LIST;
    public static ElementList ELEMENT_LIST;
    public static ItemList ITEM_LIST;
    public static AlloyList ALLOY_LIST;
    public static ElementRegister ELEMENT_REGISTRY;
    public static AlloyRegister ALLOY_REGISTRY;

    @Instance(MODID)
    public static Chemistry instance;

    public static Random RANDOM = new Random();
    public static Ticker ticker;

    @SidedProxy(clientSide = "com.tinkerlad.chemistry.proxies.ClientProxy", serverSide = "com.tinkerlad.chemistry" + ".proxies" + ".CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        CONFIGURATION_DIR = event.getSuggestedConfigurationFile();
        LOCALISATIONS = new DynamicLocalisations();
        ORE_GEN = new OreGen();
        BLOCK_LIST = new BlockList();
        ELEMENT_LIST = new ElementList();
        ITEM_LIST = new ItemList();
        ALLOY_LIST = new AlloyList();
        ELEMENT_REGISTRY = new ElementRegister();
        ALLOY_REGISTRY = new AlloyRegister();

        LogHelper.logger = event.getModLog();
        LogFile.init(event.getModConfigurationDirectory());
        ConfigHandler.preInit(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(ConfigHandler.class);

        ticker = new Ticker();

        Register.initialise();

        Recipes.initRecipes();

        ToolRegister.init();

        ORE_GEN.populateDefaultOres();

        GameRegistry.registerWorldGenerator(ORE_GEN, 0);

        LOCALISATIONS.registerLocalisations();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
        GameRegistry.registerTileEntity(TileEntityAlloyMaker.class, "tile.alloy_maker");
        proxy.registerRenderers();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        DevUtils.dumpBlockNames();
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new DeveloperCommand());
    }
}