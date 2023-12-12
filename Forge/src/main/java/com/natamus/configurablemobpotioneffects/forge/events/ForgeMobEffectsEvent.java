package com.natamus.configurablemobpotioneffects.forge.events;

import com.natamus.configurablemobpotioneffects.cmd.CommandCmpe;
import com.natamus.configurablemobpotioneffects.events.MobEffectsEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeMobEffectsEvent {
    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent e) {
    	CommandCmpe.register(e.getDispatcher());
    }

	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent e) {
		MobEffectsEvent.onEntityJoin(e.getWorld(), e.getEntity());
	}
	
	@SubscribeEvent
	public void onEntityDamage(LivingHurtEvent e) {
		LivingEntity livingEntity = e.getEntityLiving();
		MobEffectsEvent.onEntityDamage(livingEntity.level, livingEntity, e.getSource(), e.getAmount());
	}
}
