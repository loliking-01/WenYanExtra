package com.llk.wenyan_extra.interpreter.utils;

import indi.wenyan.interpreter.structure.WenyanRuntime;
import indi.wenyan.interpreter.utils.WenyanPackages;

/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className WenyanExtraInitializer
 * @Description TODO 文言拓展功能初始化
 * @date 2025/6/6 8:28
 */
public class WenyanExtraInitializer {
    public static void init() {
        // 注册扩展包到文言模组的运行库中
        WenyanPackages.PACKAGES.put("「「瞬移」」", createExtraPackage());
    }

    private static WenyanRuntime createExtraPackage() {
        return new WenYanExtraPackages().handEnvironment(null, null);
    }
}
