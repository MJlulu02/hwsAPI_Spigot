package Plugins.hwsAPI.Enums;

public enum HwsGradeAPI {
	Joueur(99), MiniVIP(14), VIP(13), VIPplus(12), Legend(11), Fabuleux(10), Ami(9), YouTuber(8),
	Guide(7), Mod�rateur(6), Staff(5), Constructeur(4), D�veloppeur(3), Responsable(2), Administrateur(1);

	int power;
	HwsGradeAPI(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return this.power;
	}
	
}
