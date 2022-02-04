package com.example.imoaplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imoaplication.R
import com.example.imoaplication.model.Chat
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class ChatAdapter (var context: Context, var items: ArrayList<Chat>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view, parent, false)
        return MessageViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is MessageViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val tv_count = holder.tv_count

            iv_profile.setImageResource(chat.profile)
            tv_fullname.text = chat.fullName
            tv_count.text = chat.count.toString()

            if (chat.count >0){
                tv_count.visibility = View.VISIBLE
            }else{
                tv_count.visibility= View.GONE
            }
        }
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)
        var tv_count : TextView = view.findViewById(R.id.tv_count)

    }

}