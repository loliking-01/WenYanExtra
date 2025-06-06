package com.llk.wenyan_extra.setup;

import com.llk.wenyan_extra.interpreter.utils.WenyanExtraInitializer;
import indi.wenyan.WenyanNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.llk.wenyanextra.MODID;


/**
 * @author I_am_a_lolikong
 * @version 1.0
 * @className Registration
 * @Description TODO
 * @date 2025/6/5 23:09
 */
public class Registration {
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        BLOCK_ENTITY.register(modEventBus);
        ENTITY.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);


    }

    public static final DeferredRegister.Items ITEMS;
    public static final DeferredRegister.Blocks BLOCKS;
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY;
    public static final DeferredRegister<EntityType<?>> ENTITY;
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS;

    public static final DeferredItem<Item> TEST_ITEM;
    public static final DeferredBlock<Block> TEST_BLOCK;
    public static final DeferredItem<BlockItem> TEST_BLOCKITEM;
    static {
        ITEMS = DeferredRegister.createItems(MODID);
        BLOCKS = DeferredRegister.createBlocks(MODID);
        BLOCK_ENTITY=DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, WenyanNature.MODID);
        ENTITY=DeferredRegister.create(Registries.ENTITY_TYPE, WenyanNature.MODID);
        CREATIVE_MODE_TABS =DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

        TEST_ITEM=ITEMS.registerItem("wenyanextra_item",(Item.Properties properties)->new Item(new Item.Properties()));
        TEST_BLOCK= BLOCKS.register(
                "wenyanextra_block",
                () -> new Block(BlockBehaviour.Properties.of()
                ));
        TEST_BLOCKITEM=ITEMS.register("wenyanextra_blockitem",
                ()->new BlockItem(TEST_BLOCK.get(), new Item.Properties()
                ));

        CREATIVE_MODE_TABS.register("wenyanextra", () -> CreativeModeTab.builder()
                .title(Component.translatable("title.wenyantextra.create_tab"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> TEST_ITEM.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(TEST_ITEM.get());
                    output.accept(TEST_BLOCK.get());

                }).build());
        //加载术法
        WenyanExtraInitializer.init();

    }

}
