package com.natamus.configurablemobpotioneffects.util;

import com.natamus.collective.functions.DataFunctions;
import com.natamus.collective.functions.NumberFunctions;
import com.natamus.collective.functions.StringFunctions;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Util {
	private static final String dirpath = DataFunctions.getConfigDirectory() + File.separator + "configurablemobpotioneffects";
	private static final File dir = new File(dirpath);
	private static final File permanentfile = new File(dirpath + File.separator + "permanenteffects.txt");
	private static final File damagefile = new File(dirpath + File.separator + "ondamageeffects.txt");
	
	public static HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>> mobpermanent = new HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>>();
	public static HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>> mobdamage = new HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>>();
	
	public static void loadMobConfigFile() throws IOException {
		mobpermanent = new HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>>();
		mobdamage = new HashMap<EntityType<?>, CopyOnWriteArrayList<MobEffectInstance>>();
		
		PrintWriter permanentwriter = null;
		PrintWriter damagewriter = null;
		if (!dir.isDirectory() || !permanentfile.isFile() || !damagefile.isFile()) {
			dir.mkdirs();
			
			if (!permanentfile.isFile()) {
				permanentwriter = new PrintWriter(dirpath + File.separator + "permanenteffects.txt", StandardCharsets.UTF_8);
			}
			if (!damagefile.isFile()) {
				damagewriter = new PrintWriter(dirpath + File.separator + "ondamageeffects.txt", StandardCharsets.UTF_8);
			}
		}
		else {
			String permanentcontent = new String(Files.readAllBytes(Paths.get(dirpath + File.separator + "permanenteffects.txt")));
			for (String line : permanentcontent.split("\n")) {
				if (line.trim().endsWith(",")) {
					line = line.trim();
					line = line.substring(0, line.length() - 1).trim();
				}
				
				if (line.length() < 5) {
					continue;
				}
				
				if (!line.contains("' : '")) {
					continue;
				}
				
				String[] linespl = line.split("' : '");
				if (linespl.length < 2) {
					continue;
				}
				
				String entityrl = linespl[0].substring(1).trim();
				String potioneffects = linespl[1].trim();
				potioneffects = potioneffects.substring(0, potioneffects.length() - 1).trim();
				
				Optional<Holder.Reference<EntityType<?>>> entitytypeOptionalReference = BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(entityrl));
				if (entitytypeOptionalReference.isEmpty()) {
					continue;
				}
				
				mobpermanent.put(entitytypeOptionalReference.get().value(), parseEffectString(potioneffects));
			}
			
			String damagecontent = new String(Files.readAllBytes(Paths.get(dirpath + File.separator + "ondamageeffects.txt")));
			for (String line : damagecontent.split("\n")) {
				if (line.trim().endsWith(",")) {
					line = line.trim();
					line = line.substring(0, line.length() - 1).trim();
				}
				
				if (line.length() < 5) {
					continue;
				}
				
				if (!line.contains("' : '")) {
					continue;
				}
				
				String[] linespl = line.split("' : '");
				if (linespl.length < 2) {
					continue;
				}
				
				String entityrl = linespl[0].substring(1).trim();
				String potioneffects = linespl[1].trim();
				potioneffects = potioneffects.substring(0, potioneffects.length() - 1).trim();

				Optional<Holder.Reference<EntityType<?>>> entitytypeOptionalReference = BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(entityrl));
				if (entitytypeOptionalReference.isEmpty()) {
					continue;
				}
				
				mobdamage.put(entitytypeOptionalReference.get().value(), parseEffectString(potioneffects));
			}
		}
		
		List<String> sortedpotions = new ArrayList<String>();
		List<String> sortedentities = new ArrayList<String>();
		HashMap<String, MobEffect> phm = new HashMap<String, MobEffect>();
		HashMap<String, EntityType<?>> ehm = new HashMap<String, EntityType<?>>();
		
		StringBuilder emptypermanenteffects = new StringBuilder();
		StringBuilder emptydamageeffects = new StringBuilder();
		
		if (permanentwriter != null || damagewriter != null) {
			for (ResourceLocation loc : BuiltInRegistries.MOB_EFFECT.keySet()) {
				Optional<Holder.Reference<MobEffect>> mobEffectOptionalReference = BuiltInRegistries.MOB_EFFECT.get(loc);
				if (mobEffectOptionalReference.isEmpty()) {
					continue;
				}

				String n = loc.toString().toLowerCase();
				if (n.contains(":")) {
					n = n.split(":")[1];
				}
				
				sortedpotions.add(n);
				phm.put(n, mobEffectOptionalReference.get().value());
			}
			for (ResourceLocation loc : BuiltInRegistries.ENTITY_TYPE.keySet()) {
				Optional<Holder.Reference<EntityType<?>>> entitytypeOptionalReference = BuiltInRegistries.ENTITY_TYPE.get(loc);
				if (entitytypeOptionalReference.isEmpty()) {
					continue;
				}

				String n = loc.toString().toLowerCase();
				if (n.contains(":")) {
					n = n.split(":")[1];
				}
				
				sortedentities.add(n);
				ehm.put(n, entitytypeOptionalReference.get().value());
			}
			
			Collections.sort(sortedpotions);
			Collections.sort(sortedentities);
			
			for (String effectstring : sortedpotions) {
				MobEffect effect = phm.get(effectstring);
				
				if (!emptypermanenteffects.toString().equals("")) {
					emptypermanenteffects.append("|");
				}
				if (!emptydamageeffects.toString().equals("")) {
					emptydamageeffects.append("|");
				}
				
				ResourceLocation rl = BuiltInRegistries.MOB_EFFECT.getKey(effect);
				
				emptypermanenteffects.append(rl.toString()).append(",lvl:0");
				emptydamageeffects.append(rl).append(",lvl:0,duration:5");
			}
		}
		
		boolean rerun = false;
		if (permanentwriter != null) {
			for (String entitytypestring : sortedentities) {
				EntityType<?> entitytype = ehm.get(entitytypestring);
				
				MobCategory classification = entitytype.getCategory();
				if (!classification.equals(MobCategory.MISC)) {
					ResourceLocation rl = BuiltInRegistries.ENTITY_TYPE.getKey(entitytype);
					permanentwriter.println("'" + rl + "'" + " : '" + emptypermanenteffects + "'," + "\n");
					
					mobpermanent.put(entitytype, new CopyOnWriteArrayList<MobEffectInstance>());
				}
			}
			
			permanentwriter.close();
			rerun = true;
		}
		
		if (damagewriter != null) {
			for (String entitytypestring : sortedentities) {
				EntityType<?> entitytype = ehm.get(entitytypestring);
				
				MobCategory classification = entitytype.getCategory();
				if (!classification.equals(MobCategory.MISC)) {
					ResourceLocation rl = BuiltInRegistries.ENTITY_TYPE.getKey(entitytype);
					damagewriter.println("'" + rl + "'" + " : '" + emptydamageeffects + "'," + "\n");
					
					mobdamage.put(entitytype, new CopyOnWriteArrayList<MobEffectInstance>());
				}
			}
			
			damagewriter.close();
			rerun = true;
		}

		if (rerun) {
			loadMobConfigFile();
		}
	}
	
	private static CopyOnWriteArrayList<MobEffectInstance> parseEffectString(String effectstring) {
		CopyOnWriteArrayList<MobEffectInstance> effectinstances = new CopyOnWriteArrayList<MobEffectInstance>();
		
		for (String effectpair : effectstring.split(StringFunctions.escapeSpecialRegexChars("|"))) {
			String[] epspl = effectpair.split(",");
			if (epspl.length < 2) {
				continue;
			}
			
			String effectrlstring = "";
			String lvlstring = "";
			String durationstring = "";
			for (String ep : epspl) {
				if (ep.contains("lvl:")) {
					lvlstring = ep.split(":")[1].trim();
				}
				else if (ep.contains("duration:")) {
					durationstring = ep.split(":")[1].trim();
				}
				else {
					effectrlstring = ep.trim();
				}
			}
			
			if (effectrlstring.equals("") || lvlstring.equals("")) {
				continue;
			}
			
			if (durationstring.equals("")) {
				durationstring = "0";
			}
			
			Optional<Holder.Reference<MobEffect>> mobEffectOptionalReference = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(effectrlstring));
			if (mobEffectOptionalReference.isEmpty()) {
				continue;
			}
			
			if (!NumberFunctions.isNumeric(lvlstring) || !NumberFunctions.isNumeric(durationstring)) {
				continue;
			}
			
			int level;
			int duration;
			try {
				level = Integer.parseInt(lvlstring);
				duration = Integer.parseInt(durationstring);
			}
			catch (NumberFormatException ex) {
				continue;
			}
			
			if (level == 0) {
				continue;
			}
			
			if (duration == 0) {
				duration = 100000000;
			}
			
			MobEffectInstance instance = new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(mobEffectOptionalReference.get().value()), duration*20, level-1, true, true);
			effectinstances.add(instance);
		}
		
		return effectinstances;
	}
}
