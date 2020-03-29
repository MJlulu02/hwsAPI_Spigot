package Plugins.hwsAPI.PluginsManageur;

import java.util.HashMap;

import org.bukkit.entity.Player;

import Plugins.hwsAPI.Utils.HWSConfig;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class HWSAPI {
	public HWSConfig hwsConfig = Main.instance.hwsConfig;
	private HashMap<Player, PlayerAPI> HashPlayer = Main.instance.HashPlayer;
	
	public PlayerAPI getPlayerAPI(Player p) {
		if(this.HashPlayer.containsKey(p)) {
			return this.HashPlayer.get(p);
		}else {
			return new PlayerAPI();
		}
	}
	public void setPlayerAPI(Player p, PlayerAPI playerAPI) {
		if(this.HashPlayer.containsKey(p)) {
			this.HashPlayer.replace(p, playerAPI);
		}else {
			this.HashPlayer.put(p, playerAPI);
		}
	}
	public void removePlayerAPI(Player p) {
		if(this.HashPlayer.containsKey(p))
			this.HashPlayer.remove(p);
	}
}
