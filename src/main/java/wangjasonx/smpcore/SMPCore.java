package wangjasonx.smpcore;

import org.bukkit.plugin.java.JavaPlugin;

public final class SMPCore extends JavaPlugin {

    private static SMPCore instance;
    public CommandManager commandManager;

    @Override
    public void onEnable() {
        setInstance(this);
        System.out.println("SMPCore Enabled!");

        /*Creating the command manager instance and setting it up*/
        commandManager = new CommandManager();

        commandManager.setup();

        /*Setting up the events listener for the events class*/
        getServer().getPluginManager().registerEvents(new EventsClass(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("SMPCore Disabled!");
    }

    public static SMPCore getInstance() {
        return instance;
    }

    private static void setInstance(SMPCore instance) {
        SMPCore.instance = instance;
    }
}
