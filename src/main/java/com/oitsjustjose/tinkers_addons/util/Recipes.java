package com.oitsjustjose.tinkers_addons.util;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

public class Recipes
{
	public Recipes()
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
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 1), new Object[] { "#S#", "###", '#', TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.iron), 'S', TinkerCommons.blockPigIron }));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 2), new Object[] { "#S#", "###", '#', TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.ardite), 'S', Blocks.GOLD_BLOCK }));

		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 3), new Object[] { "#S#", "###", '#', TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.prismarine), 'S', Blocks.DIAMOND_BLOCK }));

		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl4)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 4), new Object[] { "#S#", "###", '#', TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.obsidian), 'S', Items.ENDER_PEARL }));

		}
	}
}