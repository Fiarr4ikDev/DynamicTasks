package com.fiarr4ikdev.dynamictasks.reward;

import com.fiarr4ikdev.dynamictasks.service.ConfigService;
import com.fiarr4ikdev.dynamictasks.service.ChatService;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Реализация интерфейса IReward для выдачи ящика с предметами
 */
public class CrateRewardImpl implements IReward {

    private final ChatService chatService;
    private final ConfigService configService;

    public CrateRewardImpl(ChatService chatService, ConfigService configService) {
        this.chatService = chatService;
        this.configService = configService;
    }

    /**
     * Выдает награду игроку в виде ящика.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        ItemStack crate = generateCrate();
        player.getWorld().dropItem(player.getLocation(), crate);
        chatService.sendMessage(player, "Вам выдан ящик в виде награды");
    }

    /**
     * Метод для генерации ящика с наградами.
     * Содержит мету для того, чтобы предмет был уникален.
     * @return предмет ящика
     */
    public ItemStack generateCrate() {
        ItemStack crate = new ItemStack(Material.BARREL);
        ItemMeta crateMeta = crate.getItemMeta();
        assert crateMeta != null;
        crateMeta.setDisplayName(chatService.color(configService.getConfig().getString("crate.name")));
        List<String> lore = configService.getConfig().getStringList("crate.lore");
        crateMeta.setLore(lore);
        crate.setItemMeta(crateMeta);
        //TODO
        return crate;
    }

}
