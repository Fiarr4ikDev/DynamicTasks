package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.entity.Player;

public class XpLevelsRewardImpl implements IReward {

    private final int levels;

    public XpLevelsRewardImpl(int levels) {
        this.levels = levels;
    }

    @Override
    public void giveReward(Player player) {
        player.setLevel(player.getLevel() + levels);
        player.sendMessage("Вы получили " + levels + " уровней опыта!");
    }
}
