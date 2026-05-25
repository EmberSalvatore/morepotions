package net.embersalvatore.events;

import net.embersalvatore.MorePotions;
import net.embersalvatore.effects.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingGetProjectileEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MorePotions.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onEntityDamaged(LivingDamageEvent event){
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        Float amount = event.getAmount();

        if(source.is(DamageTypes.ARROW)){
            //MorePotions.LOGGER.info("Source is of damage type arrow");
            if(source.getEntity() instanceof LivingEntity){
                //MorePotions.LOGGER.info("Amount before calculation:" + event.getAmount());
                LivingEntity sourceEntity = (LivingEntity) source.getEntity();
                if(sourceEntity.getActiveEffectsMap().containsKey(ModEffects.ARCHERY.get())){
                    event.setAmount(event.getAmount() * (1 + 0.15f * (1+sourceEntity.getActiveEffectsMap().get(ModEffects.ARCHERY.get()).getAmplifier())));
                }
                //MorePotions.LOGGER.info("Amount after calculation:" + event.getAmount());
            }
        }

        if(source.is(DamageTypes.FALL)){
            if(entity.getActiveEffectsMap().containsKey(ModEffects.ACROBATICS.get())){
                event.setAmount((event.getAmount() * (1 - 0.25f * (1+entity.getActiveEffectsMap().get(ModEffects.ACROBATICS.get()).getAmplifier()))));
            }
        }


    }

    @SubscribeEvent
    public static void onEntityAttack(LivingAttackEvent event){
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        Float amount = event.getAmount();

        LivingEntity attacker;

        if(source.getEntity() instanceof LivingEntity){
            attacker = (LivingEntity) source.getEntity();

            if(attacker.getActiveEffectsMap().containsKey((ModEffects.MARTYR.get())) && !entity.getActiveEffectsMap().containsKey(ModEffects.MARTYR.get())){
                event.setCanceled(true);
                Float newAmount = (amount / 10) * (attacker.getActiveEffectsMap().get(ModEffects.MARTYR.get()).getAmplifier() + 1);
                entity.heal(newAmount);
                attacker.hurt(attacker.damageSources().magic(), newAmount);
            }
        }

    }

    @SubscribeEvent
    public static void onProjectile(ProjectileImpactEvent event){
        /*
        Entity projectile = event.getEntity();
        String projectileName = event.getProjectile().getDisplayName().getString();

        Vec3 location = event.getRayTraceResult().getLocation();

        MorePotions.LOGGER.info("Projectile name: " + projectileName);
        MorePotions.LOGGER.info("Entity name: " + event.getEntity().getDisplayName().getString());

        MorePotions.LOGGER.info(event.getRayTraceResult().getType().toString());



        if(projectile.level().hasNearbyAlivePlayer(location.x, location.y, location.z, 2)){
            Player player = projectile.level().getNearestPlayer(location.x, location.y, location.z, 2, null);
            if(player != null) {
                Vec3 Motion = new Vec3(player.getDeltaMovement().x, player.getDeltaMovement().y * 2 + 1, player.getDeltaMovement().z);
                player.setDeltaMovement(Motion);
                MorePotions.LOGGER.info("Player nearby: " + player.getDisplayName().getString());
            } else {
                MorePotions.LOGGER.info("null");
            }
        }*/
    }
}
