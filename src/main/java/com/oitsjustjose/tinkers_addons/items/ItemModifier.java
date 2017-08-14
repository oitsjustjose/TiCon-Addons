package com.oitsjustjose.tinkers_addons.items;

import java.util.List;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;

import com.oitsjustjose.tinkers_addons.util.ClientRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;

@SuppressWarnings("deprecation")
public class ItemModifier extends Item
{
    private final String[] TYPES = new String[]{"AMELIORATION_TOME", "IRON_TOOLKIT", "GOLD_TOOLKIT", "DIAMOND_TOOLKIT", "ENDER_TOOLKIT"};

    public ItemModifier()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(TinkerRegistry.tabGeneral);
        this.setRegistryName(new ResourceLocation(Lib.MODID.toLowerCase(), "modifier_item"));
        ForgeRegistries.ITEMS.register(this);
        this.registerModels();
    }

    private void registerModels()
    {
        for (int i = 0; i < this.TYPES.length; i++)
            TinkersAddons.clientRegistry.register(new ItemStack(this, 1, i), new ResourceLocation(this.getRegistryName().toString() + "_" + this.TYPES[i]), "inventory");
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
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        for (int i = 0; i < TYPES.length; i++)
        {
            if (this.isInCreativeTab(tab))
            {
                items.add(new ItemStack(this));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        switch (stack.getItemDamage())
        {
            case 0:
                tooltip.add(I18n.translateToLocal("item.TinkersAddons.AMELIORATION_TOME.description"));
                return;
            case 1:
                tooltip.add(I18n.translateToLocal("item.TinkersAddons.IRON_TOOLKIT.description"));
                return;
            case 2:
                tooltip.add(I18n.translateToLocal("item.TinkersAddons.GOLD_TOOLKIT.description"));
                return;
            case 3:
                tooltip.add(I18n.translateToLocal("item.TinkersAddons.DIAMOND_TOOLKIT.description"));
                return;
            case 4:
                tooltip.add(I18n.translateToLocal("item.TinkersAddons.ENDER_TOOLKIT.description"));
                return;
        }
    }
}