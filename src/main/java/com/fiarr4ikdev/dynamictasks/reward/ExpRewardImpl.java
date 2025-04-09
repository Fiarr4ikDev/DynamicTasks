package com.fiarr4ikdev.dynamictasks.reward;

import com.fiarr4ikdev.dynamictasks.service.ChatService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Реализация интерфейса IReward для выдачи опыта в качестве награды.
 */
public class ExpRewardImpl implements IReward {

    private final int experience;
    private final ChatService chatService;

    public ExpRewardImpl(int experience, ChatService chatService) {
        this.experience = experience;
        this.chatService = chatService;
    }

    /**
     * Выдает награду игроку в виде опыта.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        player.giveExp(experience);
        chatService.sendMessage(player, ChatColor.GREEN + "Вы получили " + experience + " единиц опыта!");
    }

}
