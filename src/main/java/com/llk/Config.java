package com.llk;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 一个示例配置类。这不是必须的，但最好有一个，以便保持配置的整洁。
// 演示了如何使用 Neo 的配置 API
@EventBusSubscriber(modid = wenyanextra.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // 是否在公共设置中记录泥土方块
    private static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER.comment("是否在公共设置中记录泥土方块").define("logDirtBlock", true);

    // 一个神奇的数字
    private static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER.comment("一个神奇的数字").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    // 神奇数字的介绍信息
    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER.comment("神奇数字的介绍信息").define("magicNumberIntroduction", "神奇的数字是... ");

    // 一个字符串列表，被当作物品的资源定位符
    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER.comment("在公共设置中记录的物品列表。").defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    static final ModConfigSpec SPEC = BUILDER.build();

    // 是否记录泥土方块
    public static boolean logDirtBlock;
    // 神奇数字
    public static int magicNumber;
    // 神奇数字的介绍信息
    public static String magicNumberIntroduction;
    // 物品集合
    public static Set<Item> items;

    // 验证物品名称是否有效
    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    // 配置加载事件
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // 从配置中读取是否记录泥土方块
        logDirtBlock = LOG_DIRT_BLOCK.get();
        // 从配置中读取神奇数字
        magicNumber = MAGIC_NUMBER.get();
        // 从配置中读取神奇数字的介绍信息
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // 将字符串列表转换为物品集合
        items = ITEM_STRINGS.get().stream().map(itemName -> BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemName))).collect(Collectors.toSet());
    }
}