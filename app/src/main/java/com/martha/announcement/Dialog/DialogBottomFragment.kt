package com.martha.announcement.Dialog


import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import com.martha.announcement.MainActivity
import com.martha.announcement.R
import com.martha.announcement.customview.RoundedBottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dialog_bottom.*

class DialogBottomFragment : RoundedBottomSheetDialogFragment() {

    override fun onViewInitialized(savedInstanceState: Bundle?) {}

    override fun setLayout(): Int {
        return R.layout.fragment_dialog_bottom
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initAction()
    }


    fun initView() {
        if (preferenceHelper.filter == "Terbaru dibagikan" || preferenceHelper.filter == "") {
            iv_filter_first.setBackgroundResource(R.drawable.ic_selected)
            iv_filter_second.setBackgroundResource(R.drawable.ic_unselected)
            iv_filter_third.setBackgroundResource(R.drawable.ic_unselected)
        } else if (preferenceHelper.filter == "Tanggal kegiatan terdekat") {
            iv_filter_first.setBackgroundResource(R.drawable.ic_unselected)
            iv_filter_second.setBackgroundResource(R.drawable.ic_selected)
            iv_filter_third.setBackgroundResource(R.drawable.ic_unselected)
        } else if (preferenceHelper.filter == "Belum dibaca") {
            iv_filter_first.setBackgroundResource(R.drawable.ic_unselected)
            iv_filter_second.setBackgroundResource(R.drawable.ic_unselected)
            iv_filter_third.setBackgroundResource(R.drawable.ic_selected)
        }
    }

    fun initAction() {
        iv_filter_first.setOnClickListener {
            preferenceHelper.filter = "Terbaru dibagikan"
            goToActivity(MainActivity::class.java, null, true)
        }

        iv_filter_second.setOnClickListener {
            preferenceHelper.filter = "Tanggal kegiatan terdekat"
            goToActivity(MainActivity::class.java, null, true)
        }

        iv_filter_third.setOnClickListener {
            preferenceHelper.filter = "Belum dibaca"
            goToActivity(MainActivity::class.java, null, true)
        }

        iv_close.setOnClickListener {
            dismiss()
        }
    }
}
