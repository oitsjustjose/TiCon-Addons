package com.oitsjustjose.tinkers_addons.materials;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitOccult extends AbstractTrait
{
	public TraitOccult()
	{
		super("occult", 0x423665);
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag)
	{
		ToolNBT data = TagUtil.getToolStats(rootCompound);
		if (!(rootCompound.getInteger(Lib.TAG_THAUMIUM) >= 1))
		{
			data.modifiers++;
			rootCompound.setInteger(Lib.TAG_THAUMIUM, 1);
		}
		TagUtil.setToolTag(rootCompound, data.get());
	}
}
