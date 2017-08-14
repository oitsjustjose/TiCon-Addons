package com.oitsjustjose.tinkers_addons;

import com.oitsjustjose.tinkers_addons.lib.Config;
import com.oitsjustjose.tinkers_addons.lib.Lib;
import com.oitsjustjose.tinkers_addons.lib.LibItems;
import com.oitsjustjose.tinkers_addons.lib.LibModifiers;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;

import com.oitsjustjose.tinkers_addons.util.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Lib.MODID, name = Lib.NAME, version = Lib.VERSION, guiFactory = Lib.GUI_FACTORY, dependencies = "required-after:tconstruct@[1.12-2.7.2.19,);" + "required-after:mantle@[1.12-1.3.1.18,)")
public class TinkersAddons
{
	@Instance(Lib.MODID)
	public static TinkersAddons instance;

	public static Config modConfig;
	public static LibItems modItems;
	public static LibModifiers modModifiers;
	public static ClientRegistry clientRegistry;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		modConfig = new Config(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(modConfig);
		clientRegistry = new ClientRegistry();
		MinecraftForge.EVENT_BUS.register(clientRegistry);
		modItems = new LibItems();
		modModifiers = new LibModifiers();
		MinecraftForge.EVENT_BUS.register(new ModAutoRepair());
	}

}