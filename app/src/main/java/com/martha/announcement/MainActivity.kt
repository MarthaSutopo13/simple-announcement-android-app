package com.martha.announcement

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.martha.announcement.Dialog.DialogBottomFragment
import com.martha.announcement.adapter.AnnoucementAdapter
import com.martha.core_base.base.BaseActivity
import com.martha.core_base.model.Announcement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var annAdapter : AnnoucementAdapter
    val layoutManager = LinearLayoutManager(this)
    val addList: MutableList<Announcement> = ArrayList()

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun onInitializedView(savedInstanceState: Bundle?) {
        initView()
        initAction()
    }

    override fun onResume() {
        super.onResume()

        tv_description.text = if (preferenceHelper.filter == "") "Urutkan berdasarkan 'Terbaru dibagikan'" else "Urutkan berdasarkan " + "'" + preferenceHelper.filter + "'"
    }

    fun initView() {
        rv_pengumuman.layoutManager = layoutManager
        annAdapter = AnnoucementAdapter(this)
        rv_pengumuman.adapter = annAdapter


        addList.add(Announcement("Gladi Bersin Lomba Tari", "Kevin Himawan", "TK Kecil Bintang Jakarta", "20 Desember", "09.00 - 10.00", "Konfirmasi Kedatangan"))
        addList.add(Announcement("Gladi Bersin Lomba Basket", "Martha Sutopo", "SMAK 1 Bina Bakti Bandung", "20 April", "09.00 - 10.00", "Mungkin Hadir"))
        addList.add(Announcement("Gladi Bersin Lomba Lari", "Kevin Himawan", "TK Kecil Bintang Jakarta", "20 Desember", "09.00 - 10.00", "Konfirmasi Kedatangan"))
        addList.add(Announcement("Gladi Bersin Lomba Bulu tangkis", "Martha Sutopo", "SMAK 1 Bina Bakti Bandung", "20 April", "09.00 - 10.00", "Mungkin Hadir"))
        annAdapter.setAnnouncement(addList)
    }

    fun initAction() {
        ll_filter.setOnClickListener {
            val dialog = DialogBottomFragment()
            dialog.show(supportFragmentManager, "show")
        }

        sr_pengumuman.setOnRefreshListener {
            sr_pengumuman.isRefreshing = false
        }
    }
}
