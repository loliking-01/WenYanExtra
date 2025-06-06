package com.llk;

import com.llk.wenyan_extra.setup.Registration;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;


@Mod(wenyanextra.MODID)
public class wenyanextra {
    public static final String MODID = "wenyanextra";
    private static final Logger LOGGER = LogUtils.getLogger();


    public wenyanextra(IEventBus modEventBus, ModContainer modContainer) {
        Registration.register(modEventBus);
    }

}