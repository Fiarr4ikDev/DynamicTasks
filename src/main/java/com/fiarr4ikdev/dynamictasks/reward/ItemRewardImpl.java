package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса IReward для выдачи предметов в качестве награды.
 */
public class ItemRewardImpl implements IReward {

    private final List<ItemStack> items;

    public ItemRewardImpl(List<ItemStack> items) {
        this.items = items;
    }

    /**
     * Выдает награду игроку в виде списка предметов.
     * Все предметы добавляются в инвентарь.
     * Если инвентарь полон, оставшиеся предметы выбрасываются на землю.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        for (ItemStack item : items) {
            Map<Integer, ItemStack> remainingItems = player.getInventory().addItem(item);
            if (!remainingItems.isEmpty()) {
                player.sendMessage(ChatColor.RED + "Инвентарь заполнен! Некоторые предметы были выброшены на землю.");
                remainingItems.values().forEach(remainingItem -> player.getWorld().dropItem(player.getLocation(), remainingItem));
            }
        }
    }

}
