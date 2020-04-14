package com.martha.announcement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.martha.announcement.R
import com.martha.core_base.model.Announcement

class AnnoucementAdapter(val context: Context): RecyclerView.Adapter<AnnoucementAdapter.AnnouncmentViewHolder>() {

    private val announcements: MutableList<Announcement> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncmentViewHolder {
        return AnnouncmentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pengumuman_layout, parent, false))
    }
    override fun getItemCount(): Int {
        return announcements.size
    }

    override fun onBindViewHolder(holder: AnnoucementAdapter.AnnouncmentViewHolder, position: Int) {
        holder.bindModel(announcements[position])
    }

    fun setAnnouncement(data: List<Announcement>) {
        announcements.clear()
        announcements.addAll(data)
        notifyDataSetChanged()
    }

    inner class AnnouncmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTxt: TextView = itemView.findViewById(R.id.tv_title)
        val nameTxt: TextView = itemView.findViewById(R.id.tv_name)
        val schoolNameTxt: TextView = itemView.findViewById(R.id.tv_school_name)
        val dateTxt: TextView = itemView.findViewById(R.id.tv_date)
        val timeTxt: TextView = itemView.findViewById(R.id.tv_time)
        val statusTxt: TextView = itemView.findViewById(R.id.tv_status)
        val signalLl: LinearLayout = itemView.findViewById(R.id.ll_signal)


        fun bindModel(ann: Announcement) {
            titleTxt.text = ann.getTitle()
            nameTxt.text = ann.getName()
            schoolNameTxt.text = ann.getSchoolName()
            dateTxt.text = ann.getDate()
            timeTxt.text = ann.getTime()
            statusTxt.text = ann.getStatus()

            if (ann.getStatus() == "Konfirmasi Kedatangan") {
                statusTxt.setTextColor(context.resources.getColor(R.color.white))
                statusTxt.setBackgroundColor(context.resources.getColor(R.color.maya_blue))
                signalLl.visibility = View.VISIBLE
            } else {
                statusTxt.setTextColor(context.resources.getColor(R.color.tangerin))
                statusTxt.setBackgroundColor(context.resources.getColor(R.color.white))
                signalLl.visibility = View.GONE
            }
        }
    }
}