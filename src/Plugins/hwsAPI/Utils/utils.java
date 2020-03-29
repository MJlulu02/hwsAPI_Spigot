package Plugins.hwsAPI.Utils;

public class utils {
	
	public double roundDouble(double defValue, int roude) {
		String s[] = (""+defValue).split(".");
		String ss = s[1].substring(roude);
		return Double.parseDouble(s[0]+"."+ss);
	}
}
