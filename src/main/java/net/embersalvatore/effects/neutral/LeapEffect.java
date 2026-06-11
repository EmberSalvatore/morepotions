package net.embersalvatore.effects.neutral;

import net.embersalvatore.effects.ModEffects;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class LeapEffect extends /*Instantenous*/MobEffect {

    public LeapEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

         Vec3 initialVec = pLivingEntity.getDeltaMovement();
         Vec3 leapVec = new Vec3(initialVec.x, 1.04D, initialVec.z);
         pLivingEntity.setDeltaMovement(leapVec.x, leapVec.y, leapVec.z);

         if(pLivingEntity.getTags().contains("leapEffect")){
             pLivingEntity.removeEffect(ModEffects.LEAP.get());
             pLivingEntity.getTags().remove("leapEffect");
         } else {
             pLivingEntity.getTags().add("leapEffect");
         }

        super.applyEffectTick(pLivingEntity, pAmplifier);

    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    /*@Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        Vec3 initialVec = pLivingEntity.getDeltaMovement();
        Vec3 leapVec = new Vec3(initialVec.x, 1.04D, initialVec.z);
        pLivingEntity.setDeltaMovement(leapVec.x, leapVec.y, leapVec.z);

        if(pLivingEntity instanceof Player){
            Player player = (Player) pLivingEntity;
            if(player.level().isClientSide()){
                player.move(MoverType.PLAYER, leapVec);
                //player.
            }

        }
        applyEffectTick(pLivingEntity, pAmplifier);
        super.applyInstantenousEffect(pSource, pIndirectSource, pLivingEntity, pAmplifier, pHealth);
    }*/
}
