package com.oitsjustjose.tinkers_addons.lib;

import java.io.File;

import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config
{
	public Configuration config;

	public boolean enableAutoRepair;
	public boolean enableExtraModifierLvl1;
	public boolean enableExtraModifierLvl2;
	public boolean enableExtraModifierLvl3;

	public Config(File file)
	{
		config = new Configuration(file);
		initialize();
	}

	void initialize()
	{
		Property property;

		property = config.get(config.CATEGORY_GENERAL, "Enable Auto-Repair", true).setRequiresMcRestart(true);
		property.comment = "Allows you to enable or disable the auto-repair trait";
		enableAutoRepair = property.getBoolean();

		property = config.get(config.CATEGORY_GENERAL, "Enable 1st bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.comment = "Re-adds the diamond + gold block recipe to increase modifiers on a tool if enabled";
		enableExtraModifierLvl1 = property.getBoolean();

		property = config.get(config.CATEGORY_GENERAL, "Enable 2nd bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.comment = "Re-adds the diamond block + gold apple recipe to increase modifiers on a tool if enabled";
		enableExtraModifierLvl2 = property.getBoolean();

		property = config.get(config.CATEGORY_GENERAL, "Enable 3rd bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.comment = "Re-adds the nether star recipe to increase modifiers on a tool if enabled";
		enableExtraModifierLvl3 = property.getBoolean();

		if (config.hasChanged())
			config.save();
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Lib.MODID))
			initialize();
	}
}
