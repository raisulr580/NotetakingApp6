import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notetakingapp.LoginActivity;
import com.example.notetakingapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    // Firebase authentication instance
    private FirebaseAuth mAuth;

    // UI components
    private EditText emailEditText, passwordEditText;
    private Button registerButton;
    private TextView loginRedirectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI components using IDs
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        loginRedirectTextView = findViewById(R.id.loginRedirectTextView);
    }

    // Register user with email and password
    public void registerUser(View view) {
        // Get input values
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validate input fields
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Register user with Firebase Authentication
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registration success
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(RegistrationActivity.this, "Registration Successful! Welcome, " + user.getEmail(), Toast.LENGTH_SHORT).show();

                        // Redirect to MainActivity
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Close RegistrationActivity
                    } else {
                        // Registration failed
                        Toast.makeText(RegistrationActivity.this, "Registration Failed. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Redirect to LoginActivity if user already has an account
    public void redirectToLogin(View view) {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
