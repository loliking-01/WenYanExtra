package com.llk.wenyan_extra.setup.datagen;

import com.llk.wenyanextra;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className ModDataGeneratorHandler
 * @Description TODO 构建并输出中文语言文件
 * @date 2025/6/6 9:21
 */
@EventBusSubscriber(modid = wenyanextra.MODID,bus = EventBusSubscriber.Bus.MOD)
public class ModDataGeneratorHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // 注册提供者。
        generator.addProvider(
                // 一个布尔值，决定是否实际生成数据。
                // 事件提供了以下方法来确定这一点：
                // event.includeClient()、event.includeServer()、
                // event.includeDev() 和 event.includeReports()。
                // 由于语言文件是客户端资源，我们只在客户端数据生成中运行它们。
                event.includeClient(),
                // 我们的提供者。
                new ChineseLanguageProvider(output,wenyanextra.MODID,"zh_cn")
        );
    }
}
