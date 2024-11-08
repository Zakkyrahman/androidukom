package com.azhar.laundry.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.azhar.laundry.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Menggunakan layout activity_register.xml

        // Menemukan tombol Register berdasarkan ID
        Button btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);

        // Menemukan EditText berdasarkan ID
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnRegisterSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari input
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String address = etAddress.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                // Validasi input
                if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
                    etName.setError("Nama hanya boleh huruf");
                    return;
                }

                if (phone.isEmpty() || !phone.matches("[0-9]+")) {
                    etPhone.setError("Nomor telepon hanya boleh angka");
                    return;
                }

                if (address.isEmpty()) {
                    etAddress.setError("Alamat tidak boleh kosong");
                    return;
                }

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Email tidak valid");
                    return;
                }

                if (password.isEmpty() || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*")) {
                    etPassword.setError("Password minimal 8 karakter dan mengandung huruf besar, huruf kecil, dan angka");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    etConfirmPassword.setError("Konfirmasi password tidak sesuai");
                    return;
                }

                // Jika semua validasi berhasil, lanjut ke LoginActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
