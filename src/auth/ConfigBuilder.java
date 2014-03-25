package auth;

import twitter4j.conf.ConfigurationBuilder;

public class ConfigBuilder {
	private ConfigurationBuilder _cb;
	
	private static final String API_KEY = "YOUR API KEY HERE";
	private static final String API_SECRET = "YOUR API SECRET KEY HERE";
	private static final String ACCESS_TOKEN = "YOUR ACCESS TOKEN HERE";
	private static final String ACCESS_SECRET = "YOUR ACCESS TOKEN SECRET HERE";
	
	private static ConfigBuilder SINGLETON;
	
	private ConfigBuilder() {
		_cb = new ConfigurationBuilder();
		_cb.setDebugEnabled(true);
		_cb.setOAuthConsumerKey(API_KEY);
		_cb.setOAuthConsumerSecret(API_SECRET);
		_cb.setOAuthAccessToken(ACCESS_TOKEN);
		_cb.setOAuthAccessTokenSecret(ACCESS_SECRET);
	}
	
	public static ConfigBuilder getInstance()
	{
		if(SINGLETON != null) {
			return SINGLETON;
		}
		SINGLETON = new ConfigBuilder();
		return SINGLETON;
	}
	
	public ConfigurationBuilder getConfig() {
		return _cb;
	}
}
