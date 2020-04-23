package Plugins.hwsAPI.PluginsManageur;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Plugins.hwsAPI.DataMangeur.DataManageur;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onjoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if(Main.instance.config.getBoolean("Join-message") && Main.instance.config.contains("None")) {
			e.setJoinMessage(" ");
		}else {
			e.setJoinMessage("");
		}
		
		try {
			Thread.sleep(650);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		PlayerAPI playerAPI = new DataManageur(p).getPlayerData();
		if (playerAPI == null) {
			if(p != null && p.isOnline()) {
				p.kickPlayer("§4Une Erreur est survenue, Merci de contacté un Administrateur !");
			}
		}
			
	}

	@EventHandler
	public void onquit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		new DataManageur(p).setPlayerData();
	}
}
