package amaren.playersitmod.Networking.packets;

import amaren.playersitmod.PlayerSitMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record SitPacket(BlockPos blockPos) implements CustomPacketPayload {

    public static final Identifier SUMMON_SIT_ENTITY =
            Identifier.fromNamespaceAndPath(PlayerSitMod.MOD_ID, "summon_sit_entity");
    public static final Type<SitPacket> TYPE =
            new Type<>(SUMMON_SIT_ENTITY);
    public static final StreamCodec<RegistryFriendlyByteBuf, SitPacket> CODEC =
            StreamCodec.composite(BlockPos.STREAM_CODEC, SitPacket::blockPos, SitPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
