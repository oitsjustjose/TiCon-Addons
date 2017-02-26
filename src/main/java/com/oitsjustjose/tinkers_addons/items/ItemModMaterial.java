package com.oitsjustjose.tinkers_addons.items;

import java.util.List;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ItemModMaterial extends Item
{
	String[] materials = new String[] { "AMELIORATION_KIT", "EXTRA_MODIFIER_LVL1", "EXTRA_MODIFIER_LVL2", "EXTRA_MODIFIER_LVL3", "EXTRA_MODIFIER_LVL4" };

	public ItemModMaterial()
	{
		this.setHasSubtypes(true);
		this.setCreativeTab(TinkerRegistry.tabGeneral);
		GameRegistry.register(this, new ResourceLocation(Lib.MODID.toLowerCase(), "modifier_item"));
		Lib.MOD_ITEMS.add(this);
	}

	@Override
	public boolean hasEffect(ItemStack itemstack)
	{
		return itemstack.getItemDamage() == 0 ? true : itemstack.getItemDamage() == 4 ? false : itemstack.getItemDamage() >= 2 ? true : false;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + Lib.MODID + "." + materials[itemStack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		for (int i = 0; i < materials.length; i++)
			list.add(new ItemStack(item, 1, i));
	}
}