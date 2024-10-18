package com.example.harshitha_code_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    private var repos: List<Repo> = emptyList()

    // Method to update the list of repositories
    fun setRepos(newRepos: List<Repo>) {
        repos = newRepos
        notifyDataSetChanged() // Notify the adapter that data has changed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false)
        return RepoViewHolder(view)
    }


    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        // Bind the repo data to the view holder
        val repo = repos[position]
        holder.repoName.text = repo.name // Assuming the Repo class has a 'name' field
        holder.repoDescription.text = repo.description // Assuming the Repo class has a 'description' field
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize your view components here
        val repoName: TextView = itemView.findViewById(R.id.repoName)
        val repoDescription: TextView = itemView.findViewById(R.id.repoDescription)
    }
}
