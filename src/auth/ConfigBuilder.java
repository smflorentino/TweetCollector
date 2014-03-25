package auth;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class ConfigBuilder {
	private static Configuration config;
	
	private static final String API_KEY = "YOUR API KEY HERE";
	private static final String API_SECRET = "YOUR API SECRET KEY HERE";
	private static final String ACCESS_TOKEN = "YOUR ACCESS TOKEN HERE";
	private static final String ACCESS_SECRET = "YOUR ACCESS TOKEN SECRET HERE";
	
	static {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(API_KEY);
		cb.setOAuthConsumerSecret(API_SECRET);
		cb.setOAuthAccessToken(ACCESS_TOKEN);
		cb.setOAuthAccessTokenSecret(ACCESS_SECRET);
		config = cb.build();
	}
	
	public static Configuration getConfig() {
		return config;
	}
}
