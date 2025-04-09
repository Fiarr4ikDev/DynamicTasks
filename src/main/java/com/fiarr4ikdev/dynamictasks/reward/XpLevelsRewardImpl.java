package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Реализация интерфейса IReward для выдачи уровней опыта в качестве награды.
 */
public class XpLevelsRewardImpl implements IReward {

    private final int levels;

    public XpLevelsRewardImpl(int levels) {
        this.levels = levels;
    }

    /**
     * Выдает награду игроку в виде уровней опыта.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        player.setLevel(player.getLevel() + levels);
        player.sendMessage(ChatColor.GREEN + "Вы получили " + levels + " уровней опыта!");
    }

}
