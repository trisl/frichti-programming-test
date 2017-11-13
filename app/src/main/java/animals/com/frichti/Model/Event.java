package animals.com.frichti.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tristan on 13/11/2017.
 */

public class Event {
    @Expose
    private String title;
    @Expose
    private String image;
    @Expose
    private String address;
    @SerializedName("date_start")
    @Expose
    private String dateStart;
    @SerializedName("date_end")
    @Expose
    private String dateEnd;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }
}
