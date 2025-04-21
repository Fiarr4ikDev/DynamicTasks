package com.fiarr4ikdev.dynamictasks.service;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class InventoryService {

    private final ConfigService configService;

    public InventoryService(ConfigService configService) {
        this.configService = configService;
    }

    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 36, configService.getConfig().getString("crate.inventory_name"));
        for (int i = 0; i <= 34; i++) {
            Random r = new Random();
            int index = r.nextInt(inventory.getSize() - 9);
            inventory.setItem(index, new ItemStack(Material.STONE));
        }

        ItemStack mainGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        setItemStackName(mainGlass, " ");

        ItemStack exitButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        setItemStackName(exitButton, "§4§lЗакрыть");

        ItemStack getAllItemsButton = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        setItemStackName(getAllItemsButton, "§2§lЗабрать всё");



        int[] mainGlassIndex = new int[] {27, 28, 29, 31, 33, 34, 35};
        for (Integer index : mainGlassIndex) {
            inventory.setItem(index, mainGlass);
        }
        inventory.setItem(30, exitButton);
        inventory.setItem(32, getAllItemsButton);
        return inventory;
    }

    public void setItemStackName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
    }

}
