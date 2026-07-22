package amaren.playersitmod.client.Renderers;

import amaren.playersitmod.Entity.PlayerSitEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PlayerSitRenderer extends EntityRenderer<PlayerSitEntity, PlayerSitEntityRenderState> {

    public PlayerSitRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public PlayerSitEntityRenderState createRenderState() {
        return new PlayerSitEntityRenderState();
    }

    @Override
    public boolean shouldRender(PlayerSitEntity entity, Frustum culler, double camX, double camY, double camZ) {
        return true;
    }
}
