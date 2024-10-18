package com.example.harshitha_code_test
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 30 // Optional: specify the number of results per page
    ): Response<List<Repo>>
}



