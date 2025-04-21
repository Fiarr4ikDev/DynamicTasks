package com.fiarr4ikdev.dynamictasks.handler;

import com.fiarr4ikdev.dynamictasks.reward.CrateRewardImpl;
import com.fiarr4ikdev.dynamictasks.service.ConfigService;
import com.fiarr4ikdev.dynamictasks.service.InventoryService;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Обработчик событий для обработки событий с ящиком.
 */
public class CrateHandler implements Listener {

    private final CrateRewardImpl crateReward;
    private final InventoryService inventoryService;
    private final ConfigService configService;

    public CrateHandler(CrateRewardImpl crateReward, InventoryService inventoryService, ConfigService configService) {
        this.crateReward = crateReward;
        this.inventoryService = inventoryService;
        this.configService = configService;
    }

    /**
     * Отмена выкидывания предмета если он ящик с предметами.
     * @param event событие, которое вызывается при выбрасывании предмета
     */
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        ItemStack item = event.getItemDrop().getItemStack();
        if (checkCrate(item)) {
            event.setCancelled(true);
        }
    }

    /**
     * Проверка на то, что игрок нажимающий пкм с ящиком
     * имеет в руке действительно ящик с наградами.
     * @param event событие взаимодействия игрока с чем то
     */
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (checkCrate(itemInHand)) {
                Inventory inventory = inventoryService.getInventory();
                player.openInventory(inventory);
            }
        }

    }

    /**
     * Проверка на то, если игрок ставит бочку с наградами, то блок не ставится.
     * @param event события взаимодействия игрока с блоком.
     */
    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (checkCrate(itemInHand)) {
            event.setCancelled(true);
        }
    }

    /**
     * Тестовая проверка на выдачу ящика при заходе.
     * @param event событие, которое вызывается при заходе игрока на сервер
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("hi");
        crateReward.giveReward(player);
    }

    /**
     * Проверка на то, что предмет действительно ящик с предметами.
     * @param item предмет, который надо проверить
     * @return true если предмет подходит
     */
    private boolean checkCrate(ItemStack item) {
        List<String> lore = Objects.requireNonNull(item.getItemMeta()).getLore();
        if (lore.isEmpty()) {
            return false;
        } else {
            String crateSecret = lore.get(0);
            return item.getType() == Material.BARREL || crateSecret != null;
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(configService.getConfig().getString("crate.inventory_name"))) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
                player.closeInventory();
            }
            if (clickedItem != null && clickedItem.getType() == Material.GREEN_STAINED_GLASS_PANE) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                for (int i = 0; i < inventoryService.getInventory().getSize() - 9; i++) {
                    ItemStack itemInSlot = inventoryService.getInventory().getItem(i);
                    if (itemInSlot != null) {
                        List<ItemStack> items = new ArrayList<>();
                        items.add(itemInSlot);
                        for (ItemStack item : items) {
                            Map<Integer, ItemStack> remainingItems = player.getInventory().addItem(item);
                            if (!remainingItems.isEmpty()) {
                                remainingItems.values().forEach(remainingItem -> player.getWorld().dropItem(player.getLocation(), remainingItem));
                            }
                        }
                    }
                }
                itemInHand.setAmount(itemInHand.getAmount() - 1);
                player.closeInventory();
            }
        }
    }

}
