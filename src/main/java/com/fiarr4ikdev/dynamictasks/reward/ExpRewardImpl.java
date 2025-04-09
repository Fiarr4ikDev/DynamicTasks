package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ExpRewardImpl implements IReward {

    private final int experience;

    public ExpRewardImpl(int experience) {
        this.experience = experience;
    }
    @Override
    public void giveReward(Player player) {
        player.giveExp(experience);
        player.sendMessage(ChatColor.GREEN + "Вы получили " + experience + " единиц опыта!");
    }
}
