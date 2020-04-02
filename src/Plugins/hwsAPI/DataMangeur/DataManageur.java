package Plugins.hwsAPI.DataMangeur;

import java.util.HashMap;

import org.bukkit.entity.Player;

import Plugins.hwsAPI.Enums.HwsGradeAPI;
import Plugins.hwsAPI.PluginsManageur.HWSAPI;
import Plugins.hwsAPI.Utils.PlayerAPI;
import redis.clients.jedis.Jedis;

public class DataManageur {

	private Player p;
	private PlayerAPI playerAPI;
	private HashMap<String, String> HashData = new HashMap<String, String>();
	private Jedis jedis = new HWSAPI().hwsConfig.GetJedis();

	public DataManageur(Player p) {
		this.p = p;
		this.playerAPI = new HWSAPI().getPlayerAPI(this.p);
	}

	public PlayerAPI getPlayerData() {
		if(!this.jedis.exists("PlayerData:" + p.getName()))
			return null;
			
		this.HashData = (HashMap<String, String>) this.jedis.hgetAll("PlayerData:" + p.getName());

		if (this.HashData.containsKey("hwsgrade"))
			this.playerAPI.setGrade(HwsGradeAPI.valueOf(this.HashData.get("hwsgrade")));
		if(this.HashData.containsKey("hwscoins"))
			this.playerAPI.setCoins(Double.parseDouble(this.HashData.get("hwscoins")));
		if(this.HashData.containsKey("hwspixels"))
			this.playerAPI.setPixels(Double.parseDouble(this.HashData.get("hwspixels")));
		
		this.HashData.remove("hwsgrade");
		this.HashData.remove("hwscoins");
		this.HashData.remove("hwspixels");
		
		this.playerAPI.setOtherData(this.HashData);
		
		new HWSAPI().setPlayerAPI(p, playerAPI);
		
		return this.playerAPI;
	}
	
	public void setPlayerData() {
		if(this.playerAPI.getCoins() != 0)
			this.HashData.put("hwscoins", this.playerAPI.getCoins()+"");
		if(this.playerAPI.getPixels() != 0)
			this.HashData.put("hwspixels", this.playerAPI.getPixels()+"");
		if(this.playerAPI.getGrade() != HwsGradeAPI.Joueur)
			this.HashData.put("hwsgrade", this.playerAPI.getGrade().toString()+"");
		
		this.HashData.putAll(this.playerAPI.getOtherData());
		
		this.jedis.hmset("PlayerData:" + p.getName(), this.HashData);
		
		new HWSAPI().removePlayerAPI(p);
	}
}
