package animals.com.frichti.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import animals.com.frichti.Model.Event;
import animals.com.frichti.R;
import animals.com.frichti.Tools.EventsAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEvents();
    }

    private void addEvents() {
        List<Event> events = new ArrayList<>();

        //int pictureId = getResources().getIdentifier("ic_information_event_bg", "drawable", getPackageName());
        for (int index = 0; index < 10; ++index) {
            Event event = new Event();

            event.setTitle("Paris event " + index);
            //event.setPictureId(pictureId);

            events.add(event);
        }

        RecyclerView listEvents = (RecyclerView) findViewById(R.id.recycler_view_paris_events);

        listEvents.setHasFixedSize(false);
        listEvents.setAdapter(new EventsAdapter(this, events));
        listEvents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
