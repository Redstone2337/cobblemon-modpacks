package net.redstone233.cobblemon.modpack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class LongCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("long").requires(src -> src.hasPermissionLevel(4))
        .then(CommandManager.argument("value", IntegerArgumentType.integer())
            .executes(run -> Long(run, IntegerArgumentType.getInteger(run, "value"))
            )
        );
    }

    private static int Long(CommandContext<ServerCommandSource> context,int value) throws CommandSyntaxException {
        PlayerEntity player = context.getSource().getPlayer();
        if (value %2 == 0) {
            player.sendMessage(Text.translatable("commands.long.even.info",value), false);
            context.getSource().sendFeedback(() -> Text.translatable("commands.long.success"), false);
        } else if (value %2 != 0) {
            player.sendMessage(Text.translatable("commands.long.odd.info",value), false);
            context.getSource().sendFeedback(() -> Text.translatable("commands.long.success"), false);
        } else {
            context.getSource().sendError(Text.translatable("commands.long.fail"));
            return 0;
        }
        context.getSource().sendFeedback(() -> Text.translatable("commands.long.success"), false);
        return 1;
    }
}
