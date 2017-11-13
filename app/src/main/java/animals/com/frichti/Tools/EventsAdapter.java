package animals.com.frichti.Tools;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import animals.com.frichti.Model.Event;
import animals.com.frichti.R;

/**
 * Created by Tristan on 13/11/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {
    private Context context;
    private List<Event> events;

    public EventsAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        return new EventViewHolder(inflater.inflate(R.layout.event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = events.get(position);

        holder.picture.setBackgroundResource(event.getPictureId());
        holder.title.setText(event.getTitle());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;

        public EventViewHolder(View itemView) {
            super(itemView);

            picture = (ImageView) itemView.findViewById(R.id.picture);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void addEvent(Event event, int position) {
        events.add(event);
        notifyItemInserted(position);
    }
}
