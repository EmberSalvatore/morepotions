package net.embersalvatore;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class DevUtility {

    public static void simpleChatMessage(Player player, String message){
        player.displayClientMessage(Component.literal(message), false);
    }

}
