package com.example.everyday.Function.DangKy_DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.everyday.R;

import java.util.HashMap;
import java.util.Map;

public class DangKyActivity extends AppCompatActivity {
    private TextView tvSignIn;
    private EditText editTenTK,editPasTk,editEmailTk;
    private Button btnDangKy;
    String url="https://huuphuc2690.000webhostapp.com/FatSnasks/DangKTKhoan.php";
    String checkEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        tvSignIn = (TextView) findViewById(R.id.tvSignIn);
        editTenTK = (EditText) findViewById(R.id.editTenTK);
        editEmailTk = (EditText) findViewById(R.id.editEmailTk);
        editPasTk = (EditText) findViewById(R.id.editPasTk);
        btnDangKy = (Button) findViewById(R.id.btnDangKy);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmail=editEmailTk.getText().toString();
                if (! valTaiKhoan()|!valEmail()|!valPass()){
                    return;
                }else {
                    Danhky();
                }

            }
        });
    }
    private void Danhky(){
        final ProgressDialog progressDialog = new ProgressDialog(DangKyActivity.this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        String str_name = editTenTK.getText().toString().trim();
        String str_email = editEmailTk.getText().toString().trim();
        String str_password = editPasTk.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                if(response.equalsIgnoreCase("Đăng kí Thành Công")){
                    editTenTK.setText("");
                    editEmailTk.setText("");
                    editPasTk.setText("");
                    Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplication(), "xảy ra lỗi!", Toast.LENGTH_SHORT).show();
            }}) {@Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> params = new HashMap<String, String>();
            params.put("TenKh",str_name);
            params.put("EmailKH",str_email);
            params.put("MatKhauKH",str_password);
            return params;

        }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplication());
        requestQueue.add(request);


    }

    public  boolean valTaiKhoan(){
        if(editTenTK.getText().toString().equals("")){
            editTenTK.setError("Hãy nhập tên của bạn.");
            return false;
        } else{
            editTenTK.setError(null);
            return true;
        }

    }
    public  boolean valEmail(){
        String a="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(editEmailTk.getText().toString().equals("")){
            editEmailTk.setError("Hãy nhập gmail của bạn.");
            return false;
        }else if(!checkEmail.matches(a)) {
            editEmailTk.setError("Nhập đúng định dạng gmail.");
            return false;
        }else{
            editEmailTk.setError(null);
            return true;
        }
    }
    public  boolean valPass(){
        if(editPasTk.getText().toString().equals("")){
            editPasTk.setError("Nhập mật khẩu của bạn");
            return false;
        }else if(editPasTk.length()<6) {
            editPasTk.setError("Nhập mật khẩu trên 6 kí tự.");
            return false;
        }
        else{
            editPasTk.setError(null);
            return true;
        }
    }
}