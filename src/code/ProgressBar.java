package code;

public class ProgressBar {
	public Bar bar = new Bar(800);
	
	
	public void update(Music playing) {
		if(playing==null) {
			return;
		}
		bar.setMax(playing.clip.getFrameLength());
		bar.setCurr(playing.clip.getFramePosition());
	}
}
