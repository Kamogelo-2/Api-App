package com.example.apiapp.utils

import android.util.Log
import java.security.MessageDigest

object PasswordUtils {

    private const val TAG = "PasswordUtils"

    /**
     * Hashes a plain-text password using SHA-256.
     * @param password The plain-text password to hash.
     * @return A hexadecimal string representation of the hash.
     */
    fun hashPassword(password: String): String {
        Log.d(TAG, "Hashing password...")
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            val hashBytes = digest.digest(password.toByteArray(Charsets.UTF_8))
            // Convert byte array to a lowercase hexadecimal string
            val hexString = hashBytes.joinToString("") { "%02x".format(it) }
            Log.d(TAG, "Password hashed successfully.")
            return hexString
        } catch (e: Exception) {
            Log.e(TAG, "Error hashing password", e)
            throw RuntimeException("Could not hash password", e)
        }
    }

    /**
     * Verifies a plain-text password against a stored hash.
     * @param inputPassword The plain-text password from the user.
     * @param storedHash The SHA-256 hash retrieved from storage.
     * @return True if the passwords match, false otherwise.
     */
    fun verifyPassword(inputPassword: String, storedHash: String): Boolean {
        Log.d(TAG, "Verifying password...")
        val inputHash = hashPassword(inputPassword)
        val match = inputHash == storedHash
        Log.d(TAG, "Password verification result: $match")
        return match
    }}