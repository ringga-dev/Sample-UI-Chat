package com.example.samplechat.data.adapter

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplechat.R
import com.example.samplechat.data.database.room.Chat
import com.example.samplechat.databinding.UiChatBinding

class ChatAdapter(
    /**
     * create variable
     */
    private var chat: MutableList<Chat>,
    private var context: Context,
) : RecyclerView.Adapter<ChatAdapter.PageHolder>() {

    /**
     * set layout by viewBinding
     */
    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = UiChatBinding.bind(view)

    }

    /**
     * set value to view by viewBinding
     */
    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        with(holder) {
            binding.message.text = chat[position].message
            binding.timeMessage.text = chat[position].time
            if (chat[position].stts_chat == "me"){
                binding.chatLayout.background = context.getDrawable(R.drawable.chat_me)
                binding.positionChat.gravity = Gravity.END
                binding.timeMessage.gravity= Gravity.END
            }
        }
    }

    /**
     * set data to class
     */
    fun setLagu(r: List<Chat>) {
        chat.clear()
        chat.addAll(r)
        notifyDataSetChanged()
    }


    /**
     * set layout by layoutInflater
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.ui_chat, parent, false)
        )
    }

    /**
     * set size of list
     */
    override fun getItemCount() = chat.size
}