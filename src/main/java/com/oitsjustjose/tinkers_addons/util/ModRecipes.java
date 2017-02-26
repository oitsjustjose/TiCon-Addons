package com.oitsjustjose.tinkers_addons.util;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import slimeknights.tconstruct.shared.TinkerCommons;

public class ModRecipes
{
	public ModRecipes()
	{
		registerBonusModRecipes();
	}

	public void registerBonusModRecipes()
	{
		if (TinkersAddons.modConfig.enableAmelioration)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 0), new Object[] { new ItemStack(TinkerCommons.materials, 1, 19), new ItemStack(TinkerCommons.materials, 1, 19), new ItemStack(TinkerCommons.materials, 1, 19), Items.BOOK }));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl1)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 1), "gemDiamond", "blockGold"));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 2), "blockDiamond", new ItemStack(Items.GOLDEN_APPLE, 1, 1)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 3), Items.NETHER_STAR, new ItemStack(Items.SKULL, 1, Short.MAX_VALUE)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl4)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 4, 4), new Object[] { "PPP", "PEP", "PPP", 'P', Items.ENDER_PEARL, 'E', Blocks.DRAGON_EGG }));
		}
	}
}