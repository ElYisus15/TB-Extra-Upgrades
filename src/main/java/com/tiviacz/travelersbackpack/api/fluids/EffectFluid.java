package com.tiviacz.travelersbackpack.api.fluids;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

public abstract class EffectFluid {
    public final String uniqueId;
    public final Fluid fluid;
    public int effectID;
    public final int amountRequired;

    public EffectFluid(String uniqueId, FluidStack fluidStack, int amountRequired) {
        this(uniqueId, fluidStack.getFluid(), amountRequired);
    }

    public EffectFluid(String uniqueId, Fluid fluid, int amountRequired) {
        this.uniqueId = uniqueId;
        this.fluid = fluid;
        this.effectID = 0;
        this.amountRequired = amountRequired;

        if(fluid != null) {
            com.tiviacz.travelersbackpack.fluids.EffectFluidRegistry.registerFluidEffect(this);
        }
    }

    public EffectFluid(String uniqueId, String modid, String fluidName, int amountRequired) {
        Fluid fluid = BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(modid, fluidName));
        this.uniqueId = uniqueId;
        this.fluid = fluid;
        this.effectID = 0;
        this.amountRequired = amountRequired;

        if(fluid != null) {
            com.tiviacz.travelersbackpack.fluids.EffectFluidRegistry.registerFluidEffect(this);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setEffectID(int id) {
        effectID = id;
    }

    public int getEffectID() {
        return effectID;
    }

    /**
     * This method determines what will happen to the player (or world!) when drinking the
     * corresponding fluid. For example set potion effects, set player on fire,
     * heal, fill hunger, etc. You can use the world parameter to make
     * conditions based on where the player is.
     *
     * @param world  The World.
     * @param entity The entity that will be affected.
     */
    public abstract void affectDrinker(FluidStack stack, Level world, Entity entity);

    /**
     * This method runs before hose is used.
     *
     * @param world  The World.
     * @param entity The entity that will be affected.
     */
    public abstract boolean canExecuteEffect(FluidStack stack, Level world, Entity entity);
}