package com.example.everyday.Function.DangKy_DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.everyday.MainActivity;
import com.example.everyday.R;

import java.util.HashMap;
import java.util.Map;

public class DangNhapActivity extends AppCompatActivity {
    private EditText editEmailTk;
    private EditText editPasTk;
    private Button btnDangNhap;
    private TextView tvDangKi;
    String url="https://huuphuc2690.000webhostapp.com/FatSnasks/DangNhap.php";
    String str_email,str_password,checkEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        editEmailTk = (EditText) findViewById(R.id.editEmailTk);
        editPasTk = (EditText) findViewById(R.id.editPasTk);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmail =editEmailTk.getText().toString();
                if(!validateemail() | !validatepass() ){
                    return;
                }
                else{
                    postlogin();
                }
            }
        });
        tvDangKi = (TextView) findViewById(R.id.tvDangKi);

    }
    public boolean validateemail(){
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
    private void postlogin(){
        final ProgressDialog progressDialog = new ProgressDialog(DangNhapActivity.this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        str_email = editEmailTk.getText().toString().trim();
        str_password = editPasTk.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                if(response.equalsIgnoreCase("Đăng Nhập Thành Công")){

                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user",str_email);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "xảy ra lỗi!", Toast.LENGTH_SHORT).show();
            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("EmailKH",str_email);
                params.put("MatKhauKH",str_password);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
    private void remember(String strname, String strpass, boolean checked) {
        SharedPreferences preferences=getSharedPreferences("user_file",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        if(!checked){
            editor.clear();
        }else {
            editor.putString("gmail",strname);
            editor.putString("matkhau",strpass);
            editor.putBoolean("remember",checked);
        }
        editor.commit();
    }
    public boolean validatepass(){
        if(editPasTk.getText().toString().equals("")){
            editPasTk.setError("Nhập mật khẩu của bạn");
            return false;
        } else{
            editPasTk.setError(null);
            return true;
        }
    }
}