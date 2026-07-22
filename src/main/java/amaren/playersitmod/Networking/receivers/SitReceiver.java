package amaren.playersitmod.Networking.receivers;

import amaren.playersitmod.Entity.ModEntityReg;
import amaren.playersitmod.Networking.packets.SitPacket;
import amaren.playersitmod.PlayerSitMod;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;

public class SitReceiver {

    public static void init(){

        ServerPlayNetworking.registerGlobalReceiver(SitPacket.TYPE, ((sitPacket, context) -> {
            Player player = context.player();

            PlayerSitMod.LOGGER.info("packet received");

            if (!player.level().isClientSide() && !player.isPassenger() && player.onGround() && !player.isInLiquid()) {
                Entity entity = ModEntityReg.PLAYER_SIT.spawn((ServerLevel) player.level(),
                        sitPacket.blockPos(),
                        EntitySpawnReason.TRIGGERED);

                entity.setPos(player.position());
                player.startRiding(entity);
            }

        })
        );

    }
}
