package com.natamus.configurablemobpotioneffects.cmd;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.configurablemobpotioneffects.util.Util;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.ChatFormatting;

public class CommandCmpe {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("cmpe").requires((iCommandSender) -> iCommandSender.hasPermission(2))
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				
				MessageFunctions.sendMessage(source, "Usage:", ChatFormatting.DARK_GREEN);
				MessageFunctions.sendMessage(source, " /cmpe reload", ChatFormatting.YELLOW);
				MessageFunctions.sendMessage(source, "  Reloads the config files located in ./config/configurablemobpotioneffects/", ChatFormatting.DARK_GRAY);
				return 1;
			})
			.then(Commands.literal("reload")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				
				try {
					Util.loadMobConfigFile();
				} catch (Exception ex) {
					MessageFunctions.sendMessage(source, "Something went wrong while reloading the config file.", ChatFormatting.RED);
					ex.printStackTrace();
					return 0;
				}
				
				MessageFunctions.sendMessage(source, "Successfully loaded the mob potion effect config files.", ChatFormatting.DARK_GREEN);
				return 1;
			}))
		);
	}
}
