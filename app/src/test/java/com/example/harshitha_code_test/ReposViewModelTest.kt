package com.example.harshitha_code_test

// ReposViewModelTest.kt
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.harshitha_code_test.GitHubRepository
import com.example.harshitha_code_test.Repo
import com.example.harshitha_code_test.ReposViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import java.io.IOException

@ExperimentalCoroutinesApi
class ReposViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: GitHubRepository

    @Mock
    private lateinit var observer: Observer<List<Repo>>

    @Mock
    private lateinit var errorObserver: Observer<String?>

    private lateinit var viewModel: ReposViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ReposViewModel(repository)
        viewModel.repos.observeForever(observer)
        viewModel.error.observeForever(errorObserver)
    }

    @Test
    fun `fetchRepositories success`() = runTest {
        // Mock successful response
        val mockRepos = listOf(Repo(id = 1, name = "Repo1", language = "Kotlin"))
        `when`(repository.getRepos("google", 1)).thenReturn(mockRepos)

        // Call the ViewModel function
        viewModel.fetchRepositories("google", 1)

        // Verify the results
        verify(observer).onChanged(mockRepos)
        verify(errorObserver, never()).onChanged(any())
    }

    @Test
    fun `fetchRepositories network error`() = runTest {
        // Mock network error (IOException)
        `when`(repository.getRepos("google", 1)).thenThrow(IOException::class.java)

        // Call the ViewModel function
        viewModel.fetchRepositories("google", 1)

        // Verify error message
        verify(errorObserver).onChanged("Network error. Please try again.")
    }

    @Test
    fun `fetchRepositories API rate limit error`() = runTest {
        // Mock HTTP error (HttpException)
        `when`(repository.getRepos("google", 1)).thenThrow(HttpException::class.java)

        // Call the ViewModel function
        viewModel.fetchRepositories("google", 1)

        // Verify error message
        verify(errorObserver).onChanged("API rate limit exceeded or invalid request.")
    }
}
