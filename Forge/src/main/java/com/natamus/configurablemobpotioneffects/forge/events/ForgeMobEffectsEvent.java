package com.natamus.configurablemobpotioneffects.forge.events;

import com.natamus.configurablemobpotioneffects.cmd.CommandCmpe;
import com.natamus.configurablemobpotioneffects.events.MobEffectsEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeMobEffectsEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeMobEffectsEvent.class);
	}

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent e) {
    	CommandCmpe.register(e.getDispatcher());
    }

	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		MobEffectsEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public static void onEntityDamage(LivingHurtEvent e) {
		LivingEntity livingEntity = e.getEntity();
		MobEffectsEvent.onEntityDamage(livingEntity.level(), livingEntity, e.getSource(), e.getAmount());
	}
}
