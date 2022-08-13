package com.example.everyday.Adapte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everyday.Mode.NguoiDung;
import com.example.everyday.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Adapte_NguoiDung extends RecyclerView.Adapter<Adapte_NguoiDung.NguoiDungHolder> {
    Context context;
    ArrayList<NguoiDung>  nguoiDungs;
    String urlND="https://huuphuc2690.000webhostapp.com/AppTest/getData_NguoiDung.php";
    public  Adapte_NguoiDung(Context context,ArrayList<NguoiDung> nguoiDungs){
        this.context=context;
        this.nguoiDungs=nguoiDungs;
    }



    @NonNull
    @Override
    public NguoiDungHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nguoidung , parent, false);
        return new Adapte_NguoiDung.NguoiDungHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiDungHolder holder, int position) {
        NguoiDung nguoiDung = nguoiDungs.get(position);

        holder.txtName.setText(nguoiDung.getTenND());
        holder.txtGioi.setText(nguoiDung.getThoiGian());
        holder.txtNoidung.setText(nguoiDung.getNoiDung());
        Picasso.get().load(nguoiDung.getHinhAnhNG())
                .into(holder.ImViAnhdd);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return nguoiDungs.size();
    }

    public class NguoiDungHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView txtNoidung;
        private TextView txtGioi;
        private TextView txtName;
        private ImageView ImViAnhdd;

        public NguoiDungHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            txtNoidung = (TextView) itemView.findViewById(R.id.txt_Noidung);
            txtGioi = (TextView) itemView.findViewById(R.id.txt_Gioi);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            ImViAnhdd = (ImageView) itemView.findViewById(R.id.ImVi_Anhdd);
        }
    }
}
