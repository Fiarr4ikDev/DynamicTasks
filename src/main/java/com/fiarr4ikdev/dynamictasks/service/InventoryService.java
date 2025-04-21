package com.fiarr4ikdev.dynamictasks.service;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        ItemStack mainGlass = createItem(Material.BLACK_STAINED_GLASS_PANE, " ");
        ItemStack exitButton = createItem(Material.RED_STAINED_GLASS_PANE, "§4§lЗакрыть");
        ItemStack getAllItemsButton = createItem(Material.GREEN_STAINED_GLASS_PANE, "§2§lЗабрать всё", "§fПеремещает все предметы в ваш инвентарь");

        int[] mainGlassIndex = new int[] {27, 28, 29, 31, 33, 34, 35};
        for (Integer index : mainGlassIndex) {
            inventory.setItem(index, mainGlass);
        }
        inventory.setItem(30, exitButton);
        inventory.setItem(32, getAllItemsButton);
        return inventory;
    }

    private void setItemStackName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
    }

    private void setItemStackLore(ItemStack item, String... lore) {
        ItemMeta meta = item.getItemMeta();
        List<String> loreList = new ArrayList<>(Arrays.asList(lore));
        if (meta != null) {
            meta.setLore(loreList);
            item.setItemMeta(meta);
        }
    }

    private ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        setItemStackName(item, name);
        return item;
    }

    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        setItemStackName(item, name);
        setItemStackLore(item, lore);
        return item;
    }

}
