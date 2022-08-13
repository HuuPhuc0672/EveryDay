package com.example.everyday.Function.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.everyday.Adapte.Adapte_NguoiDung;
import com.example.everyday.Mode.NguoiDung;
import com.example.everyday.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DiscoverFragment extends Fragment {
    private RecyclerView lvNguoiDung;
    ArrayList<NguoiDung> dungArrayList;
    Adapte_NguoiDung adapte_nguoiDung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvNguoiDung = (RecyclerView) view.findViewById(R.id.lvNguoiDung);
        dungArrayList = new ArrayList<>();
        adapte_nguoiDung= new Adapte_NguoiDung(getActivity(),dungArrayList);
        lvNguoiDung.setHasFixedSize(true);
        lvNguoiDung.setLayoutManager(new GridLayoutManager(getActivity(),1));
        lvNguoiDung.setAdapter(adapte_nguoiDung);
        getSP("https://huuphuc2690.000webhostapp.com/AppTest/getData_NguoiDung.php");


    }
    void getSP(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                dungArrayList.add(new NguoiDung(
                                        object.getInt("MaND"),
                                        object.getString("HinhAnhNG"),
                                        object.getString("TenND"),
                                        object.getString("NoiDung"),
                                        object.getString("ThoiGian"),
                                        object.getString("NgayThang")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapte_nguoiDung.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}