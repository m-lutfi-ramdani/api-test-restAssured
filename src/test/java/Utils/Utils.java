package Utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {
	public static final Dotenv env = Dotenv.load();
	
	public static String env(String config) {
		config = env.get(config.replaceAll(" ", "_").toUpperCase());
		if (config == null) {
			System.out.println("Env Data is not found! Please check on your .env file.");
		}
		return config;
	}
}
