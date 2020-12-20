package wangjasonx.smpcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<>(); // List of commands in the plugin
    private SMPCore plugin = SMPCore.getInstance(); // Instance of the main class

    public CommandManager() {}

    // Sub Commands
    public String main = "smp";
    public String find = "find";

    public void setup() {
        plugin.getCommand(main).setExecutor(this);

        this.commands.add(new FindCommand());
        this.commands.add(new HelpCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use commands for this plugin!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase(main)) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please add arguments to your command. Type /smp help for info.");
                return true;
            }

            SubCommand target = this.get(args[0]);

            if(target == null) {
                player.sendMessage(ChatColor.RED + "Unknown command.");
                return true;
            }

            ArrayList<String> arguments = new ArrayList<>();

            arguments.addAll(Arrays.asList(args));
            arguments.remove(0);

            try {
                target.onCommand(player, args);
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "An error has occurred.");
                e.printStackTrace();
            }
        }

        return true;

    }

    private SubCommand get(String name) {
        Iterator<SubCommand> subcommands = this.commands.iterator();

        while (subcommands.hasNext()) {
            SubCommand sc = subcommands.next();

            if (sc.name().equalsIgnoreCase(name)) {
                return sc;
            }

            String[] aliases = sc.aliases();

            int length = aliases.length;

            for (int i = 0; i < length; i++) {
                if (name.equalsIgnoreCase(aliases[i])) {
                    return sc;
                }
            }

        }

        return null;
    }
}
