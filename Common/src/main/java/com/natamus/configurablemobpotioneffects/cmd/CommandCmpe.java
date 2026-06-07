package com.natamus.configurablemobpotioneffects.cmd;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.configurablemobpotioneffects.util.Util;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.ChatFormatting;

public class CommandCmpe {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("cmpe").requires((iCommandSender) -> iCommandSender.permissions().hasPermission(Permissions.COMMANDS_ADMIN))
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				
				MessageFunctions.sendTranslatableMessage(source, "collective.configurablemobpotioneffects.message.usage", ChatFormatting.DARK_GREEN);
				MessageFunctions.sendMessage(source, " /cmpe reload", ChatFormatting.YELLOW);
				MessageFunctions.sendTranslatableMessage(source, "  ", "collective.configurablemobpotioneffects.message.reloadsconfigfiles", ChatFormatting.DARK_GRAY);
				return 1;
			})
			.then(Commands.literal("reload")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				
				try {
					Util.loadMobConfigFile();
				} catch (Exception ex) {
					MessageFunctions.sendTranslatableMessage(source, "collective.configurablemobpotioneffects.message.somethingwentwrong", ChatFormatting.RED);
					ex.printStackTrace();
					return 0;
				}
				
				MessageFunctions.sendTranslatableMessage(source, "collective.configurablemobpotioneffects.message.successfullyloadedmob", ChatFormatting.DARK_GREEN);
				return 1;
			}))
		);
	}
}
