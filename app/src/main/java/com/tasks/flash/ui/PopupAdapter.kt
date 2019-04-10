package com.tasks.flash.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker
import com.tasks.flash.R
import kotlinx.android.synthetic.main.layout_popup.view.*

internal class PopupAdapter(
    private val inflater: LayoutInflater,
    private val popup: View = inflater.inflate(R.layout.layout_popup, null)
) : InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    @SuppressLint("InflateParams")
    override fun getInfoContents(marker: Marker): View {
        popup.tvTitle.text = marker.title
        popup.tvSnippet.text = marker.snippet
        return this.popup
    }
}