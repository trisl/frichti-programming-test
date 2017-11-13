package animals.com.frichti.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by Tristan on 13/11/2017.
 */

public class Record {
    @Expose
    private Event fields;

    public Event getFields() {
        return fields;
    }

    public void setFields(Event fields) {
        this.fields = fields;
    }
}
