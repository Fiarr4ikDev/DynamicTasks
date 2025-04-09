package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

/**
 * Реализация интерфейса IReward для выдачи случайной награды.
 */
public class RandomRewardImpl implements IReward {

    private final List<IReward> rewards;

    public RandomRewardImpl(List<IReward> rewards) {
        this.rewards = rewards;
    }

    /**
     * Выдает награду игроку в виде случайной награды.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        if (rewards.isEmpty()) {
            player.sendMessage("Список наград пуст.");
            return;
        }

        IReward randomReward = rewards.get(new Random().nextInt(rewards.size()));
        randomReward.giveReward(player);
        player.sendMessage(ChatColor.GOLD + "Вы получили случайную награду!");
    }

}
