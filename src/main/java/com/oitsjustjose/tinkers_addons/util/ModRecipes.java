package com.oitsjustjose.tinkers_addons.util;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes
{
	public ModRecipes()
	{
		registerAutoRepairRecipe();
		registerBonusModRecipes();
	}

	public void registerAutoRepairRecipe()
	{
		if (TinkersAddons.modConfig.autoRepairRecipeType == 1)
		{
			GameRegistry.addRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 0), new Object[] { "MMM", "MEM", "MMM", 'M', Blocks.MOSSY_COBBLESTONE, 'E', Items.BOOK });
		}
		else if (TinkersAddons.modConfig.autoRepairRecipeType == 2)
		{
			CraftingManager.getInstance().getRecipeList().add(new ModRecipeAmelioration());
			RecipeSorter.register(Lib.MODID + ":Amelioration", ModRecipeAmelioration.class, Category.SHAPED, "");
		}
	}

	public void registerBonusModRecipes()
	{
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

	}
}