package edu.unca.csci373.Ranksaildex;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

import edu.unca.csci373.Ranksaildex.Ranksaildex;

public class RanksaildexLogger {


	private final Ranksaildex plugin;
	private final Logger logger;

	public RanksaildexLogger(Ranksaildex plugin) {
		this.plugin = plugin;
		logger = Logger.getLogger("Minecraft");
	}

	private String buildMessage(String message) {
		PluginDescriptionFile yml = plugin.getDescription();
		String output = yml.getName() + yml.getVersion() + ": " + message;
		return output;
	}

	public void info(String msg) {
		logger.info(this.buildMessage(msg));
	}

	public void warn(String msg) {
		logger.warning(this.buildMessage(msg));
	}

}
