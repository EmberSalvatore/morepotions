package net.embersalvatore.effects.harmful;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class LightningEffect extends InstantenousMobEffect {


    public LightningEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        //LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, pLivingEntity.level());
        //ServerLevel level = (ServerLevel) pLivingEntity.level();
        //lightningBolt.thunderHit(level, lightningBolt);
        LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(pLivingEntity.level());
        lightningbolt.moveTo(pLivingEntity.position());
        lightningbolt.setCause(pSource instanceof ServerPlayer ? (ServerPlayer) pSource : null);
        pLivingEntity.level().addFreshEntity(lightningbolt);

        //lightningBolt.thunderHit(pLivingEntity.level()., lightningBolt);
        //lightningBolt.setPos(pLivingEntity.getOnPos().getCenter());

        super.applyInstantenousEffect(pSource, pIndirectSource, pLivingEntity, pAmplifier, pHealth);
    }
}
