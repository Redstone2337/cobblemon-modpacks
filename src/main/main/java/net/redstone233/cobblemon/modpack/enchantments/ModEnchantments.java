package net.redstone233.cobblemon.modpack.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.cobblemon.modpack.ModpackTestMod;

public class ModEnchantments {

    public static final Enchantment NB_ENCHANTMENT = registerEnchantments("nb_enchantment",
            new NbEnchant(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON,
                new EquipmentSlot[] {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
                }
            )
        );

    private static Enchantment registerEnchantments(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(ModpackTestMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {

    }

}
