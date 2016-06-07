package com.oitsjustjose.tinkers_addons.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class InterModUtils
{
	/**
	 * @param oreDict
	 *            The oreDict name of the ItemStack you want
	 * @return the first entry from the oreDictionary if it's present, null otherwise
	 */
	public static ItemStack getFirstFromOreDict(String oreDict)
	{
		if (OreDictionary.getOres(oreDict).size() > 0)
			return OreDictionary.getOres(oreDict).get(0);
		return null;
	}

	/**
	 * @param modid
	 *            modid to search for
	 * @param item
	 *            item or block to search for
	 * @return a new itemstack with the block or item for
	 */
	public static ItemStack findItemStack(String modid, String item)
	{
		ResourceLocation location = new ResourceLocation(modid, item);

		if (Item.itemRegistry.containsKey(location))
			return new ItemStack(Item.itemRegistry.getObject(location));
		else if (Block.blockRegistry.containsKey(location))
			return new ItemStack(Block.blockRegistry.getObject(location));
		else
			return null;
	}
}