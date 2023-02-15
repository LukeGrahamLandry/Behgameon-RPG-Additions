package com.demmers.behgameon.util;

import com.demmers.behgameon.BehgameonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BehgameonMod.MODID)
public class LootHandler {
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String prefix = "minecraft:chests/";
		String name = evt.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
			case "abandoned_mineshaft":
			case "desert_pyramid":
			case "jungle_temple":
			case "simple_dungeon":
			case "spawn_bonus_chest":
			case "stronghold_corridor":
			case "village_blacksmith":
			case "end_city_treasure":
			case "stronghold_crossing":
			case "underwater_ruin_small":
			case "underwater_ruin_big":
			case "buried_treasure":
			case "shipwreck_treasure":
			case "pillager_outpost":
				evt.getTable().addPool(getInjectPool(file));
				break;
			default:
				break;
			}
		}
	}

	private static LootPool getInjectPool(String entryName) {
		return LootPool.lootPool().add(getInjectEntry(entryName, 1)).setBonusRolls(UniformGenerator.between(0, 1)).name("behgameon_inject")
				.build();
	}

	private static LootPoolEntryContainer.Builder<?> getInjectEntry(String name, int weight) {
		ResourceLocation table = new ResourceLocation(BehgameonMod.MODID, "inject/" + name);
		return LootTableReference.lootTableReference(table).setWeight(weight);
	}
}