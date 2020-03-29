package Plugins.hwsAPI.PluginsManageur;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Plugins.hwsAPI.DataMangeur.DataManageur;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		new DataManageur(p).getPlayerData();
	}
	
	@EventHandler
	public void onquit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		new DataManageur(p).setPlayerData();
	}
}
