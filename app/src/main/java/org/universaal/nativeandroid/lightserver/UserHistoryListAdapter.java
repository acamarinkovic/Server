package org.universaal.nativeandroid.lightserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHistoryListAdapter extends RecyclerView.Adapter<UserHistoryListAdapter.ViewHolder> {
    private Context context;
    List<User> users;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.check_mark_image)
        ImageView checkMarkImage;
        @BindView(R.id.item_text)
        TextView itemText;
        @BindView(R.id.textViewAddress)
        TextView addressText;
        @BindView(R.id.root)
        ConstraintLayout root;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public UserHistoryListAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new EventClick(users.get(viewHolder.getAdapterPosition())));
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User user = users.get(position);
        /*try {
            byte[] decodedString = Base64.decode(user.getAvatar(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            holder.checkMarkImage.setImageBitmap(decodedByte);
        } catch (Exception e) {
        }*/
        holder.itemText.setText(user.getName());
        holder.checkMarkImage.setImageBitmap(user.getImage());
        holder.addressText.setText(user.getAddress());
    }


    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        return 0;
    }


}
