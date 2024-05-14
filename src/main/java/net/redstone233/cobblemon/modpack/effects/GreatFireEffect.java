package net.redstone233.cobblemon.modpack.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class GreatFireEffect extends StatusEffect{

    public GreatFireEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.isOnFire()) {
            entity.setOnFireFor(80 * (amplifier + 3));
            entity.setFireTicks(80 * (amplifier + 3));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,40*(amplifier + 1),5,false,false,true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,40*(amplifier + 1),6,false,false,true));
        }
        super.onApplied(entity, attributes, amplifier);
    }

}
