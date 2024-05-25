package net.redstone233.cobblemon.modpack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.redstone233.cobblemon.modpack.commands.ModCommands;
import net.redstone233.cobblemon.modpack.effects.ModEffects;
import net.redstone233.cobblemon.modpack.enchantments.ModEnchantments;
import net.redstone233.cobblemon.modpack.potions.ModPotions;
import net.redstone233.cobblemon.modpack.items.ModItems;
import net.redstone233.cobblemon.modpack.items.ModItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModpackTestMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "modpack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModEnchantments.registerModEnchantments();
		ModEffects.registerModEffects();
		ModPotions.registerModPotions();
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();

		CommandRegistrationCallback.EVENT.register((dispatcher,registryAccess,environment) -> ModCommands.register(dispatcher));

		LOGGER.info("Hello Fabric world!");
	}
}