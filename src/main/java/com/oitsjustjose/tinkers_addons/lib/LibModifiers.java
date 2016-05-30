package com.oitsjustjose.tinkers_addons.lib;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;
import com.oitsjustjose.tinkers_addons.modifiers.ModExtraModifier;

import slimeknights.tconstruct.library.modifiers.Modifier;

public class LibModifiers
{
	public Modifier auto_repair;
	public Modifier extra_modifier_lvl1;
	public Modifier extra_modifier_lvl2;
	public Modifier extra_modifier_lvl3;

	public LibModifiers()
	{
		if (TinkersAddons.modConfig.enableAutoRepair)
		{
			auto_repair = new ModAutoRepair();
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl1)
		{
			extra_modifier_lvl1 = new ModExtraModifier(1);
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			extra_modifier_lvl2 = new ModExtraModifier(2);
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			extra_modifier_lvl3 = new ModExtraModifier(3);
		}
	}
}