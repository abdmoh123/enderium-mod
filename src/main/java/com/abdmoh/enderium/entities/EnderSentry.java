package com.abdmoh.enderium.entities;

import com.abdmoh.enderium.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EnderSentry extends MonsterEntity {

    @SuppressWarnings("unchecked")
    public EnderSentry(EntityType<? extends MonsterEntity> type, World worldIn) {
        super((EntityType<? extends MonsterEntity>) ModEntities.ENDER_SENTRY, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
    }
}
