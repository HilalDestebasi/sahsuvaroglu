package com.sahsuvaroglu.kgm.util

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.sahsuvaroglu.kgm.R


fun showPopup(anchorView: View, context: Context) {
    val inflater: LayoutInflater =
        context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val popupView: View = inflater.inflate(R.layout.popup_layout, null)

    val popupWindow = PopupWindow(
        popupView,
        ConstraintLayout.LayoutParams.WRAP_CONTENT,
        ConstraintLayout.LayoutParams.WRAP_CONTENT
    )

    val closeButton: TextView = popupView.findViewById(R.id.close_button)
    closeButton.setOnClickListener {
        popupWindow.dismiss()
    }


    popupWindow.showAtLocation(anchorView.rootView, Gravity.CENTER, 0, 0)

    popupWindow.isOutsideTouchable = true
    popupWindow.isFocusable = true

}
fun showPopupKampanya(anchorView: View, context: Context,src: Int) {
    val inflater: LayoutInflater =
        context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val popupView: View = inflater.inflate(R.layout.kampanya_popup, null)

    val popupWindow = PopupWindow(
        popupView,
        ConstraintLayout.LayoutParams.WRAP_CONTENT,
        ConstraintLayout.LayoutParams.WRAP_CONTENT
    )

    val closeButton: TextView = popupView.findViewById(R.id.kampanya_close_button)
    closeButton.setOnClickListener {
        popupWindow.dismiss()
    }

    val popup: ImageView = popupView.findViewById(R.id.kampanya_img)
    popup.setImageResource(src)
    popupWindow.showAtLocation(anchorView.rootView, Gravity.CENTER, 0, 0)

    popupWindow.isOutsideTouchable = true
    popupWindow.isFocusable = true

}
