package wangjasonx.smpcore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class FindCommand extends SubCommand {

    private SMPCore plugin = SMPCore.getInstance();

    public static boolean hasCompass(Player player) {
        if (player.getInventory().contains(Material.COMPASS)) {
            return true;
        }
        return false;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        Inventory playerInventory = player.getInventory();
        ItemStack compass;
        Player target;

        if (args.length == 2) {

            target = Bukkit.getPlayerExact(args[1]);

            if (target == null) {
                 player.sendMessage(ChatColor.RED + args[1] + " not found.");
                return;
            }

            if (!playerInventory.contains(Material.COMPASS)) {

                compass = new ItemStack(Material.COMPASS);
                playerInventory.addItem(compass);
                player.sendMessage(ChatColor.GREEN + "No compass found, supplied with compass!");

            }

            EventsClass.compassLocation.put(player.getDisplayName(), target.getDisplayName());

            player.sendMessage(ChatColor.GREEN + "Compass now pointing towards " + target.getName());
        } else {
            player.sendMessage(ChatColor.RED + "Invalid entry, please try again: /smp find <playername>");
        }

    }

    @Override
    public String name() {
        return plugin.commandManager.find;
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
