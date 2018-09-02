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

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * @author Yasin Dalal (DevSnox)
 * Created by Yasin Dalal (DevSnox) on 02.05.2018 00:00.
 */
public final class Colors {

    // TODO: 03.09.2018 Better method (Update code)! 
    public static TextComponent convertStringWithColors(final String message) {
        final TextComponent textComponent = new TextComponent();
        final String[] edit = message.replaceAll("&", "&§").split("&");

        for (final String session : edit) {
            final TextComponent textComponent1 = new TextComponent(session.substring(2, session.length()));
            textComponent.setColor(ChatColor.getByChar(session.charAt(1)));
            textComponent.addExtra(textComponent1);
        }

        return textComponent;
    }
}
