package amaren.playersitmod.client;

import amaren.playersitmod.Entity.ModEntityReg;
import amaren.playersitmod.client.Renderers.PlayerSitRenderer;
import amaren.playersitmod.client.keyevents.KeyBinds;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class PlayerSitModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		KeyBinds.init();


		EntityRenderers.register(ModEntityReg.PLAYER_SIT, PlayerSitRenderer::new);
	}
}