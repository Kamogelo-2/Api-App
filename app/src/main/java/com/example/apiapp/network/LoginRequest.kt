package com.example.apiapp.network
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(val email: String,
                        val password: String
)

data class LoginResponse(
    val message: String,
    val userId: Int
)

data class Expense(
    val id: Int,
    val userId: Int,
    val amount: Double,
    val category: String,
    val description: String,
    val date: String
)

// --- 2. The API Interface ---

interface ApiService {

    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

    // We can use the same Expense class for POSTing (without the ID)
    @POST("expenses")
    suspend fun addExpense(@Body expense: Expense): Response<Expense>

    @GET("expenses/{userId}")
    suspend fun getExpenses(@Path("userId") userId: Int): Response<List<Expense>>

// TODO: Add @POST("register") endpoint)
}

