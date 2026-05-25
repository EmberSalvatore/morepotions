package net.embersalvatore.effects.neutral;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class LeapEffect extends InstantenousMobEffect {

    public LeapEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        Vec3 initialVec = pLivingEntity.getDeltaMovement();
        Vec3 leapVec = new Vec3(0, 1.04D, 0);
        pLivingEntity.setDeltaMovement(leapVec.x, leapVec.y, leapVec.z);

        super.applyInstantenousEffect(pSource, pIndirectSource, pLivingEntity, pAmplifier, pHealth);
    }
}
