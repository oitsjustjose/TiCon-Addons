package com.oitsjustjose.tinkers_addons.modifiers;

import java.util.ArrayList;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class ModAutoRepair extends Modifier
{
	//TODO: actually keep track of auto-repair level now!
	public ModAutoRepair()
	{
		super("auto-repair");
	    addAspects(new ModifierAspect.LevelAspect(this, 5), new ModifierAspect.DataAspect(this, 0x2CA401), ModifierAspect.freeModifier);
	}

	@Override
	public String getTooltip(NBTTagCompound modifierTag, boolean detailed)
	{
		return super.getTooltip(modifierTag, detailed);
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag)
	{
		ToolNBT toolData = TagUtil.getOriginalToolStats(rootCompound);
		NBTTagCompound tag = TagUtil.getToolTag(rootCompound);
		int autoRepairLevel = toolData.get().getInteger(Lib.TAG_AUTO_REPAIR) + 1;
		tag.setInteger(Lib.TAG_AUTO_REPAIR, autoRepairLevel);
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onUpdate(PlayerEvent event)
	{
		if (event.entityPlayer == null)
			return;

		EntityPlayer player = event.entityPlayer;
		ArrayList<ItemStack> tinkersTools = new ArrayList<ItemStack>();
		for (ItemStack iterStack : player.inventory.mainInventory)
			if (iterStack != null && iterStack.getItem() instanceof ToolCore)
				tinkersTools.add(iterStack);

		for (ItemStack iterStack : tinkersTools)
		{
			NBTTagCompound tag = TagUtil.getToolTag(iterStack.getTagCompound());
			int autoRepairLevel = tag.getInteger(Lib.TAG_AUTO_REPAIR);
			long lastRepairTime = tag.getLong(Lib.TAG_AUTO_REPAIR_COOLDOWN);
			// Calculates that the last repair time stored minus the current time is less than or equal to 30 seconds divided by auto-repair level
			if ((System.currentTimeMillis() - lastRepairTime) >= (15000))
			{
				ToolHelper.healTool(iterStack, autoRepairLevel, event.entityPlayer);
				tag.setLong(Lib.TAG_AUTO_REPAIR_COOLDOWN, System.currentTimeMillis());
			}
		}
	}
}
