package animals.com.frichti.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by Tristan on 13/11/2017.
 */

public class Event {
    @Expose
    private String title;

    @Expose
    private String image;

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
