package com.example.harshitha_code_test
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface GitHubService {
        @GET("users/{username}/repos")
        Call<List<Repository>> getRepos(@Path("username") String username, @Query("page") int page);

}
