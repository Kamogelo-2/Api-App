
package com.example.apiapp // Make sure this package name matches yours

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityLoginBinding
import com.example.apiapp.utils.PasswordUtils
import com.example.apiapp.utils.SecureStorage
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class LoginActivity : AppCompatActivity() {

    // A companion object for consistent logging
    private companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var secureStorage: SecureStorage
    private lateinit var googleSignInClient: GoogleSignInClient

    // New way to handle Activity results (for Google Sign-In)
    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "Google Sign-In result received.")
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleGoogleSignInResult(task)
        } else {
            Log.w(TAG, "Google Sign-In flow cancelled or failed.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: Activity started and view bound.")

        // Initialize our secure storage helper
        secureStorage = SecureStorage(this)

        // Configure Google Sign-In
        configureGoogleSignIn()

        // === Set up button click listeners ===

        binding.btnLogin.setOnClickListener {
            Log.d(TAG, "Login button clicked.")
            handleStandardLogin()
        }

        binding.tvSignUp.setOnClickListener {
            Log.d(TAG, "Sign Up text clicked. Navigating to SignUpActivity.")
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.btnGoogleSignIn.setOnClickListener {
            Log.d(TAG, "Google Sign In button clicked.")
            initiateGoogleSignIn()
        }
    }

    /**
     * Handles the standard email/password login flow.
     */
    private fun handleStandardLogin() {
        val email = binding.etLoginEmail.text.toString().trim()
        val password = binding.etLoginPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Log.w(TAG, "Login failed: Email or password empty.")
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        // 1. Retrieve the stored hash from secure storage
        val storedHash = secureStorage.getHashedPassword(email)
        if (storedHash == null) {
            Log.w(TAG, "Login failed: No user found for email: $email")
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            return
        }

        // 2. Verify the input password against the stored hash
        if (PasswordUtils.verifyPassword(password, storedHash)) {
            Log.i(TAG, "Login successful for user: $email")
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

            // --- THIS IS THE UPDATE ---
            // Navigate to the Dashboard and clear the back stack
            // so the user can't press "back" to return to the login screen.
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish() // Close the LoginActivity

        } else {
            // ...
        }
    }

    /**
     * Sets up the GoogleSignInClient with the required options.
     */
    private fun configureGoogleSignIn() {
        Log.d(TAG, "Configuring Google Sign-In...")

        // TODO: This is the MOST IMPORTANT step for SSO.
        // 1. Go to https://console.cloud.google.com/
        // 2. Create a new project.
        // 3. Go to "APIs & Services" -> "Credentials".
        // 4. Create an "OAuth 2.0 Client ID" for a "Web application".
        // 5. Use the "Web client ID" (NOT the "Client secret") here.
        // 6. You ALSO need to create an "Android" client ID and add your
        //    package name and SHA-1 certificate fingerprint to authorize your app.

        val webClientId = "YOUR_WEB_CLIENT_ID_FROM_GOOGLE_CONSOLE.apps.googleusercontent.com"

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webClientId) // Request the ID token
            .requestEmail()             // Request user's email
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    /**
     * Starts the Google Sign-In intent flow.
     */
    private fun initiateGoogleSignIn() {
        Log.d(TAG, "initiateGoogleSignIn: Launching Google SSO flow.")

        // This is the intent that launches the Google "Choose an account" UI
        val signInIntent = googleSignInClient.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

    /**
     * Handles the result returned from the Google Sign-In flow.
     */
    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            val email = account.email
            Log.i(TAG, "Google Sign-In successful. User: $email")
            Toast.makeText(this, "Google Sign-In Successful: $email", Toast.LENGTH_LONG).show()

            // TODO: Here you would either:
            // 1. Send the account.idToken to your backend server for verification.
            // 2. Or, if this is a local-only app, navigate to the main activity.
            // val intent = Intent(this, MainActivity::class.java)
            // ...
            // startActivity(intent)

        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            Log.e(TAG, "Google Sign-In failed with code: ${e.statusCode}", e)
            Toast.makeText(this, "Google Sign-In failed: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}