package animals.com.frichti.Model;

/**
 * Created by Tristan on 13/11/2017.
 */

public class Event {
    private String title;
    private int pictureId;

    public Event() {
        title = "";
        pictureId = 0;
    }

    public Event(String title, int pictureId) {
        this.title = title;
        this.pictureId = pictureId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
