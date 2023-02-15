package com.demmers.behgameon.util;

import com.demmers.behgameon.BehgameonMod;
import com.demmers.behgameon.config.Config;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BehgameonItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BehgameonMod.MODID);

	static {
		for (int i=1;i<=56;i++){
			ITEMS.register("accessory_" + i,
					() -> new Item(new Item.Properties().tab(BehgameonTabs.AccessoriesTabItemGroup)
							.durability(Config.SERVER.ACCESSORY_MAXDAMAGE.get())));
		}

		for (int i=1;i<=106;i++){
			ITEMS.register("ring_" + i, () -> new Item(new Item.Properties()
					.tab(BehgameonTabs.AccessoriesTabItemGroup).durability(Config.SERVER.RING_MAXDAMAGE.get())));
		}
	}
}