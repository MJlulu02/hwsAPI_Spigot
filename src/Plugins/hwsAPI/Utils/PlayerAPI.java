package Plugins.hwsAPI.Utils;

import java.util.ArrayList;
import java.util.HashMap;

import Plugins.hwsAPI.Enums.HwsGradeAPI;

public class PlayerAPI {
	private ArrayList<String> friends, partys;
	private HwsGradeAPI hwsgradeapi = HwsGradeAPI.Joueur;
	private double coins = 0;
	private int pixels = 0;
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

	public void setCoins(double coins) {
		this.coins = coins;
		this.coins = new utils().roundDouble(this.coins, 2);
	}

	public void addCoins(double coins) {
		this.coins = this.coins + coins;
		this.coins = new utils().roundDouble(this.coins, 2);
	}

	public void removeCoins(double coins) {
		this.coins = this.coins - coins;
		this.coins = new utils().roundDouble(this.coins, 2);
	}
	
	public int getPixels() {
		return pixels;
	}

	public void setPixels(int pixels) {
		this.pixels = pixels;
	}

	public void addPixels(int pixels) {
		this.pixels = this.pixels + pixels;
	}

	public void removePixels(int pixels) {
		this.pixels = this.pixels - pixels;
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
