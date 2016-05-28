package com.oitsjustjose.tinkers_addons.util;

import java.util.ArrayList;
import java.util.List;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	public static void init()
	{
		ArrayList<Block> blocks = Lib.getModBlocks();
		ArrayList<Item> items = Lib.getModItems();

		for (Block b : blocks)
			register(b, "");
		for (Item i : items)
			register(i, "");
	}

	@SideOnly(Side.CLIENT)
	private static void register(Item item, String customName)
	{
		int meta = 0;

		List<ItemStack> subItems = new ArrayList<ItemStack>();
		item.getSubItems(item, TinkerRegistry.tabParts, subItems);
		for (ItemStack sub : subItems)
		{
			String name = item.getUnlocalizedName(sub).substring(19).toLowerCase();
			ModelBakery.registerItemVariants(item, new ResourceLocation(Lib.MODID.toLowerCase(), name));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Lib.MODID.toLowerCase() + ":" + name, "inventory"));
			meta++;
		}

	}

	@SideOnly(Side.CLIENT)
	private static void register(Block block, String customName)
	{
		int meta = 0;
		Item itemBlock = Item.getItemFromBlock(block);
		if (itemBlock.getHasSubtypes())
		{
			List<ItemStack> subItems = new ArrayList<ItemStack>();
			itemBlock.getSubItems(itemBlock, TinkerRegistry.tabParts, subItems);
			for (ItemStack sub : subItems)
			{
				String name = itemBlock.getUnlocalizedName(sub).toLowerCase().replace("tinkersaddons.", "").replace("tile.", "");
				ModelBakery.registerItemVariants(itemBlock, new ResourceLocation(Lib.MODID.toLowerCase(), name));
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, meta, new ModelResourceLocation(Lib.MODID.toLowerCase() + ":" + name, "inventory"));
				meta++;
			}
		}
		else if (customName == "")
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, 0, new ModelResourceLocation(Lib.MODID.toLowerCase() + ":" + block.getUnlocalizedName().substring(19).toLowerCase(), "inventory"));
		else
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, 0, new ModelResourceLocation(Lib.MODID.toLowerCase() + ":" + customName, "inventory"));
	}
}