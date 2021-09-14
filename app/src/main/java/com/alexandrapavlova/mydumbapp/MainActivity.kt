package com.alexandrapavlova.mydumbapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        adapter.userList = loadUsers()
        adapter.notifyDataSetChanged()
    }

    private fun loadUsers() : List<User> {
        return listOf(
            User(
                avatarUrl = "",
                username = "un1",
                groupname = "g1"
            ),
            User(
                avatarUrl = "",
                username = "un2",
                groupname = "g2"
            ),
            User(
                avatarUrl = "",
                username = "un3",
                groupname = "g2"
            ),
            User(
                avatarUrl = "",
                username = "un4",
                groupname = "g3"
            ),
            User(
                avatarUrl = "",
                username = "un5",
                groupname = "g3"
            ),
            User(
                avatarUrl = "",
                username = "un6",
                groupname = "g3"
            ),
            User(
                avatarUrl = "",
                username = "un7",
                groupname = "g4"
            ),
            User(
                avatarUrl = "",
                username = "un8",
                groupname = "g4"
            ),
            User(
                avatarUrl = "",
                username = "un9",
                groupname = "g4"
            ),
            User(
                avatarUrl = "",
                username = "un10",
                groupname = "g4"
            )
        )
    }

}