package tech.zmario.enhancedtnttag.api.manager.interfaces;

import org.bukkit.command.CommandSender;

public interface SubCommand {

    void execute(CommandSender sender, String[] args);

    String getPermission();

    boolean useConsole();
}
