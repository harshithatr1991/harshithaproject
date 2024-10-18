package com.example.harshitha_code_test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ReposViewModel
    private lateinit var adapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView and Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = RepoAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create GitHubApi instance
        val api = retrofit.create(GitHubApi::class.java)

        // Initialize the repository
        val repository = GitHubRepository(api)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(ReposViewModel::class.java)

        // Observe the repositories
        viewModel.repos.observe(this) { repoList ->
            adapter.setRepos(repoList)
        }

        // Fetch repositories for a specific user
        viewModel.fetchRepositories("google")

        // Handle errors
        viewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}
