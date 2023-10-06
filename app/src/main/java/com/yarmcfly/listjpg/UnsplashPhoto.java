// com.yarmcfly.listjpg/UnsplashPhoto java class -->
package com.yarmcfly.listjpg;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class UnsplashPhoto implements Parcelable {
    public int name;
    private String id;
    public String alt_description;
    private User user;
    private Urls urls;

    public String getTitle() {
        return alt_description;
    }

    public User getUser() {
        return user;
    }

    public Urls getUrls() {
        return urls;
    }

    public String getUsername() {
        if (user != null) {
            return user.getUsername();
        } else {
            return "Unknown Author";
        }
    }
    protected UnsplashPhoto(@NonNull Parcel in) {
        id = in.readString();
        alt_description = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        urls = in.readParcelable(Urls.class.getClassLoader());
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(alt_description);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(urls, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UnsplashPhoto> CREATOR = new Creator<UnsplashPhoto>() {
        @NonNull
        @Contract("_ -> new")
        @Override
        public UnsplashPhoto createFromParcel(Parcel in) {
            return new UnsplashPhoto(in);
        }

        @NonNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public UnsplashPhoto[] newArray(int size) {
            return new UnsplashPhoto[size];
        }
    };
}