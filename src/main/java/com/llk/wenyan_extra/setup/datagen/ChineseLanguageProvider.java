package com.llk.wenyan_extra.setup.datagen;

import com.llk.wenyan_extra.setup.Registration;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * @author qq240
 * @version 1.0
 * @className ChineseLanguageProvider
 * @Description TODO
 * @date 2025/6/6 8:34
 */
public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("title.wenyantextra.create_tab","吾有一术 拓展");
        this.add(Registration.TEST_BLOCK.get(),"测试方块");
        this.add(Registration.TEST_ITEM.get(),"测试物品");

    }
}
