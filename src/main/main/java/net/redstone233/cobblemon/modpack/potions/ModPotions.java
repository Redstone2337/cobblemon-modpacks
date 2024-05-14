package net.redstone233.cobblemon.modpack.potions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.cobblemon.modpack.ModpackTestMod;
import net.redstone233.cobblemon.modpack.effects.ModEffects;

public class ModPotions {

    public static final Potion FIRE_ON_BODY_POTION = registerModPotion("fire_on_body",new Potion(new StatusEffectInstance(ModEffects.FIRE_STATUS_EFFECT,1800)));
    public static final Potion GOOD_FIRE_ON_BODY_POTION = registerModPotion("good_fire_on_body",new Potion(new StatusEffectInstance(ModEffects.GOOD_FIRE_STATUS_EFFECT,1600)));
    public static final Potion GREAT_FIRE_ON_BODY_POTION = registerModPotion("great_fire_on_body",new Potion(new StatusEffectInstance(ModEffects.GREAT_FIRE_STATUS_EFFECT,1200)));

    public static final Potion EXP_POTION = registerModPotion("experience",new Potion(new StatusEffectInstance(ModEffects.EXP_STATUS_EFFECT,2000)));
    public static final Potion GOOD_EXP_POTION = registerModPotion("good_experience",new Potion(new StatusEffectInstance(ModEffects.GOOD_EXP_STATUS_EFFECT,1800)));
    public static final Potion GREAT_EXP_POTION = registerModPotion("great_experience",new Potion(new StatusEffectInstance(ModEffects.GREAT_EXP_STATUS_EFFECT,1600)));
    public static final Potion BETTER_EXP_POTION = registerModPotion("better_experience",new Potion(new StatusEffectInstance(ModEffects.BETTER_EXP_STATUS_EFFECT,1400)));
    public static final Potion BEST_EXP_POTION = registerModPotion("best_experience",new Potion(new StatusEffectInstance(ModEffects.BEST_EXP_STATUS_EFFECT,1200)));


    private static Potion registerModPotion(String name,Potion potion) {
        return (Potion)Registry.register(Registries.POTION, new Identifier(ModpackTestMod.MOD_ID, name), potion);
    }

    public static void registerModPotions() {
        
    }

}
