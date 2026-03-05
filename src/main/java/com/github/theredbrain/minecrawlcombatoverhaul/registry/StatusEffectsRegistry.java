package com.github.theredbrain.minecrawlcombatoverhaul.registry;

import com.github.theredbrain.minecrawlcombatoverhaul.MinecrawlCombatOverhaul;
import com.github.theredbrain.variousstatuseffects.effect.BeneficialStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.RemoveEffectsStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class StatusEffectsRegistry {

	public static final StatusEffect FROZEN_SHOT_SPELL = new BeneficialStatusEffect();
	public static final StatusEffect POWER_SHOT_SPELL = new BeneficialStatusEffect();
	public static final StatusEffect REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = new RemoveEffectsStatusEffect(MinecrawlCombatOverhaul.RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS, StatusEffectCategory.HARMFUL, 3381504);
	public static final StatusEffect FIRE_BLAST_MODIFIER_1 = new BeneficialStatusEffect();
	public static final StatusEffect FIRE_BLAST_MODIFIER_2 = new BeneficialStatusEffect();

	public static void registerEffects() {
//		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		// --- Attribute Modifiers ---

		// --- Configuration ---
		MinecrawlCombatOverhaul.configureEffects();

		// --- Registration ---
		MinecrawlCombatOverhaul.FROZEN_SHOT_SPELL = register("frozen_shot_spell", FROZEN_SHOT_SPELL);
		MinecrawlCombatOverhaul.POWER_SHOT_SPELL = register("power_shot_spell", POWER_SHOT_SPELL);
		MinecrawlCombatOverhaul.REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = register("remove_ranged_attacks_modifier_spell_effects", REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS);
		MinecrawlCombatOverhaul.FIRE_BLAST_MODIFIER_1 = register("fire_blast_modifier_1", FIRE_BLAST_MODIFIER_1);
		MinecrawlCombatOverhaul.FIRE_BLAST_MODIFIER_2 = register("fire_blast_modifier_2", FIRE_BLAST_MODIFIER_2);
	}

	private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, MinecrawlCombatOverhaul.identifier(identifierString), statusEffect);
	}
}
