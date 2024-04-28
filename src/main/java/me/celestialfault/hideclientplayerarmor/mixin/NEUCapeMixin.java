package me.celestialfault.hideclientplayerarmor.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.moulberry.notenoughupdates.cosmetics.NEUCape;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NEUCape.class)
abstract class NEUCapeMixin {
	@ModifyExpressionValue(
		method = {"updateFixedCapeNodes", "updateFixedCapeNodesPartial"},
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/player/EntityPlayer;getCurrentArmor(I)Lnet/minecraft/item/ItemStack;"
		)
	)
	public ItemStack hideclientplayerarmor$fixCapeAnglesForHiddenArmor(ItemStack original, @Local(argsOnly = true) EntityPlayer player) {
		return player instanceof EntityPlayerSP ? null : original;
	}
}
