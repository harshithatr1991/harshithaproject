# Harshitha's GitHub Repository Viewer

A simple Android application that displays repositories for a specific GitHub user using Retrofit, ViewModel, LiveData, and RecyclerView.

## Features

- Fetches public repositories of a specified GitHub user.
- Displays repository names and descriptions in a RecyclerView.
- Uses `Retrofit` for network calls.
- Implements `ViewModel` and `LiveData` for better lifecycle management.
- Displays error messages when API calls fail.

## Project Structure

- **`MainActivity`**: The main activity that sets up the UI, handles the initialization of the ViewModel, and observes data changes.
- **`ReposViewModel`**: Manages the data for the UI and contains the business logic to fetch repositories from the API.
- **`GitHubRepository`**: Acts as a data layer that fetches repository data from GitHub's API.
- **`RepoAdapter`**: A RecyclerView adapter that binds the repository data to the views.
- **`RepoViewHolder`**: A view holder class inside `RepoAdapter` to manage individual repository views.
- **`GitHubApi`**: Retrofit interface for making API calls to GitHub.

## Getting Started

### Prerequisites

- Android Studio
- Kotlin
- GitHub Personal Access Token (optional, for accessing private repositories or avoiding rate limits)

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/your-repo-name.git
