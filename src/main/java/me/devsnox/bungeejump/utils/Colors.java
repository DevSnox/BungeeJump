package me.devsnox.bungeejump.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class Colors {

    public static TextComponent convertStringWithColors(String message) {
        TextComponent textComponent = new TextComponent();

        String[] edit = message.replaceAll("&", "&§").split("&");

        for(String session : edit) {
            TextComponent textComponent1 = new TextComponent(session.substring(2, session.length()));
            textComponent.setColor(ChatColor.getByChar(session.charAt(1)));
            textComponent.addExtra(textComponent1);
        }

        return textComponent;
    }
}
