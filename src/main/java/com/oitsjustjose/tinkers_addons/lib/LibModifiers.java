package com.oitsjustjose.tinkers_addons.lib;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;
import com.oitsjustjose.tinkers_addons.modifiers.ModExtraModifier;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class LibModifiers
{
	public static Modifier auto_repair;
	public static Modifier extra_modifier_lvl1;
	public static Modifier extra_modifier_lvl2;
	public static Modifier extra_modifier_lvl3;

	public LibModifiers()
	{
		if (TinkersAddons.modConfig.enableAutoRepair)
		{
			auto_repair = new ModAutoRepair();
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl1)
		{
			extra_modifier_lvl1 = new ModExtraModifier(1);
			extra_modifier_lvl1.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.diamond, 1, 0), new ItemStack(Blocks.gold_block)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			extra_modifier_lvl2 = new ModExtraModifier(2);
			extra_modifier_lvl2.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.golden_apple, 1, 1), new ItemStack(Blocks.diamond_block)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			extra_modifier_lvl3 = new ModExtraModifier(3);
			extra_modifier_lvl3.addItem(Items.nether_star);
		}
	}
}