package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Интерфейс для реализации системы наград.
 */
public interface IReward {

    /**
     * Выдает награду игроку в виде списка предметов.
     *
     * @param player игрок, которому выдается награда
     * @param items  список предметов, которые будут выданы как награда
     */
    void giveReward(Player player, List<ItemStack> items);
}