package net.redstone233.cobblemon.modpack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class NbtCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("nbt")
            .requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.argument("slot", IntegerArgumentType.integer())
                .executes(run -> getNbts(run.getSource(),
                    IntegerArgumentType.getInteger(run, "slot"),run.getSource().getPlayer())
                )
            );
    }

    private static int getNbts(ServerCommandSource source,int slot,PlayerEntity player) throws CommandSyntaxException {
        ItemStack stack = player.getInventory().getStack(slot);
        if (slot >= 0 && slot <= 40) {
            if (stack.hasNbt()) {
                assert stack.getNbt() != null;
                String s = stack.getNbt().toString();
                player.sendMessage(Text.translatable("commands.nbt.get",s), false);
            } else {
                player.sendMessage(Text.translatable("commands.nbt.slot.error"));
                source.sendError(Text.translatable("commands.nbt.fail"));
                return 0;
            }
        } else if (slot < 0) {
            player.sendMessage(Text.translatable("commands.nbt.slot.small",slot));
            source.sendError(Text.translatable("commands.nbt.fail"));
            return 0;
        } else if (slot > 40) {
            player.sendMessage(Text.translatable("commands.nbt.slot.biggest",slot));
            source.sendError(Text.translatable("commands.nbt.fail"));
            return 0;
        }
        source.sendFeedback(() -> Text.translatable("commands.nbt.success"), false);
        return 1;
    }
}
