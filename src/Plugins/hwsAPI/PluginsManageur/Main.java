package Plugins.hwsAPI.PluginsManageur;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Plugins.hwsAPI.Commands.CommandCoins;
import Plugins.hwsAPI.Commands.CommandPixels;
import Plugins.hwsAPI.Commands.CommandRank;
import Plugins.hwsAPI.Utils.HWSConfig;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class Main extends JavaPlugin{

	public static Main instance;
	public HWSConfig hwsConfig;
	public HashMap<Player, PlayerAPI> HashPlayer = new HashMap<Player, PlayerAPI>();
	
	public void onEnable(){
		System.out.println("[HwsAPI_Spigot] Enabled");
		EventManager.registerEvents(this);
		
		this.instance = this;
		this.hwsConfig = new HWSConfig();
		
		//Test remove aprés !!
		this.hwsConfig.setRedis_ip("51.77.149.191");
		this.hwsConfig.setRedis_pass("b8tXJ/QyjSQInxPPTlPND5yOmaODjhJbnrD75F939Fe/xjPIcBzoA71yDPUgkxSyz/sSn8Wgln4ImDJA");
		this.hwsConfig.connect_redis();
		
		getCommand("coinsgive").setExecutor(new CommandCoins());
		getCommand("coinsremove").setExecutor(new CommandCoins());
		getCommand("pixelsgive").setExecutor(new CommandPixels());
		getCommand("pixelsremove").setExecutor(new CommandPixels());
		getCommand("setrank").setExecutor(new CommandRank());
		
	}
	
	public void onDisable(){
		System.out.println("[HwsAPI_Spigot] Disable");
	}
	
}

