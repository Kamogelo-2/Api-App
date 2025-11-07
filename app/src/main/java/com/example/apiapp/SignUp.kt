
package com.example.apiapp // Make sure this package name matches yours

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivitySignupBinding
import com.example.apiapp.utils.PasswordUtils
import com.example.apiapp.utils.SecureStorage

class SignUpActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "SignUpActivity"
    }

    private lateinit var binding: ActivitySignupBinding
    private lateinit var secureStorage: SecureStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: Activity started and view bound.")

        // Initialize our secure storage helper
        secureStorage = SecureStorage(this)

        binding.btnSignUp.setOnClickListener {
            Log.d(TAG, "Sign Up button clicked.")
            handleSignUp()
        }

        binding.tvSignIn.setOnClickListener {
            Log.d(TAG, "Sign In text clicked. Finishing activity.")
            // Finishes this activity and returns to LoginActivity
            finish()
        }

        binding.btnGoogleSignIn.setOnClickListener {
            Log.w(TAG, "Google Sign In clicked on Sign Up page. Instructing user to go back.")
            Toast.makeText(this, "Please use Google Sign-In from the Login page.", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Handles the new user registration flow.
     */
    private fun handleSignUp() {
        val name = binding.etSignUpName.text.toString().trim()
        val email = binding.etSignUpEmail.text.toString().trim()
        val password = binding.etSignUpPassword.text.toString()

        // --- 1. Basic Validation ---
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Log.w(TAG, "Sign up failed: One or more fields are empty.")
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.w(TAG, "Sign up failed: Invalid email format.")
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 8) {
            Log.w(TAG, "Sign up failed: Password is too short (less than 8 chars).")
            Toast.makeText(this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show()
            return
        }

        // --- 2. Check if user already exists ---
        if (secureStorage.getHashedPassword(email) != null) {
            Log.w(TAG, "Sign up failed: User already exists for email: $email")
            Toast.makeText(this, "An account with this email already exists", Toast.LENGTH_SHORT).show()
            return
        }

        // --- 3. Hash Password & Save User ---
        try {
            Log.d(TAG, "Hashing password for new user...")
            val hashedPassword = PasswordUtils.hashPassword(password)

            // Save the user to our secure storage
            secureStorage.saveUser(email, name, hashedPassword)

            Log.i(TAG, "Sign up successful for user: $email")
            Toast.makeText(this, "Account created successfully! Please log in.", Toast.LENGTH_LONG).show()

            // Send user back to login screen
            finish()

        } catch (e: Exception) {
            Log.e(TAG, "Sign up failed: Error during hashing or saving", e)
            Toast.makeText(this, "Could not create account. Please try again.", Toast.LENGTH_SHORT).show()
        }
    }
}