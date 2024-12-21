import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.example.yourapp.R; // Replace with your package name

class homeActivity : void AppCompatActivity() {

    private lateinit var java.lang.Object GoogleSignInClient;
    googleSignInClient: GoogleSignInClient;

    override fun java.lang.Object savedInstanceState;
    onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI Elements
        val tvWelcome: TextView = AppCompatActivity(R.id.tv_welcome);
        val tvUserInfo: TextView = AppCompatActivity(R.id.tv_user_info);
        val btnLogout: Button = AppCompatActivity(R.id.btn_logout);

        // Get data passed from LoginActivity
        val userName = intent.getStringExtra("USER_NAME");
        val userEmail = intent.getStringExtra("USER_EMAIL");

        // Display user info
        tvWelcome.text = "Welcome, $userName!";
        tvUserInfo.text = "Email: $userEmail";

        // Configure Google Sign-In
        googleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN);

        // Logout button click listener
        btnLogout.setOnClickListener {
            logout();
        };
    }

    private fun logout() {
        googleSignInClient.signOut().addOnCompleteListener {
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();

            // Redirect to LoginActivity
            val intent = Intent(this, LoginActivity::class.java);
            startActivity(intent);
            finish();
        };
    }
}

private void startActivity(val intent) {
}

private void finish() {
}

private void logout() {
}

private final java.lang.Object GoogleSignInClient;
private final java.lang.Object GoogleSignInClient;
private final java.lang.Object GoogleSignInClient;
private final java.lang.Object savedInstanceState;
