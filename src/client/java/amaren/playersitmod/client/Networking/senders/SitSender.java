package amaren.playersitmod.client.Networking.senders;


import amaren.playersitmod.Networking.packets.SitPacket;
import amaren.playersitmod.PlayerSitMod;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.world.entity.player.Player;


public class SitSender {
    public static void keypressed(Player player){

        PlayerSitMod.LOGGER.info("packet sent");

        SitPacket packet = new SitPacket(player.blockPosition());

        ClientPlayNetworking.send(packet);

    }
}
