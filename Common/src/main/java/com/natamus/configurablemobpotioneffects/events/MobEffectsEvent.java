package com.natamus.configurablemobpotioneffects.events;

import com.natamus.configurablemobpotioneffects.util.Util;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.concurrent.CopyOnWriteArrayList;

public class MobEffectsEvent {
	public static void onEntityJoin(Level world, Entity entity) {
		if (world.isClientSide) {
			return;
		}
		
		if (!(entity instanceof LivingEntity)) {
			return;
		}
		
		EntityType<?> entitytype = entity.getType();
		if (!Util.mobpermanent.containsKey(entitytype)) {
			return;
		}
		
		CopyOnWriteArrayList<MobEffectInstance> effectinstances = Util.mobpermanent.get(entitytype);
		if (effectinstances.size() > 0) {
			LivingEntity le = (LivingEntity)entity;
			
			for (MobEffectInstance effectinstance : effectinstances) {
				MobEffectInstance ei = new MobEffectInstance(effectinstance);
				
				le.removeEffect(ei.getEffect());
				le.addEffect(ei);
			}
		}
	}
	
	public static void onEntityDamage(Level world, Entity entity, DamageSource damageSource, float damageAmount) {
		if (world.isClientSide) {
			return;
		}
		
		Entity source = damageSource.getEntity();
		if (source == null) {
			return;
		}
		
		EntityType<?> sourcetype = source.getType();
		if (!Util.mobdamage.containsKey(sourcetype)) {
			return;
		}
		
		LivingEntity le = (LivingEntity)entity;
		
		CopyOnWriteArrayList<MobEffectInstance> effectinstances = Util.mobdamage.get(sourcetype);
		if (effectinstances.size() > 0) {
			for (MobEffectInstance effectinstance : effectinstances) {
				MobEffectInstance ei = new MobEffectInstance(effectinstance);
				
				le.removeEffect(ei.getEffect());
				le.addEffect(ei);
			}
		}		
	}
}
