package com.oitsjustjose.tinkers_addons.lib;

import java.io.File;

import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config
{
	public Configuration config;

	public int autoRepairRecipeType;
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

		property = config.get(Configuration.CATEGORY_GENERAL, "Auto-Repair Recipe Type", 2).setRequiresMcRestart(true);
		property.setComment("Allows you to modify the auto-repair recipe. 0 disables the feature, 1 enables the easier recipe, 2 enables a harder one.");
		autoRepairRecipeType = property.getInt();

		property = config.get(Configuration.CATEGORY_GENERAL, "Enable 1st bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.setComment("Re-adds the diamond + gold block recipe to increase modifiers on a tool if enabled");
		enableExtraModifierLvl1 = property.getBoolean();

		property = config.get(Configuration.CATEGORY_GENERAL, "Enable 2nd bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.setComment("Re-adds the diamond block + gold apple recipe to increase modifiers on a tool if enabled");
		enableExtraModifierLvl2 = property.getBoolean();

		property = config.get(Configuration.CATEGORY_GENERAL, "Enable 3rd bonus modifier mod for tools", true).setRequiresMcRestart(true);
		property.setComment("Re-adds the nether star recipe to increase modifiers on a tool if enabled");
		enableExtraModifierLvl3 = property.getBoolean();

		if (config.hasChanged())
			config.save();
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equalsIgnoreCase(Lib.MODID))
			initialize();
	}
}
