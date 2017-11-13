package animals.com.frichti.Model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Tristan on 13/11/2017.
 */

public class JSONResponse {
    @Expose
    private List<Record> records;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
