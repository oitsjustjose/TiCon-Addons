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

	public Config(File file)
	{
		config = new Configuration(file);
		initialize();
	}

	void initialize()
	{
		Property property;

		property = config.get(config.CATEGORY_GENERAL, "Enable Auto-Repair", true);
		property.comment = "Allows you to enable or disable the auto-repair trait";
		enableAutoRepair = property.getBoolean();
		
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
