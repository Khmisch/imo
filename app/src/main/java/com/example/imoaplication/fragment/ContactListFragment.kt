package com.example.imoaplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imoaplication.R
import com.example.imoaplication.adapter.ContactListAdapter
import com.example.imoaplication.model.Chat
import com.example.imoaplication.model.Contacts
import java.util.ArrayList

class ContactListFragment: Fragment() {
    lateinit var nestedScrollView: NestedScrollView
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_contact_list, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        nestedScrollView = view.findViewById(R.id.nestedScrollView)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 1))
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Contacts>) {
        val adapter = ContactListAdapter(this, chats)
        recyclerView!!.adapter = adapter
        recyclerView.isNestedScrollingEnabled = false

    }

    private fun getAllChats(): ArrayList<Contacts> {
        val chats: ArrayList<Contacts> = ArrayList<Contacts>()
        for (i in 1..20) {
            if (i == 1 || i == 7|| i == 9) {
                chats.add(Contacts(R.drawable.im_sample_007, "Khurshidbek Kurbanov", true))
            }else if (i == 2 || i == 5|| i == 10) {
                chats.add(Contacts(R.drawable.im_person, "Sherzodbek Kurbanov",true ))
            }else if (i == 3 || i == 6|| i == 11) {
                chats.add(Contacts(R.drawable.im_person, "Begzoddbek Kurbanov",true))
            }else if (i == 4 || i == 8|| i == 12) {
                chats.add(Contacts(R.drawable.im_person, "Firdavs Kurbanov",true))
            } else {
                chats.add(Contacts(R.drawable.im_sample_007, "Khurshidbek Kurbanov", false))
            }
        }
        return chats
    }
}