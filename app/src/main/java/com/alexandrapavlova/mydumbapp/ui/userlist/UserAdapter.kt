package com.alexandrapavlova.mydumbapp.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.entity.User
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.avatarImageView)
            .load(userList[position].avatarUrl)
            .transform(CircleCrop())
            .into(holder.avatarImageView)
        holder.usernameTextView.text = userList[position].userName
        holder.groupnameTextView.text = userList[position].groupName
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val avatarImageView   = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val usernameTextView  = itemView.findViewById<TextView>(R.id.userNameTextView)
        val groupnameTextView = itemView.findViewById<TextView>(R.id.groupNameTextView)
    }
}