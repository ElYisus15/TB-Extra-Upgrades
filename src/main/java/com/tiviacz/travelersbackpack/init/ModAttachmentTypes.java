package com.tiviacz.travelersbackpack.init;

import com.tiviacz.travelersbackpack.TravelersBackpack;
import com.tiviacz.travelersbackpack.capability.TravelersBackpackSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, TravelersBackpack.MODID);

    public static final Supplier<AttachmentType<TravelersBackpackSerializable>> TRAVELERS_BACKPACK = ATTACHMENT_TYPES.register("travelers_backpack",
            () -> AttachmentType.serializable(TravelersBackpackSerializable::new).copyOnDeath().build());
}