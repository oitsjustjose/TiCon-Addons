package com.oitsjustjose.tinkers_addons.items;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ItemModMaterial extends Item
{
	public ItemModMaterial()
	{
		this.setUnlocalizedName(Lib.MODID + ".moss_ball");
		this.setCreativeTab(TinkerRegistry.tabParts);
		GameRegistry.registerItem(this, "moss_ball");
		Lib.add(this);
	}
}