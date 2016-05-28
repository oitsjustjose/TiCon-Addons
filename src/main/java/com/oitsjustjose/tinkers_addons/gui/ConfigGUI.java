package com.oitsjustjose.tinkers_addons.gui;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGUI extends GuiConfig
{
	public ConfigGUI(GuiScreen guiScreen)
	{
		super(guiScreen, getConfigElements(), Lib.MODID, false, true, GuiConfig.getAbridgedConfigPath(TinkersAddons.modConfig.config.toString()));
	}

	private static List<IConfigElement> getConfigElements()
	{
		List<IConfigElement> list = Lists.newArrayList();

		return list;
	}

	public static class GUIFactory implements IModGuiFactory
	{
		@Override
		public void initialize(Minecraft minecraftInstance)
		{

		}

		@Override
		public Class<? extends GuiScreen> mainConfigGuiClass()
		{
			return ConfigGUI.class;
		}

		@Override
		public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
		{
			return null;
		}

		@Override
		public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
		{
			return null;
		}
	}
}