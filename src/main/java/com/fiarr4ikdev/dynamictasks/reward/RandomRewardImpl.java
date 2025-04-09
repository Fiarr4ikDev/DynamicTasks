package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RandomRewardImpl implements IReward {

    private final List<IReward> rewards;

    public RandomRewardImpl(List<IReward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public void giveReward(Player player) {
        if (rewards.isEmpty()) {
            player.sendMessage("Список наград пуст.");
            return;
        }

        IReward randomReward = rewards.get(new Random().nextInt(rewards.size()));
        randomReward.giveReward(player);
        player.sendMessage("Вы получили случайную награду!");
    }
}
