package com.fiarr4ikdev.dynamictasks.reward;

import com.fiarr4ikdev.dynamictasks.service.ChatService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Реализация интерфейса IReward для выдачи эффекта зелья в качестве награды.
 */
public class PotionEffectRewardImpl implements IReward {

    private final PotionEffect effect;
    private final ChatService chatService;

    public PotionEffectRewardImpl(PotionEffect effect, ChatService chatService) {
        this.effect = effect;
        this.chatService = chatService;
    }

    /**
     * Выдает награду игроку в виде эффекта зелья.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        player.addPotionEffect(effect);
        chatService.sendMessage(player, ChatColor.GOLD + "Вы получили эффект зелья: " + effect.getType().getName().toLowerCase());
    }

}
