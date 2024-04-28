package me.celestialfault.hideclientplayerarmor.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerCustomHead.class)
abstract class LayerCustomHeadMixin {
	@Inject(method = "doRenderLayer", at = @At("HEAD"), cancellable = true)
	public void hideclientplayerarmor$cancelWornSkullRendering(EntityLivingBase entitylivingbaseIn, float f, float g, float partialTicks, float h, float i, float j, float scale, CallbackInfo ci) {
		if(entitylivingbaseIn instanceof EntityPlayerSP) ci.cancel();
	}
}
