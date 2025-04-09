package com.fiarr4ikdev.dynamictasks.command;

import com.fiarr4ikdev.dynamictasks.reward.ItemRewardImpl;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GiveRewardCommand implements CommandExecutor {

    private final ItemRewardImpl itemReward;

    public GiveRewardCommand(ItemRewardImpl itemReward) {
        this.itemReward = itemReward;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.DIAMOND_SWORD));

        itemReward.giveReward(player, items);
        return true;
    }
}
