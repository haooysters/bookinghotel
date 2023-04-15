package com.example.thuephongkhachsan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "AndroidExample";
    TextInputEditText edtTaiKhoan, edtMatKhau;
    TextInputLayout layoutTaiKhoan, layoutMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setIcon(R.mipmap.hotel);
        edtTaiKhoan = findViewById(R.id.edt_taikhoan);
        edtMatKhau = findViewById(R.id.edt_matkhau);
        layoutTaiKhoan = findViewById(R.id.layout_taikhoan);
        layoutMatKhau = findViewById(R.id.layout_matkhau);
    }

    public void KiemTraDangNhap(View view) {
        String strTaiKhoan, strMatKhau;
        strTaiKhoan = edtTaiKhoan.getText().toString().trim();
        if (strTaiKhoan.length() == 0) {
            layoutTaiKhoan.setError("Lỗi chưa nhập tài khoản!");
            edtTaiKhoan.requestFocus();
            return;
        } else
            layoutTaiKhoan.setError(null);
        strMatKhau = edtMatKhau.getText().toString().trim();
        if (strMatKhau.length() == 0) {
            layoutMatKhau.setError("Lỗi chưa nhập mật khẩu!");
            edtMatKhau.requestFocus();
            return;
        } else
            layoutMatKhau.setError(null);
        if (strTaiKhoan.equals("user") && strMatKhau.equals("123")) {
            layoutMatKhau.setError(null);
            Toast.makeText(this, "Đăng nhập thành công!",
                    Toast.LENGTH_LONG).show();
            finish();
            Intent intent = new Intent(this, ActivityCustomGridView.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Lỗi tài khoản hoặc mật khẩu không đúng!",
                    Toast.LENGTH_LONG).show();
            layoutMatKhau.setError("Lỗi tài khoản hoặc mật khẩu không đúng!");
        }
    }
}