package com.fiarr4ikdev.dynamictasks.service;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Класс сервис для работы с чатом.
 */
public class ChatService {

    public ChatService() {

    }

    /**
     * Метод, который преобразует hex коды текста в цветной текст.
     * @param from текст который надо преобразовать
     */
    public String color(String from) {
        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        for (Matcher matcher = pattern.matcher(from); matcher.find(); matcher = pattern.matcher(from)) {
            String hexCode = from.substring(matcher.start(), matcher.end());
            String replaceSharp = hexCode.replace('#', 'x');
            char[] ch = replaceSharp.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : ch) {
                builder.append("&").append(c);
            }
            from = from.replace(hexCode, builder.toString());
        }

        return ChatColor.translateAlternateColorCodes('&', from);
    }

    /**
     * Метод для отправки в чат игроку hex сообщения.
     * @param p игрок, которому надо отправить сообщение
     * @param msg сообщение, которое будет отправлено игроку
     */
    public void sendMessage(Player p, String msg) {
        p.sendMessage(color(msg));
    }

}
