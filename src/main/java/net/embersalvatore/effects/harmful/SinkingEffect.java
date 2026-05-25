package net.embersalvatore.effects.harmful;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class SinkingEffect extends MobEffect {

    public SinkingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isInWater()){
            boolean canSucceed = true;
            if(pLivingEntity instanceof Player){
                Player player = (Player) pLivingEntity;
                canSucceed = !player.isCreative();
            }
            if(canSucceed){
                Vec3 initialVec = pLivingEntity.getDeltaMovement();
                Vec3 sinkingVec = new Vec3(initialVec.x, -0.04D * (pAmplifier + 1), initialVec.z);
                pLivingEntity.setDeltaMovement(sinkingVec.x * 0.8D, sinkingVec.y * 0.8D, sinkingVec.z * 0.8D);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
