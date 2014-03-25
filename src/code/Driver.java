package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Driver {
	
	private static final transient Logger LOG = LoggerFactory.getLogger(Driver.class);
	
	public static void main(String[] args)
	{
		LOG.info("Hello, World");
		TweetCollector tCollector = new TweetCollector();
	}

}
