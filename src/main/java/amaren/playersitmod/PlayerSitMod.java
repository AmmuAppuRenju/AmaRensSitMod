package amaren.playersitmod;

import amaren.playersitmod.Entity.ModEntityReg;
import amaren.playersitmod.Networking.packets.SitPacket;
import amaren.playersitmod.Networking.receivers.SitReceiver;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerSitMod implements ModInitializer {
	public static final String MOD_ID = "playersitmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModEntityReg.registerModEntityTypes();
		PayloadTypeRegistry.serverboundPlay().register(SitPacket.TYPE, SitPacket.CODEC);

		SitReceiver.init();

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
