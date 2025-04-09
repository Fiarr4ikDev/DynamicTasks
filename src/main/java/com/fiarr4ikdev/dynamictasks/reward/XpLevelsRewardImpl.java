package com.fiarr4ikdev.dynamictasks.reward;

import com.fiarr4ikdev.dynamictasks.service.ChatService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Реализация интерфейса IReward для выдачи уровней опыта в качестве награды.
 */
public class XpLevelsRewardImpl implements IReward {

    private final int levels;
    private final ChatService chatService;

    public XpLevelsRewardImpl(int levels, ChatService chatService) {
        this.levels = levels;
        this.chatService = chatService;
    }

    /**
     * Выдает награду игроку в виде уровней опыта.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        player.setLevel(player.getLevel() + levels);
        chatService.sendMessage(player, ChatColor.GREEN + "Вы получили " + levels + " уровней опыта!");
    }

}
