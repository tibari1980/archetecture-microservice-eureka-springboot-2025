package com.atos.cutomerservice.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UtilsApp {

	// Méthode statique pour obtenir la date et l'heure formatée
	public static String nowFormatted() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())
				.format(Instant.now());
	}

}
