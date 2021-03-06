package tech.zmario.enhancedtnttag.commands.subcommands;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.zmario.enhancedtnttag.EnhancedTNTTag;
import tech.zmario.enhancedtnttag.api.manager.interfaces.SubCommand;
import tech.zmario.enhancedtnttag.enums.MessagesConfiguration;
import tech.zmario.enhancedtnttag.enums.SettingsConfiguration;

@RequiredArgsConstructor
public class BuildSubCommand implements SubCommand {

    private final EnhancedTNTTag plugin;

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (plugin.getLocalStorage().getBuildPlayers().remove(player.getUniqueId())) {
            MessagesConfiguration.SUBCOMMAND_BUILD_TOGGLED_OFF.send(player);
        } else {
            MessagesConfiguration.SUBCOMMAND_BUILD_TOGGLED_ON.send(player);
            plugin.getLocalStorage().getBuildPlayers().add(player.getUniqueId());
        }
    }

    @Override
    public String getPermission() {
        return SettingsConfiguration.COMMANDS_BUILD_PERMISSION.getString();
    }

    @Override
    public boolean useConsole() {
        return false;
    }
}
