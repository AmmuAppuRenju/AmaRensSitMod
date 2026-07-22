package amaren.playersitmod.client.keyevents;


import amaren.playersitmod.PlayerSitMod;
import amaren.playersitmod.client.Networking.senders.SitSender;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static void init(){

        KeyMapping.Category CATEGORY = KeyMapping.Category.register(
                Identifier.fromNamespaceAndPath(PlayerSitMod.MOD_ID, "player_actions")
        );

        KeyMapping sit = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.playersitmod.sit",
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_Y,
                        CATEGORY
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (sit.consumeClick()) {
                SitSender.keypressed(client.player);
            }
        });

    }
}


