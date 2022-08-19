package com.example.everyday.Function.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.everyday.Function.DangKy_DangNhap.MapActivity;
import com.example.everyday.R;


public class ProfileFragment extends Fragment {

    private LinearLayout llaFavourites;
    private LinearLayout llaMap;
    private LinearLayout llayVideo;
    private LinearLayout llaStatics;
    private LinearLayout llayImga;
    private LinearLayout llayDrafts;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llaFavourites = (LinearLayout) view.findViewById(R.id.lla_Favourites);
        llaMap = (LinearLayout) view.findViewById(R.id.lla_Map);
        llayVideo = (LinearLayout) view.findViewById(R.id.llay_Video);
        llayImga = (LinearLayout) view.findViewById(R.id.llay_Imga);
        llayDrafts = (LinearLayout) view.findViewById(R.id.llay_Drafts);
        ///
        llaMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), MapActivity.class);
                startActivity(i);


            }
        });
    }
}