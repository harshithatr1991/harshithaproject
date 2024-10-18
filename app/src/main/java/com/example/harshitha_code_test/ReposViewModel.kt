package com.example.harshitha_code_test

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ReposViewModel(private val repository: GitHubRepository) : ViewModel() {
    private val _repos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>> get() = _repos

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchRepositories(user: String, page: Int = 1) {
        viewModelScope.launch {
            try {
                // Fetch repositories from the repository
                val repoList = repository.getRepos(user, page)
                _repos.value = repoList
            } catch (e: IOException) {
                // Handle network errors
                _error.value = "Network error. Please check your connection."
            } catch (e: HttpException) {
                // Handle HTTP errors with more specific messages
                when (e.code()) {
                    403 -> _error.value = "Rate limit exceeded. Please try again later."
                    404 -> _error.value = "User not found. Please check the username."
                    else -> _error.value = "API error: ${e.message()}"
                }
            } catch (e: Exception) {
                // Handle any other unforeseen errors
                _error.value = "An unexpected error occurred: ${e.message}"
            }
        }
    }
}
