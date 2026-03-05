package com.github.theredbrain.minecrawlcombatoverhaul.compat;

import com.github.theredbrain.minecrawlcombatoverhaul.MinecrawlCombatOverhaul;
import com.github.theredbrain.minecrawlcombatoverhaul.registry.StatusEffectsRegistry;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;
import net.spell_engine.api.effect.Synchronized;
import net.spell_engine.api.spell.event.SpellHandlers;

import java.util.Optional;
import java.util.function.Function;

public class SpellEngineCompat {
	private static final ExplosionBehavior EXPLOSION_BEHAVIOR = new AdvancedExplosionBehavior(true, false, Optional.of(1.22F), Registries.BLOCK.getEntryList(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity()));

	public static void configureEffects() {
		Synchronized.configure(StatusEffectsRegistry.FROZEN_SHOT_SPELL, true);
		Synchronized.configure(StatusEffectsRegistry.POWER_SHOT_SPELL, true);
	}

	public static void registerCustomImpacts() {
		SpellHandlers.registerCustomImpact(MinecrawlCombatOverhaul.identifier("wind_charge_explosion"), (spellRegistryEntry, spellPowerResult, caster, target, impactContext) -> {
			Vec3d casterPos = caster.getPos();
			caster.getWorld().createExplosion(caster, null, EXPLOSION_BEHAVIOR, casterPos.getX(), casterPos.getY(), casterPos.getZ(), 1.2F, false, World.ExplosionSourceType.TRIGGER, ParticleTypes.GUST_EMITTER_SMALL, ParticleTypes.GUST_EMITTER_LARGE, SoundEvents.ENTITY_WIND_CHARGE_WIND_BURST);
			return new SpellHandlers.ImpactResult(true, false);
		});
	}
}
