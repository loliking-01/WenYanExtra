package com.llk.wenyan_extra.setup.datagen;

import com.llk.wenyan_extra.setup.Registration;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className ChineseLanguageProvider
 * @Description TODO 中文语言
 * @date 2025/6/6 8:34
 */
public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registration.CREATIVE_MODE_TABS.getRegistryName().toLanguageKey(),"吾有一术 拓展");
        add(Registration.TEST_BLOCK.get(),"测试方块");
        add(Registration.TEST_BLOCKITEM.get(),"测试方块物品");
        add(Registration.TEST_ITEM.get(),"测试物品");

    }

}
