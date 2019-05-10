package me.devsnox.bungeejump.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class Message {

    private String value;

    public Message(String message) {
        this.value = message;
    }

    public Message replace(String placeholder, String value) {
        return new Message(this.value.replaceAll(placeholder, value));
    }

    public String asString() {
        return this.value;
    }

    public BaseComponent[] asComponent() {
        return TextComponent.fromLegacyText(this.value);
    }
}
