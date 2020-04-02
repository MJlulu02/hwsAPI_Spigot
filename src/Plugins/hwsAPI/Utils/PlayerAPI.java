package Plugins.hwsAPI.Utils;

import java.util.ArrayList;
import java.util.HashMap;

import Plugins.hwsAPI.Enums.HwsGradeAPI;

public class PlayerAPI {
	private ArrayList<String> friends, partys;
	private HwsGradeAPI hwsgradeapi = HwsGradeAPI.Joueur;
	private double coins = 0, pixels = 0;
	private HashMap<String, String> OtherData = new HashMap<String, String>();

	public HwsGradeAPI getGrade() {
		return hwsgradeapi;
	}

	public void setGrade(HwsGradeAPI hwsgradeapi) {
		this.hwsgradeapi = hwsgradeapi;
	}

	public double getCoins() {
		return coins;
	}

	public double setCoins(double coins) {
		this.coins = coins;
		this.coins = new utils().roundDouble(this.coins, 2);
		
		return this.getCoins();
	}

	public double addCoins(double coins) {
		this.coins = this.coins + coins;
		this.coins = new utils().roundDouble(this.coins, 2);
		
		return this.getCoins();
	}

	public double removeCoins(double coins) {
		this.coins = this.coins - coins;
		this.coins = new utils().roundDouble(this.coins, 2);
		
		return this.getCoins();
	}

	public double getPixels() {
		return pixels;
	}

	public double setPixels(double pixels) {
		this.pixels = pixels;
		this.pixels = new utils().roundDouble(this.pixels, 2);
		
		return this.getPixels();
	}

	public double addPixels(double pixels) {
		this.pixels = this.pixels + pixels;
		this.pixels = new utils().roundDouble(this.pixels, 2);
		
		return this.getPixels();
	}

	public double removePixels(double pixels) {
		this.pixels = this.pixels - pixels;
		this.pixels = new utils().roundDouble(this.pixels, 2);
		
		return this.getPixels();
	}

	public HashMap<String, String> getOtherData() {
		return OtherData;
	}

	public void addOtherData(String Key, Object value) {
		this.OtherData.put(Key, "" + value.toString());
	}

	public Object getOtherData(String Key) {
		if (!OtherData.containsKey(Key))
			return null;

		try {
			return Integer.parseInt(OtherData.get(Key));
		} catch (Exception e) {
			try {
				return Double.parseDouble(OtherData.get(Key));
			} catch (Exception e2) {
				return OtherData.get(Key);
			}
		}
	}

	public void setOtherData(HashMap<String, String> otherData) {
		OtherData = otherData;
	}
}
