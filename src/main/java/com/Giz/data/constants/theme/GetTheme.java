package com.Giz.data.constants.theme;

public class GetTheme {
	public static String[][] getTheme(String sc) {

		switch (sc) {
		case "1":
			return Wp1.wp1();
		case "2":
			return Wp2.wp2();
		case "3":
			return Wp3.wp1();
		case "4":
			return Wp4.wp1();
		}
		return null;
	}

}
