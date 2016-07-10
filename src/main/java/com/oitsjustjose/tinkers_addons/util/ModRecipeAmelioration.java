package com.oitsjustjose.tinkers_addons.util;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ModRecipeAmelioration extends RecipesMapCloning
{
	@Override
	public boolean matches(InventoryCrafting invCraft, World world)
	{
		boolean mending = false;
		int numMoss = 0;

		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				ItemStack temp = invCraft.getStackInRowAndColumn(x, y);
				if (temp == null)
				{
					return false;
				}

				// Checks for center item slot
				if (x == 1 && y == 1)
				{
					if (temp.getItem() instanceof ItemEnchantedBook)
					{
						if (temp.getTagCompound() != null)
						{
							NBTTagCompound comp = temp.getTagCompound();
							mending = comp.getTag("StoredEnchantments").toString().contains("id:70s");

							if (!world.isRemote)
								System.out.println(comp.getTag("StoredEnchantments").toString());

						}
					}
					// Checks if the center item slot has mending on it
					if (EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(70), temp) > 0)
						mending = true;
				}
				// Else not the center slot it drops out if the block isn't mossy cobble
				else if ((temp.getItem() == Item.getItemFromBlock(Blocks.MOSSY_COBBLESTONE)))
				{
					++numMoss;
				}
			}

		}
		return mending && numMoss == 8;
	}

	// DONE
	@Override
	public ItemStack getCraftingResult(InventoryCrafting invCraft)
	{
		return new ItemStack(TinkersAddons.modItems.materials, 1, 0);
	}

	// DONE
	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	// DONE
	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting invCraft)
	{
		return new ItemStack[] { null, null, null, null, null, null, null, null, null };
	}
}
