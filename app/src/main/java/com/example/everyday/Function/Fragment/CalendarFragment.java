package com.example.everyday.Function.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.everyday.R;


public class CalendarFragment extends Fragment {
    private EditText etxtTimkiem;
    private CalendarView CaleDate;
    private ListView liVDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etxtTimkiem = (EditText) view.findViewById(R.id.etxt_timkiem);
        CaleDate = (CalendarView) view.findViewById(R.id.Cale_Date);
        /*liVDate = (ListView) view.findViewById(R.id.liV_Date);*/
        // Ngày
        CaleDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

            }
        });

    }
}