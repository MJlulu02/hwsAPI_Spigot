package Plugins.hwsAPI.Utils;

import java.text.DecimalFormat;

public class utils {

	public double roundDouble(double defValue, int roude) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(defValue).replace(",", "."));
	}
}
