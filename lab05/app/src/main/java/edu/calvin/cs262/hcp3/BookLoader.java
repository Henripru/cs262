package edu.calvin.cs262.hcp3;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    public BookLoader(@NonNull Context context, String queryString) {
        super(context);
        mQueryString=queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}