package com.tasks.flash.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.tasks.flash.R
import com.tasks.flash.baseMVVM.BaseFragment
import kotlinx.android.synthetic.main.fragment_map.*


class MainFragment : BaseFragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lifecycle.addObserver(viewModel)
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        viewModel.notifyUpdate.observe(this, Observer {
            val builder = LatLngBounds.builder()
            for (i in 0 until viewModel.currencyList.size) {
                builder.include(LatLng(viewModel.currencyList[i].latitude, viewModel.currencyList[i].longitude))
                mMap.addMarker(
                    MarkerOptions()
                        .position(LatLng(viewModel.currencyList[i].latitude, viewModel.currencyList[i].longitude))
                        .title(getString(R.string.name) + " " + viewModel.currencyList[i].name)
                        .snippet(
                            getString(R.string.price) + viewModel.currencyList[i].price + " " + viewModel.currencyList[i].currency
                                    + "\n" + getString(R.string.battery_level) + " " + viewModel.currencyList[i].batteryLevel
                                    + "\n" + getString(R.string.description) + " " + viewModel.currencyList[i].description
                        )
                )
            }
            mMap.animateCamera(
                CameraUpdateFactory.newLatLngBounds(
                    builder.build(), resources.getDimensionPixelOffset(R.dimen._30sdp)
                )
            )
        }
        )
        viewModel.notifyFinished.observe(this, Observer {
            showLoadingIndicator(false)
        })
        viewModel.notifyLoading.observe(this, Observer {
            showLoadingIndicator(true)
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setInfoWindowAdapter(PopupAdapter(layoutInflater))
        viewModel.getVehicles()
    }

    private fun showLoadingIndicator(active: Boolean) {
        if (active) pbLoading.visibility = View.VISIBLE
        else pbLoading.visibility = View.GONE
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}