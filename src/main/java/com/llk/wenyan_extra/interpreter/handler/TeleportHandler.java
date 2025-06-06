package com.llk.wenyan_extra.interpreter.handler;

import indi.wenyan.content.entity.HandRunnerEntity;
import indi.wenyan.interpreter.structure.WenyanException;
import indi.wenyan.interpreter.structure.WenyanValue;
import indi.wenyan.interpreter.utils.JavacallHandler;

/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className TeleportHandler
 * @Description TODO 传送实体功能
 * @date 2025/6/5 22:29
 */
public class TeleportHandler extends JavacallHandler {
    private final HandRunnerEntity entity;
    public static final WenyanValue.Type[] ARGS_TYPE =
            {WenyanValue.Type.DOUBLE, WenyanValue.Type.DOUBLE, WenyanValue.Type.DOUBLE};

    public TeleportHandler(HandRunnerEntity entity) {
        this.entity = entity;
    }

    @Override
    public WenyanValue handle(WenyanValue[] args) {
            double x = (double) args[0].getValue();
            double y = (double) args[1].getValue();
            double z = (double) args[2].getValue();
            entity.teleportTo(x, y, z);
        return WenyanValue.NULL;
    }
}
