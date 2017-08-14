package com.oitsjustjose.tinkers_addons.gui;

import java.util.Set;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGUI extends GuiConfig
{
    public ConfigGUI(GuiScreen guiScreen)
    {
        super(guiScreen, new ConfigElement(TinkersAddons.modConfig.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Lib.MODID, false, true, GuiConfig.getAbridgedConfigPath(TinkersAddons.modConfig.config.toString()));
    }


    public static class GUIFactory implements IModGuiFactory
    {
        @Override
        public void initialize(Minecraft minecraftInstance)
        {

        }

        @Override
        public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
        {
            return null;
        }

        @Override
        public boolean hasConfigGui()
        {
            return true;
        }

        @Override
        public GuiScreen createConfigGui(GuiScreen parentScreen)
        {
            return new ConfigGUI(parentScreen);
        }
    }
}