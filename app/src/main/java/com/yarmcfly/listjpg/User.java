// com.yarmcfly.listjpg/User java class -->
package com.yarmcfly.listjpg;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class User implements Parcelable {
    private String username;

    private String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    protected User(@NonNull Parcel in) {
        username = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @NonNull
        @Contract("_ -> new")
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @NonNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
    }
}