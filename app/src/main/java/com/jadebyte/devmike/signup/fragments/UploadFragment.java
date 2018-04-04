package com.jadebyte.devmike.signup.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jadebyte.devmike.signup.R;

public class UploadFragment extends Fragment{


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedState){

        return inflater.inflate(R.layout.upload_layout, parent, false);
    }
}
