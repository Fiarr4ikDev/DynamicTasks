package com.fiarr4ikdev.dynamictasks;

import com.fiarr4ikdev.dynamictasks.command.GiveRewardCommand;
import com.fiarr4ikdev.dynamictasks.reward.ItemRewardImpl;
import org.bukkit.plugin.java.JavaPlugin;

public final class DynamicTasks extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemRewardImpl itemReward = new ItemRewardImpl();
        getCommand("givereward").setExecutor(new GiveRewardCommand(itemReward));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
