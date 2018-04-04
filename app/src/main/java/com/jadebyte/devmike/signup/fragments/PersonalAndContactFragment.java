package com.jadebyte.devmike.signup.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jadebyte.devmike.signup.R;

/**
 * Created by DevMike on 3/16/2018.
 */

public class PersonalAndContactFragment extends Fragment {

    public static final String EXTRA_DATA =".EXTRA_DATA"; //Key for checking if its personal profile
    private Context context;
    private View view;

    public static PersonalAndContactFragment newInstance(boolean isPersonal){
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_DATA, isPersonal);
        PersonalAndContactFragment fragment = new PersonalAndContactFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context =context;

    }

    private boolean isPersonal() {
        boolean hasPersonal = getArguments().getBoolean(EXTRA_DATA, false);
        if (hasPersonal) {
            //Collect personal information
        } else {
            //Collect contact info
        }
        return hasPersonal;

    }
    private void showSnack(String msg, View v){
        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedState){
        //View view =null;
        if (getArguments() !=null) {
            if (isPersonal()) {
                //Personal layout
                view =inflater.inflate(R.layout.personal_layout, parent, false);
                EditText edNationality = view.findViewById(R.id.nationality_),
                        userTitle =view.findViewById(R.id.title_);
                edNationality.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show();
                    }
                });
                userTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show();                    }
                });
            } else {
                //Contacts layout
                view =inflater.inflate(R.layout.contact_layout, parent, false);
            }
        }
        return view;
    }
}
