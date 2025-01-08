package com.drag0n.binlist.domain.retrofit

import com.drag0n.binlist.data.Bin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface BinApi {
@GET("{Bin}")
suspend fun getInfoBin(
    @Path("Bin") bin: String
) : Response<Bin>

}