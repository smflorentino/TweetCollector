package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import auth.ConfigBuilder;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;

public class TweetCollector {
	
	private static final transient Logger LOG = LoggerFactory.getLogger(TweetCollector.class);
	
	public TweetCollector()
	{
		LOG.info("Creating Tweet Collector...");
	}
	
	public void CollectData()
	{
	    StatusListener listener = new StatusListener(){
			User user;
			String lang;
	        public void onStatus(Status status) {
	        	user = status.getUser();
	        	lang = user.getLang();
	        	//gather english only:
	        	//if(status.getUser().getLang().equals(ENGLISH)) {
	        	//	RollingDataFileAppender.writeEvent(UN_OPEN + status.getUser().getName() + UN_CLOSE + TT_OPEN + status.getText() + TT_CLOSE + DT_OPEN + status.getCreatedAt() + DT_CLOSE + RT_OPEN + status.getRetweetCount() + RT_CLOSE);
	        	//}
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				//  Auto-generated method stub
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				//  Auto-generated method stub	
			}
	    };
	    
        //get the configuration
	    TwitterStream twitterStream = new TwitterStreamFactory(ConfigBuilder.getInstance().getConfig().build()).getInstance();
	    
	    //pick our listener (raw or status)
	    twitterStream.addListener(listener);
	    
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    System.out.println("Beginning Tweet Dump");
	    twitterStream.sample();
	}
}
