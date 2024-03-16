package com.example.usersinfo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.usersinfo.databinding.UserItemBinding


class UserItemAdapter(val listener: Listener) :
    RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>() {
    val usersList = ArrayList<RandomUser>()

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserItemViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(usersList[position], listener)
    }

    fun addUser(user: RandomUser) {
        usersList.add(user)
        notifyDataSetChanged()
    }


    class UserItemViewHolder(item: View, context: Context) : RecyclerView.ViewHolder(item) {
        val binding = UserItemBinding.bind(item)
        val cont = context

        @SuppressLint("CheckResult")
        fun bind(user: RandomUser, listener: Listener) = with(binding) {
            textViewPhone.text = user.phone
            textViewAddress.text = user.address
            textViewName.text = user.name
            val glideUrl = GlideUrl(
                user.photo, LazyHeaders.Builder()
                    .build()
            )
            Glide.with(cont).load(glideUrl).into(imageView)

            itemView.setOnClickListener {
                listener.onClick(user)
            }
        }
    }

    interface Listener {
        fun onClick(user: RandomUser)
    }
}