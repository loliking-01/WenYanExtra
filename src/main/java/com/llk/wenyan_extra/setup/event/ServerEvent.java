package com.llk.wenyan_extra.setup.event;

import com.llk.wenyanextra;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className ServerEvent
 * @Description TODO
 * @date 2025/6/5 23:06
 */
@EventBusSubscriber(modid = wenyanextra.MODID)
public class ServerEvent {
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        wenyanextra.LOGGER.info("道曰：「「大道三千，于我何在？」」");
    }
}
