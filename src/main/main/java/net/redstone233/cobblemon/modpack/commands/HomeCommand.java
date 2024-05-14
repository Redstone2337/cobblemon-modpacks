package net.redstone233.cobblemon.modpack.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import net.minecraft.command.argument.DefaultPosArgument;
import net.minecraft.command.argument.PosArgument;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.LookTarget;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HomeCommand {

   private static double x;
   private static double y;
   private static double z;
   private static double[] DefaultPos = {x,y,z};
   private static int count = 0;
   private static String x2 = Double.toString(x);
   private static String y2 = Double.toString(y);
   private static String z1 = Double.toString(x);
   private static String[] tags1 = {x2,y2,z1};
   private static String[] tags2 = {x2,y2,z1};
   private static String[] tags3 = {x2,y2,z1};
   private static ArrayList<String> tagList;
   private static String name1;
   private static String name2;
   private static String name3;
   private static String[] names = {name1,name2,name3};

   private static final SimpleCommandExceptionType INVALID_POSITION_EXCEPTION = new SimpleCommandExceptionType(
         Text.translatable("commands.teleport.invalidPosition"));

   public static LiteralArgumentBuilder<ServerCommandSource> register() {
      return CommandManager.literal("home").requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("set")
                  .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                        .executes(run -> setPos(run.getSource(),
                              Collections.singleton(((ServerCommandSource) run.getSource()).getPlayer()),
                              run.getSource().getWorld(), Vec3ArgumentType.getPosArgument(run, "pos"),
                              DefaultPosArgument.zero(), (LookTarget) null)))
                  .then(CommandManager.argument("name", StringArgumentType.string())
                        .executes(run -> addName(run.getSource(),StringArgumentType.getString(run, "name")
                        )
                     )
                  )
               )
               .then(CommandManager.literal("tp")
                  .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                     .executes(run -> tpHomeforPos(run.getSource(), Collections.singleton(((ServerCommandSource)run.getSource()).getEntityOrThrow()), run.getSource().getWorld(), Vec3ArgumentType.getPosArgument(run, "pos"), DefaultPosArgument.zero(), (LookTarget) null))
                  )
               .then(CommandManager.argument("name", StringArgumentType.string())
                  .executes(run -> tpHomeforName(run.getSource(), StringArgumentType.getString(run, "name"))
                  )
               )
            )
         .then(CommandManager.literal("info")
            .then(CommandManager.literal("pos")
            .executes(run -> infoPos(run.getSource(), run.getSource().getPlayer())
            )
         )
         .then(CommandManager.literal("name")
            .executes(run -> infoName(run.getSource(), run.getSource().getPlayer())
            )
         )
      );
   }

   private static int infoPos(ServerCommandSource source,PlayerEntity player) throws CommandSyntaxException {
      Collections.addAll(tagList,tags1);
      Collections.addAll(tagList,tags2);
      Collections.addAll(tagList,tags3);
      if (player == null) {
         source.sendError(Text.translatable("commands.home.fail"));
         return 0;
      } else {
         for (String taglist : tagList) {
            player.sendMessage(Text.translatable("commands.home.success.info",taglist), false);
         }
      }
      source.sendFeedback(() -> Text.translatable("commands.home.success"), true);
      return 1;
   }

   private static int infoName(ServerCommandSource source,PlayerEntity player) throws CommandSyntaxException {
      if (player == null) {
         source.sendError(Text.translatable("commands.home.fail"));
         return 0;
      } else {
         for (String name : names) {
            player.sendMessage(Text.translatable("commands.home.success.names",name), false);
         }
      }
      source.sendFeedback(() -> Text.translatable("commands.home.success"), true);
      return 1;
   }

   private static int setPos(ServerCommandSource source, Collection<? extends PlayerEntity> targets, ServerWorld world, PosArgument pos, @Nullable PosArgument rotation, @Nullable LookTarget facingLocation) throws CommandSyntaxException {
      Vec3d vec3d = pos.toAbsolutePos(source);
      Vec2f vec2f = rotation == null ? null : rotation.toAbsoluteRotation(source);
      count = count + 1;
      Set<PositionFlag> set = EnumSet.noneOf(PositionFlag.class);
      if (pos.isXRelative()) {
         set.add(PositionFlag.X);
      }

      if (pos.isYRelative()) {
         set.add(PositionFlag.Y);
      }

      if (pos.isZRelative()) {
         set.add(PositionFlag.Z);
      }

      if (rotation == null) {
         set.add(PositionFlag.X_ROT);
         set.add(PositionFlag.Y_ROT);
      } else {
         if (rotation.isXRelative()) {
            set.add(PositionFlag.X_ROT);
         }

         if (rotation.isYRelative()) {
            set.add(PositionFlag.Y_ROT);
         }
      }

      @SuppressWarnings("rawtypes")
      Iterator var9 = targets.iterator();

      while(var9.hasNext()) {
         PlayerEntity entity = (PlayerEntity)var9.next();
         if (rotation == null) {
            //teleport(source, entity, world, vec3d.x, vec3d.y, vec3d.z, set, entity.getYaw(), entity.getPitch(), facingLocation);
            x = vec3d.x;
            y = vec3d.y;
            z = vec3d.z;
            double y1 = vec2f.y;
            double x1 = vec2f.x;
            for (double i : DefaultPos) {
               entity.sendMessage(Text.translatable("c.t.m",x,y,z,x1,y1,i));
            }
            // String x2 = Double.toString(x);
            // String y2 = Double.toString(y);
            // String z1 = Double.toString(x);
            // String[] tags1 = {x2,y2,z1};
            // String[] tags2 = {x2,y2,z1};
            // String[] tags3 = {x2,y2,z1};
            if (count == 1 && tags1 != tags2 || tags1 != tags3) {
               for (String tag1 : tags1) {
                  entity.sendMessage(Text.translatable("commands.home.success.pos",tag1));
                  entity.addCommandTag(tag1);
                  return Command.SINGLE_SUCCESS;
               }
            } else {
               throw ModCommands.COMMAND_HOME_POS_EXCEPTION_TYPE.create();
            }
            if (count == 2 && tags2 != tags1 || tags2 != tags3) {
               for (String tag2 : tags2) {
                  entity.sendMessage(Text.translatable("commands.home.success.set",tag2));
                  entity.addCommandTag(tag2);
                  return Command.SINGLE_SUCCESS;
               }
            } else {
               throw ModCommands.COMMAND_HOME_POS_EXCEPTION_TYPE.create();
            }
            if (count == 3 && tags3 != tags2 || tags3 != tags1) {
               for (String tag3 : tags3) {
                  entity.sendMessage(Text.translatable("commands.home.success.set",tag3));
                  entity.addCommandTag(tag3);
                  return Command.SINGLE_SUCCESS;
               }
            } else {
               throw ModCommands.COMMAND_HOME_POS_EXCEPTION_TYPE.create();
            }
         }
            if (pos == null || targets == null || count < 0 || count > 3) {
               source.sendError(Text.translatable("commands.home.fail"));
            return 0;
         }
      }
      source.sendFeedback(() -> Text.translatable("commands.home.success"), true);
      return 1;
   }

   private static int tpHomeforPos(ServerCommandSource source, Collection<? extends Entity> targets, ServerWorld world, PosArgument pos, @Nullable PosArgument rotation, @Nullable LookTarget facingLocation) throws CommandSyntaxException {
      Vec3d vec3d = pos.toAbsolutePos(source);
      Vec2f vec2f = rotation == null ? null : rotation.toAbsoluteRotation(source);
      Set<PositionFlag> set = EnumSet.noneOf(PositionFlag.class);
      if (pos.isXRelative()) {
         set.add(PositionFlag.X);
      }

      if (pos.isYRelative()) {
         set.add(PositionFlag.Y);
      }

      if (pos.isZRelative()) {
         set.add(PositionFlag.Z);
      }

      if (rotation == null) {
         set.add(PositionFlag.X_ROT);
         set.add(PositionFlag.Y_ROT);
      } else {
         if (rotation.isXRelative()) {
            set.add(PositionFlag.X_ROT);
         }

         if (rotation.isYRelative()) {
            set.add(PositionFlag.Y_ROT);
         }
      }

      @SuppressWarnings("rawtypes")
      Iterator var9 = targets.iterator();

      while(var9.hasNext()) {
         PlayerEntity entity = (PlayerEntity)var9.next();
         if (rotation == null) {
            teleport(source, entity, world, vec3d.x, vec3d.y, vec3d.z, set, entity.getYaw(), entity.getPitch(), facingLocation);
         } else {
            teleport(source, entity, world, vec3d.x, vec3d.y, vec3d.z, set, vec2f.y, vec2f.x, facingLocation);
         }
      }

      if (targets.size() == 1) {
         source.sendFeedback(() -> {
            return Text.translatable("commands.teleport.success.location.single", new Object[]{((Entity)targets.iterator().next()).getDisplayName(), formatFloat(vec3d.x), formatFloat(vec3d.y), formatFloat(vec3d.z)});
         }, true);
      }

      return targets.size();
   }

   private static int tpHomeforName(ServerCommandSource source,String name) throws CommandSyntaxException {
      PlayerEntity player = source.getPlayer();
      for (String name4 : names) {
         if (name == null || name == name4 || player == null) {
            source.sendError(Text.translatable("commands.home.fail"));
            return 0;
         }
      }
      source.sendFeedback(() -> Text.translatable("commands.home.success.name"), true);
      return 1;
   }

   private static String formatFloat(double d) {
      return String.format(Locale.ROOT, "%f", d);
   }

   private static int addName(ServerCommandSource source,String name) throws CommandSyntaxException {
      BlockPos blockPos = BlockPos.ofFloored(source.getPosition());
      PlayerEntity entity = source.getPlayer();
      // if (condition) {
         
      // }
      // if (name.isEmpty() && blockPos == null && count < 0 && count > 3) {
      //    source.sendError(Text.translatable("commands.home.fail"));
      //    return 0;
      // } else {
      //    source.sendFeedback(() -> Text.translatable("commands.home.success",blockPos), true);
      //    count = count + 1;
      //    return 1;
      // }
      count = count + 1;
      name1 = name;
      name2 = name;
      name3 = name;
      if (name.isEmpty() || blockPos == null || count < 0 || count > 3) {
         source.sendError(Text.translatable("commands.home.fail"));
         return 0;
      }
      if (count == 1 && name1 == name2 || name1 == name3) {
         entity.sendMessage(Text.translatable("commands.home.success.set",name1,blockPos));
         entity.addCommandTag(name1);
      } else {
         throw ModCommands.COMMMAND_HOME_NAME_EXCEPTION_TYPE.create();
      }

      if (count == 2 && name2 != name3 || name2 != name3) {
         entity.sendMessage(Text.translatable("commands.home.success.set",name2,blockPos));
         entity.addCommandTag(name2);
      } else {
         throw ModCommands.COMMMAND_HOME_NAME_EXCEPTION_TYPE.create();
      }

      if (count == 3 && name3 != name2 || name3 != name1) {
         entity.sendMessage(Text.translatable("commands.home.success.set",name3,blockPos));
         entity.addCommandTag(name3);
      } else {
         throw ModCommands.COMMMAND_HOME_NAME_EXCEPTION_TYPE.create();
      }
      source.sendFeedback(() -> Text.translatable("commands.home.success"), true);
      return 1;
   }

   private static void teleport(ServerCommandSource source, Entity target, ServerWorld world, double x, double y,double z, Set<PositionFlag> movementFlags, float yaw, float pitch, LookTarget facingLocation) throws CommandSyntaxException {
      BlockPos blockPos = BlockPos.ofFloored(x, y, z);
      if (!World.isValid(blockPos)) {
         throw INVALID_POSITION_EXCEPTION.create();
      } else {
         float f = MathHelper.wrapDegrees(yaw);
         float g = MathHelper.wrapDegrees(pitch);
         if (target.teleport(world, x, y, z, movementFlags, f, g)) {
            if (facingLocation != null) {
               // facingLocation.look()
            }

            label23: {
               if (target instanceof LivingEntity) {
                  LivingEntity livingEntity = (LivingEntity) target;
                  if (livingEntity.isFallFlying()) {
                     break label23;
                  }
               }

               target.setVelocity(target.getVelocity().multiply(1.0, 0.0, 1.0));
               target.setOnGround(true);
            }

            if (target instanceof PathAwareEntity) {
               PathAwareEntity pathAwareEntity = (PathAwareEntity) target;
               pathAwareEntity.getNavigation().stop();
            }

         }
      }
   }

}
