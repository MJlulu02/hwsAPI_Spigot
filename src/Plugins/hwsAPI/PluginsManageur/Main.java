package Plugins.hwsAPI.PluginsManageur;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
	}
	
	public void onDisable(){
		System.out.println("[HwsAPI_Spigot] Disable");
	}
	
}
