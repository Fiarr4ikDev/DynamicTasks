package com.fiarr4ikdev.dynamictasks.reward;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PotionEffectRewardImpl implements IReward {

    private final PotionEffect effect;

    public PotionEffectRewardImpl(PotionEffect effect) {
        this.effect = effect;
    }

    @Override
    public void giveReward(Player player) {
        player.addPotionEffect(effect);
        player.sendMessage("Вы получили эффект зелья: " + effect.getType().getName());
    }
}
