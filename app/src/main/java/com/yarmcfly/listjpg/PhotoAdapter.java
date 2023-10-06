// com.yarmcfly.listjpg/PhotoAdapter java class -->
package com.yarmcfly.listjpg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PhotoAdapter extends BaseAdapter {
    private final Context context;
    private final List<UnsplashPhoto> photos;

    public PhotoAdapter(Context context, List<UnsplashPhoto> photos) {
        this.context = context;
        this.photos = photos;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Object getItem(int position) {
        return photos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_photo, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.photo_image);
            viewHolder.altDescriptionTextView = convertView.findViewById(R.id.description);
            viewHolder.firstNameTextView = convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        UnsplashPhoto photo = photos.get(position);

        Glide.with(context)
                .load(photo.getUrls().getRegular())
                .into(viewHolder.imageView);

        String title = photo.getTitle();
        String name = photo.getUsername();

        viewHolder.altDescriptionTextView.setText("title: " + title);
        viewHolder.firstNameTextView.setText("username: " + name);

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView altDescriptionTextView;
        TextView firstNameTextView;
    }
}