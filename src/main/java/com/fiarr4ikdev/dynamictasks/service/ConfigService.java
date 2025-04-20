package com.fiarr4ikdev.dynamictasks.service;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Класс для создания в серверной папке предустановленного конфига для работы плагина.
 */
public class ConfigService {

    private final FileConfiguration config;

    public ConfigService(JavaPlugin plugin) {
        File configFile = new File(plugin.getDataFolder(), "config/config.yaml");

        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();

                InputStream configStream = plugin.getResource("config/config.yaml");
                if (configStream != null) {
                    Files.copy(configStream, configFile.toPath());
                    plugin.getLogger().info("Файл config.yaml скопирован из ресурсов.");
                } else {
                    plugin.getLogger().warning("Не удалось найти config.yaml в ресурсах плагина.");
                }
            } catch (IOException e) {
                plugin.getLogger().severe("Ошибка при создании файла config.yaml: " + e.getMessage());
            }
        }

        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Метод, чтобы получить конфиг и вытянуть из него объект.
     * @return объект класса {@link FileConfiguration}
     */
    public FileConfiguration getConfig() {
        return config;
    }

}
