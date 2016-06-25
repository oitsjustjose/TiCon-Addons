package com.oitsjustjose.tinkers_addons.lib;

import com.oitsjustjose.tinkers_addons.TinkersAddons;
import com.oitsjustjose.tinkers_addons.modifiers.ModAutoRepair;
import com.oitsjustjose.tinkers_addons.modifiers.ModExtraModifier;
import com.oitsjustjose.tinkers_addons.modifiers.TraitOccult;
import com.oitsjustjose.tinkers_addons.util.InterModUtils;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class LibTinker
{
	public static Modifier auto_repair;
	public static Modifier extra_modifier_lvl1;
	public static Modifier extra_modifier_lvl2;
	public static Modifier extra_modifier_lvl3;
	public static Material thaumium;

	public LibTinker()
	{
		if (TinkersAddons.modConfig.enableAutoRepair)
		{
			auto_repair = new ModAutoRepair();
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl1)
		{
			extra_modifier_lvl1 = new ModExtraModifier(1);
			extra_modifier_lvl1.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.diamond, 1, 0), new ItemStack(Blocks.gold_block)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl2)
		{
			extra_modifier_lvl2 = new ModExtraModifier(2);
			extra_modifier_lvl2.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.golden_apple, 1, 1), new ItemStack(Blocks.diamond_block)));
		}
		if (TinkersAddons.modConfig.enableExtraModifierLvl3)
		{
			extra_modifier_lvl3 = new ModExtraModifier(3);
			extra_modifier_lvl3.addItem(Items.nether_star);
		}
		if (TinkersAddons.modConfig.enableThaumiumToolMaterial)
		{
			thaumium = new Material("thaumium", 0x423665);
			thaumium.setCraftable(true);
			thaumium.addItem("ingotThaumium", 1, Material.VALUE_Ingot);
			thaumium.addItem("nuggetThaumium", 1, Material.VALUE_Nugget);
			thaumium.addItem(TinkerRegistry.getShard(thaumium), 1, Material.VALUE_Shard);
			thaumium.setRepresentativeItem(InterModUtils.getFirstFromOreDict("ingotThaumium"));
			thaumium.addTrait(new TraitOccult());
			thaumium.setShard(TinkerRegistry.getShard(thaumium));
			TinkerRegistry.addMaterialStats(thaumium, new HeadMaterialStats(400, 5.00f, 3.50f, HarvestLevels.DIAMOND), new HandleMaterialStats(1.0f, 60), new ExtraMaterialStats(40));
			TinkerRegistry.addMaterial(thaumium);
		}
	}
}