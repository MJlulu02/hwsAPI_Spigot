package Plugins.hwsAPI.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Plugins.hwsAPI.PluginsManageur.HWSAPI;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class CommandCoins implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length < 2) {
				player.sendMessage("§2La Commande est §7: §c/"+cmd.getName()+" <Pseudo> <Montant> ");
				return true;
			}

			Player pget = Bukkit.getPlayer(args[0]);
			PlayerAPI playerAPI = new HWSAPI().getPlayerAPI(pget);
			if (pget != null) {
				double pcoins = StringToDouble(args[1]);
				if (pcoins != -1) {
					boolean b = cmd.getName().equalsIgnoreCase("coinsgive");
					double coins = b ? playerAPI.addCoins(pcoins) : playerAPI.removeCoins(pcoins);
					new HWSAPI().setPlayerAPI(pget, playerAPI);

					player.sendMessage("§2Le solde de §c" + args[0] + " §2est de §c" + coins);
					pget.sendMessage("§4Vous avez "+(b ? "reçu" : "perdu")+" §c" + args[1] + " Coins§7, §4Votre solde est de §c" + coins);
				} else {
					player.sendMessage("§c " + args[1] + " §4N'est pas Valide !");
				}
			} else {
				player.sendMessage("§c " + args[0] + " §4n'est pas connecter !");
			}
		}
		return true;
	}

	private double StringToDouble(String s) {
		try {
			double d = Double.parseDouble(s);
			return d;
		} catch (Exception e) {
			return -1;
		}
	}

}