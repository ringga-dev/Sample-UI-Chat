package com.example.samplechat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.Room
import com.example.samplechat.data.adapter.ChatAdapter
import com.example.samplechat.data.database.room.AppDatabase
import com.example.samplechat.data.database.room.Chat
import com.example.samplechat.databinding.FragmentChatBinding


class ChatFragment : Fragment() {
    /**
     * create object FragmentLoginBinding
     * */
    companion object {
        fun newInstance() = ChatFragment()
    }

    private lateinit var db: AppDatabase

    /**
     * variable set  FragmentLoginBinding
     * */
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    /**
     * create view and set layout
     * */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "ngga-chat"
        ).allowMainThreadQueries().build()

        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecler()
        viewChat()


        binding.btnSendMessage.setOnClickListener {
            val text = binding.inputText.text.toString()
            if (text.isNotEmpty()) {
                val data = Chat("1","1", text, "10:10", "me")
                buttonSend(data)
            }
            binding.inputText.text = null
        }
    }

    //reload data setelah mengirim data room database


    private fun buttonSend(data: Chat) {

        val userDao = db.chatDao()

        userDao.insert(data)
        viewChat()


    }




    private fun viewChat() {
        val userDao = db.chatDao()
        val users: List<Chat> = userDao.getChat()
        binding.rvChat.adapter?.let { adapter ->
            if (adapter is ChatAdapter) {
                adapter.setLagu(users)
            }
        }
        binding.inputText.text = null

    }


    private fun setupRecler() {
        binding.rvChat.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = ChatAdapter(mutableListOf(), requireContext())
        }
    }

}

