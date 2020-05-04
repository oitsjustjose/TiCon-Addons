package com.oitsjustjose.tinkers_addons.modifiers;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ModExtraModifier extends Modifier
{
    public ModExtraModifier(int level)
    {
        super("bonus-modifier_" + level);
        this.addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this, 0x8cf4e2));
        this.addItem(new ItemStack(TinkersAddons.modItems.MODIFIERS, 1, level), 1, 1);
    }

    @Override
    public boolean isHidden()
    {
        return true;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag)
    {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.modifiers++;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
