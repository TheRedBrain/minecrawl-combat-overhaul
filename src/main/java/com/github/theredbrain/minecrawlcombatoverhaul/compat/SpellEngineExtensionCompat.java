package com.github.theredbrain.minecrawlcombatoverhaul.compat;

import com.github.theredbrain.minecrawlcombatoverhaul.registry.StatusEffectsRegistry;
import com.github.theredbrain.spellengineextension.entity.effect.ProvidesSpell;

import java.util.List;

public class SpellEngineExtensionCompat {
	public static void configureEffects() {
		// TODO
		ProvidesSpell.configure(StatusEffectsRegistry.FROZEN_SHOT_SPELL, List.of("minecrawl:frozen_shot_modifier"));
		ProvidesSpell.configure(StatusEffectsRegistry.POWER_SHOT_SPELL, List.of("minecrawl:power_shot_modifier"));

		ProvidesSpell.configure(StatusEffectsRegistry.FIRE_BLAST_MODIFIER_1, List.of("skill_tree_rpgs:fire_spec_a_modifier_1"));
		ProvidesSpell.configure(StatusEffectsRegistry.FIRE_BLAST_MODIFIER_2, List.of("skill_tree_rpgs:fire_spec_b_modifier_1"));
	}
}
