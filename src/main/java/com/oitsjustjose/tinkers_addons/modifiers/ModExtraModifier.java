package com.oitsjustjose.tinkers_addons.modifiers;

import java.util.Optional;

import com.oitsjustjose.tinkers_addons.TinkersAddons;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import slimeknights.mantle.util.RecipeMatch.Match;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModExtraModifier extends ToolModifier
{
	public ModExtraModifier(int level)
	{
		super("bonus-modifier_" + level, 0x8cf4e2);
		this.addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this, 0x8cf4e2));
		this.addItem(new ItemStack(TinkersAddons.modItems.materials, 1, level), 1, 1);
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

	@Override
	public Optional<Match> matches(NonNullList<ItemStack> stacks)
	{
		return null;
	}
}
