package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Реализация интерфейса IReward для выдачи эффекта зелья в качестве награды.
 */
public class PotionEffectRewardImpl implements IReward {

    private final PotionEffect effect;

    public PotionEffectRewardImpl(PotionEffect effect) {
        this.effect = effect;
    }

    /**
     * Выдает награду игроку в виде эффекта зелья.
     *
     * @param player игрок, которому выдается награда
     */
    @Override
    public void giveReward(Player player) {
        player.addPotionEffect(effect);
        player.sendMessage(ChatColor.GOLD + "Вы получили эффект зелья: " + effect.getType().getName().toLowerCase());
    }

}
