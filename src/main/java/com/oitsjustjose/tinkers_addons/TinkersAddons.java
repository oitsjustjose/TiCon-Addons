package com.oitsjustjose.tinkers_addons;

import com.oitsjustjose.tinkers_addons.lib.Config;
import com.oitsjustjose.tinkers_addons.lib.Lib;
import com.oitsjustjose.tinkers_addons.lib.LibItems;
import com.oitsjustjose.tinkers_addons.lib.LibModifiers;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;
import com.oitsjustjose.tinkers_addons.util.ClientProxy;
import com.oitsjustjose.tinkers_addons.util.CommonProxy;
import com.oitsjustjose.tinkers_addons.util.ModRecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Lib.MODID, name = Lib.NAME, version = Lib.VERSION, guiFactory = Lib.GUI_FACTORY, dependencies = "required-after:tconstruct@[1.10-2.3.3,);" + "required-after:mantle@[1.10-0.10.3,)")
public class TinkersAddons
{
	@Instance(Lib.MODID)
	public static TinkersAddons instance;

	@SidedProxy(clientSide = Lib.CLIENT_PROXY, serverSide = Lib.COMMON_PROXY, modId = Lib.MODID)
	public static CommonProxy proxy;
	public static Config modConfig;
	public static LibItems modItems;
	public static LibModifiers modModifiers;
	public ModRecipes recipes;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		CommonProxy.preInit();

		modConfig = new Config(event.getSuggestedConfigurationFile());
		modItems = new LibItems();
		modModifiers = new LibModifiers();

		MinecraftForge.EVENT_BUS.register(modConfig);
		MinecraftForge.EVENT_BUS.register(new ModAutoRepair());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide().isClient())
			ClientProxy.init();
		recipes = new ModRecipes();
	}
}