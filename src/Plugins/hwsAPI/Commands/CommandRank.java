package Plugins.hwsAPI.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Plugins.hwsAPI.Enums.HwsGradeAPI;
import Plugins.hwsAPI.PluginsManageur.HWSAPI;
import Plugins.hwsAPI.Utils.PlayerAPI;

public class CommandRank implements CommandExecutor {

	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			// /setgrade BowEnder Administrateur

			if (args.length < 2) {
				player.sendMessage("§2La Commande est §7: §c/" + cmd.getName() + " <Pseudo> <Grade> ");
				return true;
			}

			Player pget = Bukkit.getPlayer(args[0]);
			PlayerAPI playerAPI = new HWSAPI().getPlayerAPI(pget);
			if (pget != null) {
				HwsGradeAPI pgrade = StringToHwsGradeApi(args[1].toUpperCase());
				if (pgrade != null) {
					playerAPI.setGrade(pgrade);
					new HWSAPI().setPlayerAPI(pget, playerAPI);
					
					player.sendMessage("§2Le Joueur §c" + args[0] + " à pour grade §c" + args[1]);
				} else {
					player.sendMessage("§c" + args[1] + " §4N'est pas un grade Valide !");
					player.sendMessage("§f------------------------------------");
					player.sendMessage("§2Liste des grades §7: §a"+(HwsGradeAPI.values().toString()).join(", "));
				}
			} else {
				player.sendMessage("§c" + args[0] + " §4n'est pas connecter !");
			}
		}
		return true;
	}

	private HwsGradeAPI StringToHwsGradeApi(String s) {
		try {
			return HwsGradeAPI.valueOf(s);
		} catch (Exception e) {
			return null;
		}
	}

}