package com.oitsjustjose.tinkers_addons.items;

import java.util.List;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;

@SuppressWarnings("deprecation")
public class ItemModifier extends Item
{
	private final String[] TYPES = new String[] { "AMELIORATION_TOME", "IRON_TOOLKIT", "GOLD_TOOLKIT", "DIAMOND_TOOLKIT", "ENDER_TOOLKIT" };

	public ItemModifier()
	{
		this.setHasSubtypes(true);
		this.setCreativeTab(TinkerRegistry.tabGeneral);
		this.setRegistryName(new ResourceLocation(Lib.MODID, "modifier_item"));
		this.setUnlocalizedName(Lib.MODID + ".modifier_item");
		GameRegistry.register(this);
		Lib.MOD_ITEMS.add(this);
	}

	@Override
	public boolean hasEffect(ItemStack itemstack)
	{
		return itemstack.getItemDamage() == 0;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + Lib.MODID + "." + TYPES[itemStack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list)
	{
		for (int i = 0; i < TYPES.length; i++)
			list.add(new ItemStack(item, 1, i));
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		switch (stack.getItemDamage())
		{
		case 0:
			tooltip.add(I18n.translateToLocal("item.tinkersaddons.AMELIORATION_TOME.description"));
			return;
		case 1:
			tooltip.add(I18n.translateToLocal("item.tinkersaddons.IRON_TOOLKIT.description"));
			return;
		case 2:
			tooltip.add(I18n.translateToLocal("item.tinkersaddons.GOLD_TOOLKIT.description"));
			return;
		case 3:
			tooltip.add(I18n.translateToLocal("item.tinkersaddons.DIAMOND_TOOLKIT.description"));
			return;
		case 4:
			tooltip.add(I18n.translateToLocal("item.tinkersaddons.ENDER_TOOLKIT.description"));
			return;
		}
	}
}