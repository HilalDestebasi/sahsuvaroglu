package com.sahsuvaroglu.kgm.model

import com.google.android.gms.maps.model.LatLng

data class SatisServisInfoModel(
    val title: String,
    val satSer: String,
    val latLng: LatLng,
    val address: String,
    val phone: String
)
