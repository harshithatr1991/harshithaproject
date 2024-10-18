package com.example.harshitha_code_test

class GitHubRepository(private val api: GitHubApi) {
    suspend fun getRepos(user: String, page: Int): List<Repo>? {
        return try {
            val response = api.getUserRepos(user, page)
            if (response.isSuccessful) {
                response.body() // Assuming the response is a List<Repo>
            } else {
                null // Handle error case appropriately
            }
        } catch (e: Exception) {
            null // Handle exceptions appropriately
        }
    }
}

