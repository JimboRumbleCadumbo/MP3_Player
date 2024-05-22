package code;

/**
 * Class for displaying the bar in the UI
 */

public class ProgressBar {
    public Bar bar = new Bar(800);

    /**
     * Updates the progress bar every frame
     *
     * @param playing the current music that is loaded
     */
    public void update(Music playing) {
        if (playing == null) {
            return;
        }
        bar.setMax(playing.clip.getFrameLength());
        bar.setCurr(playing.clip.getFramePosition());
    }
}
