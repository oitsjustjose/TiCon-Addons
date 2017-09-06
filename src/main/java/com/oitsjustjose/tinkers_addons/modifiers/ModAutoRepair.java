package com.oitsjustjose.tinkers_addons.modifiers;

import java.util.ArrayList;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class ModAutoRepair extends Modifier
{
    public ModAutoRepair()
    {
        super("auto-repair");
        this.addAspects(new ModifierAspect.LevelAspect(this, 5), new ModifierAspect.DataAspect(this, 0x2CA401), ModifierAspect.freeModifier);
        this.addItem(new ItemStack(TinkersAddons.modItems.MODIFIERS, 1, 0), 1, 1);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed)
    {
        return super.getTooltip(modifierTag, detailed);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag)
    {
        // Nothing special to do here
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onUpdate(PlayerEvent event)
    {
        if (event.getEntityPlayer() == null)
            return;

        EntityPlayer player = event.getEntityPlayer();
        ArrayList<ItemStack> tinkersTools = new ArrayList<ItemStack>();
        int autoRepairLevel;
        for (ItemStack iterStack : player.inventory.mainInventory)
            if (iterStack != null && iterStack.getItem() instanceof ToolCore)
                tinkersTools.add(iterStack);

        // Works to include items held in the second hand
        if (player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof ToolCore)
            tinkersTools.add(player.getHeldItemOffhand());

        for (ItemStack iterStack : tinkersTools)
        {
            autoRepairLevel = 0;
            NBTTagCompound tag = TagUtil.getToolTag(iterStack.getTagCompound());
            NBTTagList tagList = TagUtil.getModifiersTagList(iterStack);
            for (int i = 0; i < tagList.tagCount(); i++)
            {
                if (tagList.get(i) instanceof NBTTagCompound)
                {
                    NBTTagCompound currTag = (NBTTagCompound) tagList.get(i);
                    if (currTag.getString("identifier").contains("auto-repair"))
                    {
                        autoRepairLevel = currTag.getInteger("level");
                    }
                }
            }

            long lastRepairTime = tag.getLong(Lib.TAG_AUTO_REPAIR_COOLDOWN);

            if (autoRepairLevel > 0 && (System.currentTimeMillis() - lastRepairTime) >= (getRepairCooldown(player)) && !player.isSwingInProgress)
            {
                ToolHelper.healTool(iterStack, autoRepairLevel, player);
                tag.setLong(Lib.TAG_AUTO_REPAIR_COOLDOWN, System.currentTimeMillis());
            }
        }
    }

    int getRepairCooldown(EntityPlayer player)
    {
        World world = player.getEntityWorld();
        int rand = world.rand.nextInt(999);
        if (player.dimension == -1)
            return 10000 + rand;
        if (world.canSeeSky(player.getPosition()) && !world.isRaining())
            if (world.getWorldTime() >= 0 && world.getWorldTime() <= 13000)
                return 12500 + rand;

        return 15000 + rand;
    }
}
