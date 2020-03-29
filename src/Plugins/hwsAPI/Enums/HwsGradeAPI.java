package Plugins.hwsAPI.Enums;

public enum HwsGradeAPI {
	Joueur(99), MiniVIP(11), VIP(10), VIPplus(9), Legend(8), 
	Guide(7), Modérateur(6), Staff(5), Constructeur(4), Développeur(3), Responsable(2), Administrateur(1);

	int power;
	HwsGradeAPI(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return this.power;
	}
	
}
