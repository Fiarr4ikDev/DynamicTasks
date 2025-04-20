package com.fiarr4ikdev.dynamictasks;

import com.fiarr4ikdev.dynamictasks.handler.CrateHandler;
import com.fiarr4ikdev.dynamictasks.reward.CrateRewardImpl;
import com.fiarr4ikdev.dynamictasks.service.ChatService;
import com.fiarr4ikdev.dynamictasks.service.ConfigService;
import com.fiarr4ikdev.dynamictasks.service.InventoryService;
import org.bukkit.plugin.java.JavaPlugin;

public final class DynamicTasks extends JavaPlugin {

    @Override
    public void onEnable() {
        ChatService chatService = new ChatService();
        ConfigService configService = new ConfigService(this);
        InventoryService inventoryService = new InventoryService(configService);
        CrateRewardImpl crateReward = new CrateRewardImpl(chatService, configService);
        getServer().getPluginManager().registerEvents(new CrateHandler(crateReward, inventoryService), this);
    }

    @Override
    public void onDisable() {

    }

}
