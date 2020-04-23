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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

		if(new HWSAPI().getPlayerAPI(p).getGrade().getPower() < 8 || p.isOp()) {
					
			if (args.length < 2) {
				p.sendMessage("§2La Commande est §7: §c/" + cmd.getName() + " <Pseudo> <Grade> ");
				return true;
			}

			Player pget = Bukkit.getPlayer(args[0]);
			PlayerAPI playerAPI = new HWSAPI().getPlayerAPI(pget);
			if (pget != null) {
				HwsGradeAPI pgrade = StringToHwsGradeApi(args[1]);
				if (pgrade != null) {
					playerAPI.setGrade(pgrade);
					new HWSAPI().setPlayerAPI(pget, playerAPI);
					
					p.sendMessage("§2Le Joueur §c" + args[0] + " §2à pour grade §c" + args[1]);
				} else {
					p.sendMessage("§c" + args[1] + " §4N'est pas un grade Valide !");
					p.sendMessage("§f------------------------------------");
					p.sendMessage("§2Liste des grades §7: §a"+(HwsGradeAPI.values()));
				}
			} else {
				p.sendMessage("§c" + args[0] + " §4n'est pas connecter !");
			}
		}else {
			p.sendMessage("§4Vous n'avez pas la permission d'utilisé cette commande !");
		}
		return true;
	}
		return false;
	}
	private HwsGradeAPI StringToHwsGradeApi(String s) {
		try {
			return HwsGradeAPI.valueOf(s);
		} catch (Exception e) {
			return null;
		}
	}

}