package com.oitsjustjose.tinkers_addons.items;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("deprecation")
public class ItemModifier extends Item
{
    public ItemModifier()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(TinkerRegistry.tabGeneral);
        this.setRegistryName(new ResourceLocation(Lib.MODID, "modifier_item"));
        this.setUnlocalizedName(this.getRegistryName().toString().replaceAll(":", "."));
        ForgeRegistries.ITEMS.register(this);
        this.registerModels();
    }

    private void registerModels()
    {
        for (int i = 0; i < EnumType.values().length; i++)
        {
            TinkersAddons.clientRegistry.register(new ItemStack(this, 1, i), new ResourceLocation(Lib.MODID, EnumType.byMetadata(i).getName()), "inventory");
        }
    }

    @Override
    public boolean hasEffect(ItemStack itemstack)
    {
        return itemstack.getItemDamage() == 0;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return Lib.MODID + "." + EnumType.byMetadata(stack.getMetadata()).getName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            for (int i = 0; i < EnumType.values().length; i++)
            {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(I18n.translateToLocal(Lib.MODID + "." + EnumType.byMetadata(stack.getItemDamage()) + ".description"));
    }

    public enum EnumType implements IStringSerializable
    {
        AMELIORATION_TOME(0, "amelioration_tome"),
        IRON_TOOLKIT(1, "iron_toolkit"),
        GOLD_TOOLKIT(2, "gold_toolkit"),
        DIAMOND_TOOLKIT(3, "diamond_toolkit"),
        ENDER_TOOLKIT(4, "ender_toolkit");

        private static final EnumType[] META_LOOKUP = new EnumType[values().length];

        static
        {
            for (EnumType type : values())
            {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }

        private final int meta;
        private final String serializedName;
        private final String unlocalizedName;

        EnumType(int meta, String name)
        {
            this.meta = meta;
            this.serializedName = name;
            this.unlocalizedName = name;
        }

        public static EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.unlocalizedName;
        }

        public String getName()
        {
            return this.serializedName;
        }
    }
}