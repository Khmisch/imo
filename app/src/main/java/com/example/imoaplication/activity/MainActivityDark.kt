package com.example.imoaplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.imoaplication.R
import com.example.imoaplication.adapter.ChatAdapter
import com.example.imoaplication.adapter.ChatDarkModeAdapter
import com.example.imoaplication.adapter.CustomAdapter
import com.example.imoaplication.adapter.CustomAdapterDark
import com.example.imoaplication.fragment.ChatsFragment
import com.example.imoaplication.fragment.ChatsFragmentDark
import com.example.imoaplication.fragment.ContactListFragment
import com.example.imoaplication.fragment.ContactListFragmentDark
import com.example.imoaplication.model.Chat
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

class MainActivityDark : AppCompatActivity() {

    private lateinit var viewPagerAdapter: CustomAdapterDark
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dark)

        initViews()
    }

    private fun initViews() {

        viewPager = findViewById(R.id.viewpager_dark)
        // setting up the adapter
        viewPagerAdapter = CustomAdapterDark(supportFragmentManager)
        viewPagerAdapter.add(ChatsFragmentDark(), "Chats")
        viewPagerAdapter.add(ContactListFragmentDark(), "Contacts")

        viewPager!!.setAdapter(viewPagerAdapter)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout!!.setupWithViewPager(viewPager)
    }
}
