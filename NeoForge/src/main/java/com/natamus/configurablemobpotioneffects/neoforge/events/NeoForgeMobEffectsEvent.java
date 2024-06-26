package com.natamus.configurablemobpotioneffects.neoforge.events;

import com.natamus.configurablemobpotioneffects.cmd.CommandCmpe;
import com.natamus.configurablemobpotioneffects.events.MobEffectsEvent;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class NeoForgeMobEffectsEvent {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandCmpe.register(e.getDispatcher());
	}

	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		MobEffectsEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public static void onEntityDamage(LivingDamageEvent.Post e) {
		LivingEntity livingEntity = e.getEntity();
		MobEffectsEvent.onEntityDamage(livingEntity.level(), livingEntity, e.getSource(), e.getNewDamage());
	}
}
