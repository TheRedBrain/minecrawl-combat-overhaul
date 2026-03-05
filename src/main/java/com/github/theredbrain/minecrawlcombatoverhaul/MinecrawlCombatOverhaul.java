package com.github.theredbrain.minecrawlcombatoverhaul;

import com.github.theredbrain.minecrawlcombatoverhaul.compat.SpellEngineCompat;
import com.github.theredbrain.minecrawlcombatoverhaul.compat.SpellEngineExtensionCompat;
import com.github.theredbrain.minecrawlcombatoverhaul.registry.ItemRegistry;
import com.github.theredbrain.minecrawlcombatoverhaul.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class MinecrawlCombatOverhaul implements ModInitializer {
	public static final String MOD_ID = "minecrawlcombatoverhaul";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean isSpellEngineLoaded = FabricLoader.getInstance().isModLoaded("spell_engine");
	public static final boolean isSpellEngineExtensionLoaded = FabricLoader.getInstance().isModLoaded("spellengineextension");

	public static RegistryEntry<StatusEffect> POWER_SHOT_SPELL;
	public static RegistryEntry<StatusEffect> FROZEN_SHOT_SPELL;
	public static RegistryEntry<StatusEffect> REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS;

	public static RegistryEntry<StatusEffect> FIRE_BLAST_MODIFIER_1;
	public static RegistryEntry<StatusEffect> FIRE_BLAST_MODIFIER_2;

	public static TagKey<StatusEffect> RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = TagKey.of(RegistryKeys.STATUS_EFFECT, identifier("ranged_attacks_modifier_spell_effects"));

	public static void configureEffects() {
		if (isSpellEngineLoaded) {
			SpellEngineCompat.configureEffects();
		}
		if (isSpellEngineExtensionLoaded) {
			SpellEngineExtensionCompat.configureEffects();
		}
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Overhauling combat!");
		ItemRegistry.init();
		StatusEffectsRegistry.registerEffects();

		if (isSpellEngineLoaded) {
			SpellEngineCompat.registerCustomImpacts();
		}

		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(MOD_ID);
		if (modContainer.isPresent()) {
			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_data_pack"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_data_pack.name"), ResourcePackActivationType.ALWAYS_ENABLED);
			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_resource_pack"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_resource_pack.name"), ResourcePackActivationType.DEFAULT_ENABLED);
		}
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}