package com.fiarr4ikdev.dynamictasks.service;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class InventoryService {

    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 27, "Inventory");
        for (int i = 0; i <= 11; i++) {
            Random r = new Random();
            int index = r.nextInt(inventory.getSize());
            inventory.setItem(index, new ItemStack(Material.STONE));
        }
        return inventory;
    }

}
