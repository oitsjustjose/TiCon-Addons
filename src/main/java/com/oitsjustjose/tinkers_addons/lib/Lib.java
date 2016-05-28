package com.oitsjustjose.tinkers_addons.lib;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Lib
{
	public static final String MODID = "TinkersAddons";
	public static final String NAME = "Tinkers' Addons";
	public static final String VERSION = "@VERSION@";
	public static final String CLIENT_PROXY = "com.oitsjustjose.tinkers_addons.util.ClientProxy";
	public static final String COMMON_PROXY = "com.oitsjustjose.tinkers_addons.util.CommonProxy";
	public static final String GUI_FACTORY = "com.oitsjustjose.tinkers_addons.gui.ConfigGUI$GUIFactory";
	
	public static final String TAG_AUTO_REPAIR = "Auto-Repair";
	public static final String TAG_AUTO_REPAIR_COOLDOWN = "Last Auto-Repair";
	public static final String TAG_REDSTONE_FLUX = "Redstone Flux";
	
	private static final ArrayList<Item> allItems = new ArrayList<Item>();
	private static final ArrayList<Block> allBlocks = new ArrayList<Block>();

	public static ArrayList<Item> getModItems()
	{
		return allItems;
	}

	public static ArrayList<Block> getModBlocks()
	{
		return allBlocks;
	}

	public static void add(Item item)
	{
		allItems.add(item);
	}

	public static void add(Block block)
	{
		allBlocks.add(block);
	}
}