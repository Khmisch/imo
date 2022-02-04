package com.example.imoaplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imoaplication.R
import com.example.imoaplication.adapter.ChatAdapter
import com.example.imoaplication.model.Chat
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView!!.adapter = adapter

    }

    private fun getAllChats():ArrayList<Chat> {
        val chats:ArrayList<Chat> = ArrayList<Chat>()
        chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", 1))
        chats.add(Chat(R.drawable.im_sample_007, "Begzodbek Kurbanov", 0))
        chats.add(Chat(R.drawable.im_sample_007, "Sherzodbek Kurbanov", 3))
        chats.add(Chat(R.drawable.im_sample_007, "Firdavs Kurbanov", 8))
        chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", 1))
        chats.add(Chat(R.drawable.im_sample_007, "Begzodbek Kurbanov", 0))
        chats.add(Chat(R.drawable.im_sample_007, "Sherzodbek Kurbanov", 3))
        chats.add(Chat(R.drawable.im_sample_007, "Firdavs Kurbanov", 8))
        chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", 1))
        chats.add(Chat(R.drawable.im_sample_007, "Begzodbek Kurbanov", 0))
        chats.add(Chat(R.drawable.im_sample_007, "Sherzodbek Kurbanov", 3))
        chats.add(Chat(R.drawable.im_sample_007, "Firdavs Kurbanov", 8))
       return chats
    }
}