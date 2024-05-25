package net.redstone233.cobblemon.modpack.items;

import net.redstone233.cobblemon.modpack.ModpackTestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    @SuppressWarnings("unused")
    private static final ItemGroup ITEM_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
        new Identifier(ModpackTestMod.MOD_ID, "mod_group"), 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.EXCLAMATION))
                .displayName(Text.translatable("itemGroup.mod_group.name"))
                .entries((context, entries) -> {
                     entries.add(ModItems.EXCLAMATION);
                    // entries.add(ModItems.REFORGED_FOOD);
                    // entries.add(ModBlocks.REFORGED_BLOCK);
                    // entries.add(ModBlocks.REFORGED_BLOCK1);
                    // entries.add(ModBlocks.FIRE_REFORGED_BLOCK);
                    // entries.add(ModItems.PROSPECTOR);
                    // entries.add(ModItems.REFORGED_COAL);
                    // entries.add(ModItems.ICE_DRAGON_ARROW);
                    // entries.add(ModItems.COMBO_INGOT);
                    // entries.add(ModItems.SECKILL_INGOT);

                    // entries.add(ModItems.REFORGED_SWORD);
                    // entries.add(ModItems.REFORGED_3D_SWORD);
                    // entries.add(ModItems.NEXUS_SWORD);
                    // entries.add(ModItems.ICE_DRAGON_SWORD);
                    // entries.add(ModItems.GOLD_DAGGER);
                    // entries.add(ModItems.REFORGED_AMETHYST_SWORD);
                    // entries.add(ModItems.REFORGED_PICKAXE);
                    // entries.add(ModItems.REFORGED_AXE);
                    // entries.add(ModItems.COMBO_AXE);
                    // entries.add(ModItems.SECOND_AXE);
                    // entries.add(ModItems.REFORGED_SHOVRL);
                    // entries.add(ModItems.REFORGED_HOE);
                    // entries.add(ModItems.ICE_DRAGON_BOW);
                    // entries.add(ModItems.ENDER_BOW);

                    // entries.add(ModItems.REFORGED_HELMET);
                    // entries.add(ModItems.REFORGED_CHESTPLATE);
                    // entries.add(ModItems.REFORGED_LEGGINGS);
                    // entries.add(ModItems.REFORGED_BOOTS);
                    // entries.add(ModItems.REFORGED_APPLE_SEEDS);
                    // entries.add(ModItems.REFORGED_APPLE);
                    // entries.add(ModItems.ICE_DRAGON_SCALES);
                    // entries.add(ModItems.ICE_DRAGON_KEY);
                    // entries.add(ModItems.REFORGED_AMETHYST);
                    // entries.add(ModItems.FOGOTTEN_CHAKRAM);
                })
                .build());

    public static void registerModItemGroup() {
        
    }
}

// C:\Users\Redstone\.gradle\wrapper\dists\gradle-8.6-bin\afr5mpiioh2wthjmwnkmdsd5w\gradle-8.6
