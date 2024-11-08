package com.azhar.laundry.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.azhar.laundry.R;
import com.azhar.laundry.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Menggunakan layout activity_login.xml

        // Menghubungkan elemen UI ke Java code
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Menetapkan onClickListener pada tombol login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogin()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validasi email
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Masukkan email yang valid");
            return false;
        }

        // Validasi password: minimal 8 karakter, ada huruf besar, kecil, dan angka
        if (password.isEmpty() || password.length() < 8) {
            etPassword.setError("Password minimal 8 karakter");
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            etPassword.setError("Password harus mengandung huruf besar");
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            etPassword.setError("Password harus mengandung huruf kecil");
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            etPassword.setError("Password harus mengandung angka");
            return false;
        }

        return true; // Jika semua validasi berhasil, kembalikan true
    }
}
