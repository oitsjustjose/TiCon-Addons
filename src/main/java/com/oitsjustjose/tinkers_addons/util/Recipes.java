package com.oitsjustjose.tinkers_addons.util;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
		ItemStack plateItem = null;
		ItemStack centerItem = null;

		if (TinkersAddons.modConfig.enableAmelioration)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TinkersAddons.modItems.materials, 1, 0), new Object[] { new ItemStack(TinkerCommons.materials, 1, 19), new ItemStack(TinkerCommons.materials, 1, 19), new ItemStack(TinkerCommons.materials, 1, 19), Items.BOOK }));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl1)
		{
			plateItem = TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.iron);
			centerItem = TinkerCommons.blockPigIron;
			GameRegistry.addRecipe(new NBTShapedRecipe(3, 2, new ItemStack[] { plateItem, centerItem, plateItem, plateItem, plateItem, plateItem }, new ItemStack(TinkersAddons.modItems.materials, 1, 1)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			plateItem = TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.ardite);
			centerItem = new ItemStack(Blocks.GOLD_BLOCK);
			GameRegistry.addRecipe(new NBTShapedRecipe(3, 2, new ItemStack[] { plateItem, centerItem, plateItem, plateItem, plateItem, plateItem }, new ItemStack(TinkersAddons.modItems.materials, 1, 2)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			plateItem = TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.prismarine);
			centerItem = new ItemStack(Blocks.DIAMOND_BLOCK);
			GameRegistry.addRecipe(new NBTShapedRecipe(3, 2, new ItemStack[] { plateItem, centerItem, plateItem, plateItem, plateItem, plateItem }, new ItemStack(TinkersAddons.modItems.materials, 1, 3)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl4)
		{
			plateItem = TinkerTools.largePlate.getItemstackWithMaterial(TinkerMaterials.obsidian);
			centerItem = new ItemStack(Items.ENDER_PEARL);
			GameRegistry.addRecipe(new NBTShapedRecipe(3, 2, new ItemStack[] { plateItem, centerItem, plateItem, plateItem, plateItem, plateItem }, new ItemStack(TinkersAddons.modItems.materials, 1, 4)));
		}
	}

	/**
	 * 
	 * @author BloodWorkXGaming : https://github.com/BloodWorkXGaming
	 * 
	 *         An inner class for adding NBT-Sensitive recipes. All credit to BloodWorkXGaming for finding and fixing this bug for me. ORIGINAL CLASS: https://github.com/AllTheMods/OreExcavationIntegration/blob/master/src/main/java/atm/bloodworkxgaming/oei/Crafting/NBTShapedRecipe.java
	 *
	 */
	public class NBTShapedRecipe extends ShapedRecipes
	{

		public NBTShapedRecipe(int width, int height, ItemStack[] IngredientArray, ItemStack output)
		{
			super(width, height, IngredientArray, output);
		}

		/**
		 * Used to check if a recipe matches current crafting inventory
		 */
		@Override
		public boolean matches(InventoryCrafting inv, World worldIn)
		{
			for (int i = 0; i <= 3 - this.recipeWidth; ++i)
			{
				for (int j = 0; j <= 3 - this.recipeHeight; ++j)
				{
					if (this.checkMatch(inv, i, j, true))
					{
						return true;
					}

					if (this.checkMatch(inv, i, j, false))
					{
						return true;
					}
				}
			}

			return false;
		}

		/**
		 * Checks if the region of a crafting inventory is match for the recipe.
		 */
		private boolean checkMatch(InventoryCrafting inventoryCrafting, int horizontal, int vertical, boolean p_77573_4_)
		{
			for (int i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					int k = i - horizontal;
					int l = j - vertical;
					ItemStack itemStackRecipe = null;

					if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight)
					{
						if (p_77573_4_)
						{
							itemStackRecipe = this.recipeItems[this.recipeWidth - k - 1 + l * this.recipeWidth];
						}
						else
						{
							itemStackRecipe = this.recipeItems[k + l * this.recipeWidth];
						}
					}

					ItemStack input = inventoryCrafting.getStackInRowAndColumn(i, j);

					if (input != null || itemStackRecipe != null)
					{
						if ((input == null) != (itemStackRecipe == null))
						{
							return false;
						}

						if (itemStackRecipe.getItem() != input.getItem())
						{
							return false;
						}

						if (itemStackRecipe.getMetadata() != 32767 && itemStackRecipe.getMetadata() != input.getMetadata())
						{
							return false;
						}

						if (itemStackRecipe.hasTagCompound() && input.hasTagCompound())
						{
							if (!itemStackRecipe.getTagCompound().equals(input.getTagCompound()))
							{
								return false;
							}
						}
					}
				}
			}

			return true;
		}

	}
}