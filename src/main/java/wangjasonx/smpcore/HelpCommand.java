package wangjasonx.smpcore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {

    private SMPCore plugin = SMPCore.getInstance();

    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage(ChatColor.GOLD + "Commands:");
        player.sendMessage(ChatColor.RED + "/smp help");
        player.sendMessage(ChatColor.RED + "/smp find <player>");
    }

    @Override
    public String name() {
        return "help";
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
