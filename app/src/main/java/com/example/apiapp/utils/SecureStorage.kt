package com.example.apiapp.utils

import android.content.Context
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class SecureStorage(context: Context) {

    private companion object {
        const val TAG = "SecureStorage"
        const val FILE_NAME = "user_secure_prefs"
        const val KEY_NAME_PREFIX = "user_name_"
        const val KEY_PASSWORD_PREFIX = "user_pass_"
    }

    // 1. Create or retrieve the master key for encryption
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    // 2. Initialize EncryptedSharedPreferences
    private val sharedPreferences = EncryptedSharedPreferences.create(
        FILE_NAME,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Saves a user's details. Stores the name and the HASHED password.
     * @param email The user's email (used as the key).
     * @param name The user's name.
     * @param hashedPassword The SHA-256 hashed password.
     */
    fun saveUser(email: String, name: String, hashedPassword: String) {
        Log.d(TAG, "Saving user details for: $email")
        try {
            with(sharedPreferences.edit()) {
                // We use the email as part of the key
                putString("$KEY_NAME_PREFIX$email", name)
                putString("$KEY_PASSWORD_PREFIX$email", hashedPassword)
                apply()
            }
            Log.d(TAG, "User saved successfully.")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save user", e)
        }
    }

    /**
     * Retrieves the stored HASHED password for a given email.
     * @param email The email to look up.
     * @return The stored hashed password, or null if the user is not found.
     */
    fun getHashedPassword(email: String): String? {
        Log.d(TAG, "Retrieving stored hash for: $email")
        val hash = sharedPreferences.getString("$KEY_PASSWORD_PREFIX$email", null)
        if (hash == null) {
            Log.w(TAG, "No user found with email: $email")
        }
        return hash
    }}