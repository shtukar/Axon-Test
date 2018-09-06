package ru.yandex.shtukarr.axontest.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.shtukarr.axontest.R;
import ru.yandex.shtukarr.axontest.model.ProfileModel;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {
    private List<ProfileModel> profileModelList;
    private MainScreen mainScreen;

    public EmployeeListAdapter(final MainScreen mainScreen) {
        profileModelList = new ArrayList<>();
        this.mainScreen = mainScreen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EmployeeListAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("onBindViewHolder", profileModelList.get(position).getAvatar());
        Picasso.get().load(profileModelList.get(position).getAvatar())
                .error(R.drawable.ic_error_outline_black_24dp)
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(holder.imageViewPhoto);
        holder.textViewFullName.setText(profileModelList.get(position).getFirstName() + " " +
                profileModelList.get(position).getSecondName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScreen.onItemSelected(profileModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }

    public void setList(List<ProfileModel> list) {
        this.profileModelList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageViewPhoto;
        TextView textViewFullName;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.photo_profile);
            textViewFullName = itemView.findViewById(R.id.full_name);
        }
    }


}
