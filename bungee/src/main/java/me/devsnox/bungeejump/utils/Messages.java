/*
 * Copyright (C) 2018 Yasin Dalal (DevSnox)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.devsnox.bungeejump.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yasin Dalal (DevSnox)
 * Created by Yasin Dalal (DevSnox) on 02.09.2018 23:37.
 */
public enum  Messages {

    PREFIX,
    NO_PERMISSIONS,
    NO_JOIN_PERMISSIONS,
    SERVER_MESSAGE,
    WARPED_TO_SERVER,
    LIST_OF_SERVERS,
    CONSOLE_MESSAGE,
    SERVER_NOT_EXISTS,
    ALREADY_CONNECTED;

    private final Map<Messages, Message> messages;

    Messages() {
        this.messages = new HashMap<>();
    }

    public Message get() {
        return this.messages.get(this);
    }

    public void set(String message) {
        this.messages.put(this, new Message(message));
    }

    public String formatedName() {
        return this.name().toLowerCase().replaceAll("_", "-");
    }
}
