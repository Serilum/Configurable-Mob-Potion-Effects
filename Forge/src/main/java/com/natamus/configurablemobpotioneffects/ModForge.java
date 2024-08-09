package com.natamus.configurablemobpotioneffects;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.configurablemobpotioneffects.forge.events.ForgeMobEffectsEvent;
import com.natamus.configurablemobpotioneffects.util.Reference;
import com.natamus.configurablemobpotioneffects.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class ModForge {
	
	public ModForge() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
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

    	MinecraftForge.EVENT_BUS.register(new ForgeMobEffectsEvent());
	}

	private static void setGlobalConstants() {

	}
}