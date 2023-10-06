// com.yarmcfly.listjpg/Urls java class -->
package com.yarmcfly.listjpg;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class Urls implements Parcelable {
    private String regular;

    public Urls(String regular) {
        this.regular = regular;
    }

    protected Urls(@NonNull Parcel in) {
        regular = in.readString();
    }

    public static final Creator<Urls> CREATOR = new Creator<Urls>() {
        @NonNull
        @Contract("_ -> new")
        @Override
        public Urls createFromParcel(Parcel in) {
            return new Urls(in);
        }

        @NonNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public Urls[] newArray(int size) {
            return new Urls[size];
        }
    };

    public String getRegular() {
        return regular;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(regular);
    }
}