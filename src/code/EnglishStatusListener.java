package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class EnglishStatusListener implements StatusListener{

	private static final transient Logger LOG = LoggerFactory.getLogger(EnglishStatusListener.class);
	
	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status status) {
		String tweetText = status.getText();
		if(isEnglish(tweetText)) {
			LOG.info(status.getText());
		}
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isEnglish(String tweetText) {
		for(int i = 0;i < tweetText.length();i++) {
			int c = tweetText.charAt(i);
			if(c > 127) {
				return false;
			}
		}
		return true;
	}

}
