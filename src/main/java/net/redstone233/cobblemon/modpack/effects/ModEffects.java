package net.redstone233.cobblemon.modpack.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.cobblemon.modpack.ModpackTestMod;

public class ModEffects {

    public static final StatusEffect FIRE_STATUS_EFFECT = registerModEffect("fire_on_body", new FireEffect(StatusEffectCategory.HARMFUL,0xFF8247));
    public static final StatusEffect GOOD_FIRE_STATUS_EFFECT = registerModEffect("good_fire_on_body", new GoodFireEffect(StatusEffectCategory.HARMFUL,0xFF8247));
    public static final StatusEffect GREAT_FIRE_STATUS_EFFECT = registerModEffect("great_fire_on_body", new GreatFireEffect(StatusEffectCategory.HARMFUL,0xFF8247));
    
    public static final StatusEffect EXP_STATUS_EFFECT = registerModEffect("experience", new ExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect GOOD_EXP_STATUS_EFFECT = registerModEffect("good_experience", new GoodExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect GREAT_EXP_STATUS_EFFECT = registerModEffect("great_experience", new GreatExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect BETTER_EXP_STATUS_EFFECT = registerModEffect("better_experience", new BetterExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect BEST_EXP_STATUS_EFFECT = registerModEffect("best_experience", new BestExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));



    private static final StatusEffect registerModEffect(String name,StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(ModpackTestMod.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        
    }
}
