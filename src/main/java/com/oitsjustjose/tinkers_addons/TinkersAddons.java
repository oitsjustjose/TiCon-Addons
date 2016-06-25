package com.oitsjustjose.tinkers_addons;

import com.oitsjustjose.tinkers_addons.lib.Config;
import com.oitsjustjose.tinkers_addons.lib.Lib;
import com.oitsjustjose.tinkers_addons.lib.LibItems;
import com.oitsjustjose.tinkers_addons.lib.LibTinker;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;
import com.oitsjustjose.tinkers_addons.util.ClientProxy;
import com.oitsjustjose.tinkers_addons.util.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;

@Mod(modid = Lib.MODID, name = Lib.NAME, version = Lib.VERSION, guiFactory = Lib.GUI_FACTORY, acceptedMinecraftVersions = "1.8.9", dependencies = "required-after:tconstruct@[1.8.9-2.2.1,);" + "required-after:mantle@[1.8.9-0.9.0,)")
public class TinkersAddons
{
	@Instance(Lib.MODID)
	public static TinkersAddons instance;

	@SidedProxy(clientSide = Lib.CLIENT_PROXY, serverSide = Lib.COMMON_PROXY, modId = Lib.MODID)
	public static CommonProxy proxy;
	public static Config modConfig;
	public static LibItems modItems;
	public static LibTinker modTinker;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		CommonProxy.preInit();

		modConfig = new Config(event.getSuggestedConfigurationFile());
		modItems = new LibItems();
		modTinker = new LibTinker();

		MinecraftForge.EVENT_BUS.register(modConfig);
		MinecraftForge.EVENT_BUS.register(new ModAutoRepair());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide().isClient())
		{
			initClient();
		}
	}

	@SideOnly(Side.CLIENT)
	public void initClient()
	{
		ClientProxy.init();
		modTinker.thaumium.setRenderInfo((new MaterialRenderInfo.Metal(0x423665, 0.1f, 0.2f, 0f)));
	}
}