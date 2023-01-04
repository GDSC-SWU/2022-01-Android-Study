package com.example.gdsc_myapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface INetworkService {
    @GET("AsosDalyInfoService/getWthrDataList")
    fun doGetTemperList(
        @Query("ServiceKey") ServiceKey: String,
        @Query("pageNo") pageNo: String,
        @Query("dataType") dataType: String,
        @Query("dataCd") dataCd: String,
        @Query("dateCd") dateCd: String,
        @Query("startDt") startDt: String,
        @Query("endDt") endDt: String,
        @Query("stnIds") stnIds: String
    ) : Call<TemperListModel>
}
