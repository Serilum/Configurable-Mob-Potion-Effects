package com.natamus.configurablemobpotioneffects;

import com.natamus.collective.check.RegisterMod;
import com.natamus.configurablemobpotioneffects.neoforge.events.NeoForgeMobEffectsEvent;
import com.natamus.configurablemobpotioneffects.util.Reference;
import com.natamus.configurablemobpotioneffects.util.Util;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		try {
			Util.loadMobConfigFile();
		} catch (Exception ex) {
			System.out.println("[" + Reference.NAME + "] Error loading the entity config file. The mod has been disabled.");
			return;
		}

		NeoForge.EVENT_BUS.register(NeoForgeMobEffectsEvent.class);
	}

	private static void setGlobalConstants() {

	}
}