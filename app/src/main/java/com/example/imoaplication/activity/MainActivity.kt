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
import com.example.imoaplication.fragment.ChatsFragment
import com.example.imoaplication.fragment.ContactListFragment
import com.example.imoaplication.model.Chat
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: CustomAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        viewPager = findViewById(R.id.viewpager)
        // setting up the adapter
        viewPagerAdapter = CustomAdapter(supportFragmentManager)
        viewPagerAdapter.add(ChatsFragment(),"Chats")
        viewPagerAdapter.add(ContactListFragment(),"Contacts")

//        viewPagerAdapter!!.add(ContactListFragment())
        // Set the adapter
        viewPager!!.setAdapter(viewPagerAdapter)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout!!.setupWithViewPager(viewPager)
        imageView = findViewById(R.id.iv_plus)
        imageView.setOnClickListener {
            callDarkModeActivity()
        }

    }

    private fun callDarkModeActivity() {
        val intent = Intent(this, MainActivityDark::class.java)
        startActivity(intent)
    }

}