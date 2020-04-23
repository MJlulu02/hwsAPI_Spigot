package Plugins.hwsAPI.PluginsManageur;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Plugins.hwsAPI.Commands.CommandCoins;
import Plugins.hwsAPI.Commands.CommandPixels;
import Plugins.hwsAPI.Commands.CommandRank;
import Plugins.hwsAPI.Utils.HWSConfig;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class Main extends JavaPlugin {

	public static Main instance;
	public HWSConfig hwsConfig;
	public HashMap<Player, PlayerAPI> HashPlayer = new HashMap<Player, PlayerAPI>();
	public FileConfiguration config;

	@SuppressWarnings("static-access")
	public void onEnable() {
		System.out.println("[HwsAPI_Spigot] Enabled");
		EventManager.registerEvents(this);

		this.instance = this;
		this.hwsConfig = new HWSConfig();
		saveDefaultConfig();
		
		// Test remove aprés !!
		System.out.println(hwsConfig);
		this.hwsConfig.setRedis_ip("51.77.149.191");
		this.hwsConfig.setRedis_pass("b8tXJ/QyjSQInxPPTlPND5yOmaODjhJbnrD75F939Fe/xjPIcBzoA71yDPUgkxSyz/sSn8Wgln4ImDJA");
		this.hwsConfig.connect_redis();

		getCommand("coinsgive").setExecutor(new CommandCoins());
		getCommand("coinsremove").setExecutor(new CommandCoins());
		getCommand("pixelsgive").setExecutor(new CommandPixels());
		getCommand("pixelsremove").setExecutor(new CommandPixels());
		getCommand("setrank").setExecutor(new CommandRank());
		
		config.addDefault("Join-message", "None");
		config.addDefault("Quit-message", "None");
		config.options().copyDefaults(true);
        saveConfig();
        
	}

	public void onDisable() {
		System.out.println("[HwsAPI_Spigot] Disable");
		saveConfig();
	}

	public void saveDefaultConfig() {
		if (!getDataFolder().exists())
			getDataFolder().mkdir();

		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			try (InputStream in = getResource("config.yml")) {
				Files.copy(in, file.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.config = YamlConfiguration.loadConfiguration(new File("plugins/HwsAPI_Spigot/config.yml"));
	}
}
