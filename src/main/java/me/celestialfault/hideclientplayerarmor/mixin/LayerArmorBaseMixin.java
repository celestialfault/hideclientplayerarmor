package me.celestialfault.hideclientplayerarmor.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerArmorBase.class)
abstract class LayerArmorBaseMixin {
	@Inject(method = "renderLayer", at = @At("HEAD"), cancellable = true)
	public void hideclientplayerarmor$cancelArmorRender(EntityLivingBase entitylivingbaseIn, float p_177182_2_, float p_177182_3_, float partialTicks, float p_177182_5_, float p_177182_6_, float p_177182_7_, float scale, int armorSlot, CallbackInfo ci) {
		if(entitylivingbaseIn instanceof EntityPlayerSP) ci.cancel();
	}
}
