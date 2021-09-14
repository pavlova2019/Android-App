package com.alexandrapavlova.mydumbapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.avatarImageView.setImageBitmap(userList[position].avatarUrl)
        holder.avatarImageView.setImageResource(R.mipmap.ic_launcher_round)
        holder.usernameTextView.text = userList[position].username
        holder.groupnameTextView.text = userList[position].groupname
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val avatarImageView   = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val usernameTextView  = itemView.findViewById<TextView>(R.id.usernameTextView)
        val groupnameTextView = itemView.findViewById<TextView>(R.id.groupnameTextView)
    }
}