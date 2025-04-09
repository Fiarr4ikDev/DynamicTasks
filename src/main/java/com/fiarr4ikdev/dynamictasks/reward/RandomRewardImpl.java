package com.fiarr4ikdev.dynamictasks.reward;

import com.fiarr4ikdev.dynamictasks.service.ChatService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

/**
 * Реализация интерфейса IReward для выдачи случайной награды.
 */
public class RandomRewardImpl implements IReward {

    private final List<IReward> rewards;
    private final ChatService chatService;

    public RandomRewardImpl(List<IReward> rewards, ChatService chatService) {
        this.rewards = rewards;
        this.chatService = chatService;
    }

    /**
     * Выдает награду игроку в виде случайной награды.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        if (rewards.isEmpty()) {
            chatService.sendMessage(player, "Список наград пуст.");
            return;
        }

        IReward randomReward = rewards.get(new Random().nextInt(rewards.size()));
        randomReward.giveReward(player);
        chatService.sendMessage(player, ChatColor.GOLD + "Вы получили случайную награду!");
    }

}
