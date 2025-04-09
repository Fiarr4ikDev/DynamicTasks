package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.entity.Player;

/**
 * Интерфейс для реализации системы наград.
 */
public interface IReward {

    /**
     * Выдает награду игроку.
     *
     * @param player игрок, которому выдается награда
     */
    void giveReward(Player player);
}