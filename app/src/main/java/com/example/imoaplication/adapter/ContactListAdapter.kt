package com.example.imoaplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imoaplication.R
import com.example.imoaplication.fragment.ChatsFragment
import com.example.imoaplication.fragment.ContactListFragment
import com.example.imoaplication.model.Chat
import com.example.imoaplication.model.Contacts
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class ContactListAdapter (var fragment: ContactListFragment, var items: ArrayList<Contacts>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Contacts = items[position]
        return if (!chat.added) {
            TYPE_ADDED_NO
        }
        else TYPE_ADDED_YES
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == TYPE_ADDED_YES) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_list_view, parent, false)
            return AddedViewHolderYes(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_list_view_invite, parent, false)
        return AddedViewHolderNo(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is AddedViewHolderYes){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(chat.profile)
            tv_fullname.text = chat.fullName
        }
       else  if (holder is AddedViewHolderNo){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(chat.profile)
            tv_fullname.text = chat.fullName
        }

    }

    class AddedViewHolderYes(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
    class AddedViewHolderNo(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }

}