package com.demmers.behgameon.util;

import com.demmers.behgameon.BehgameonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class BehgameonTabs {
	public static final CreativeModeTab AccessoriesTabItemGroup = (new CreativeModeTab("accessories") {
		public ItemStack makeIcon() {
			return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(BehgameonMod.MODID, "accessory_1")));
		}
	});
}