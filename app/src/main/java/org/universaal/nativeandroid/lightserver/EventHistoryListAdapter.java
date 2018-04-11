package org.universaal.nativeandroid.lightserver;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.universaal.nativeandroid.lightserver.organizer.UserEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventHistoryListAdapter extends RecyclerView.Adapter<EventHistoryListAdapter.ViewHolder> {

    private static LayoutInflater inflater = null;
    private Context context;
    List<UserEvent> events;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_text)
        TextView itemText;
        @BindView(R.id.textViewDate)
        TextView dateText;
        @BindView(R.id.root)
        ConstraintLayout root;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public EventHistoryListAdapter(Context context, List<UserEvent> events) {
        this.context = context;
        if (context != null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.events = events;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view;
        view = inflater.inflate(R.layout.row_item_history, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String event = events.get(position).getEvent();
        holder.itemText.setText(event);

        String time=events.get(position).getTime();
        holder.dateText.setText(time);
    }


    @Override
    public int getItemCount() {
        if (events != null)
            return events.size();
        return 0;
    }


}
