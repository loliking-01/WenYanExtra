package com.llk.wenyan_extra.interpreter.utils;

import com.llk.wenyan_extra.interpreter.handler.TeleportHandler;
import indi.wenyan.content.entity.HandRunnerEntity;
import indi.wenyan.interpreter.structure.WenyanRuntime;
import indi.wenyan.interpreter.utils.WenyanPackageBuilder;
import net.minecraft.world.entity.player.Player;

import static indi.wenyan.interpreter.utils.WenyanPackages.WENYAN_BASIC_PACKAGES;

/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className WenYanExtraPackages
 * @Description TODO 文言扩展包的加载类
 * @date 2025/6/5 21:47
 */
public class WenYanExtraPackages {

    //术法扩展包
    public static WenyanRuntime handEnvironment(Player holder, HandRunnerEntity runner) {
        return WenyanPackageBuilder.create()
                .environment(WENYAN_BASIC_PACKAGES)
                .function("「瞬」",new TeleportHandler(runner),TeleportHandler.ARGS_TYPE)
                .build();
    }

}
