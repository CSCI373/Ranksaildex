package edu.unca.csci373.Ranksaildex;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class RanksaildexCommandExecutor implements CommandExecutor {
    private final Ranksaildex plugin;

    /*
     * This command executor needs to know about its plugin from which it came from
     */
    public RanksaildexCommandExecutor(Ranksaildex plugin) {
        this.plugin = plugin;
    }

    /*
     * On command set the sample message
     */
  
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + command.getUsage());
			return false;
		} else if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED
					+ "you must be logged on to use these commands");
			return false;
		} else if (args[0].equalsIgnoreCase("on")
				&& sender.hasPermission("siege.on")) {
			Player fred = (Player) sender;
			plugin.setMetadata(fred, "siege", true, plugin);
			sender.sendMessage(ChatColor.RED + fred.getName()
					+ " prepare yourself for the zombie siege!");
			plugin.logger.info(fred.getName() + " has activated the zombie siege!");
			return true;
		} else if (args[0].equalsIgnoreCase("off")
				&& sender.hasPermission("siege.off")) {
			Player fred = (Player) sender;
			plugin.setMetadata(fred, "siege", false, plugin);
			sender.sendMessage(ChatColor.RED + fred.getName()
					+ " has driven the zombies away");
			plugin.logger.info(fred.getName() + " has driven the zombie away.");
			return true;
		} else if (args[0].equalsIgnoreCase("message")
				&& sender.hasPermission("siege.message")) {
			this.plugin.getConfig().set("sample.message",
					Joiner.on(' ').join(args));
			return true;

		} else {
			return false;
		}
	}

}
