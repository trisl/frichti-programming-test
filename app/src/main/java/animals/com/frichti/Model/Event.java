package animals.com.frichti.Model;

/**
 * Created by Tristan on 13/11/2017.
 */

public class Event {
    private String title;
    private String image;

    public Event() {
        title = "";
        image = "";
    }

    public Event(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
