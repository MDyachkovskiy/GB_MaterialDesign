package com.gb_materialdesign.repository.marsPicture

import com.gb_materialdesign.model.marsPicture.MarsPictureResponse
import com.gb_materialdesign.model.pictureOfTheDay.RemoteSourceNasaAPI
import retrofit2.Callback

class MarsPictureRepositoryImpl (
    private val remoteSourceNasaAPI: RemoteSourceNasaAPI
        ) : MarsPictureRepository {

    override fun getPictureOfMars(
        date: String,
        camera: String?,
        callback: Callback<MarsPictureResponse>
    ) {
        remoteSourceNasaAPI.getPicturesOfMars(date, camera, callback)
    }

}