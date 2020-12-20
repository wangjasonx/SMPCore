package wangjasonx.smpcore;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class EventsClass implements Listener {

    public static HashMap<String, String> compassLocation = new HashMap<>(); // Public static HashMap for players


    @EventHandler
    public void directCompassOnPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Player target;

        if (compassLocation.containsKey(player.getDisplayName())) {
            target = Bukkit.getPlayerExact(compassLocation.get(player.getDisplayName()));

            if (target != null && FindCommand.hasCompass(player)) {
                player.setCompassTarget(target.getLocation());
            }
        }
    }

}
