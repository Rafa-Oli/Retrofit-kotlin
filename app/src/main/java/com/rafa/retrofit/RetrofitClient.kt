package com.rafa.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//singleton: apenas uma instancia da classe, e quem gerencia é a propria classe
class RetrofitClient private constructor(){


    companion object{
        private lateinit var retrofit: Retrofit
        private val baseUrl=  "https://jsonplaceholder.typicode.com/"


       private  fun getRetrofitInstance(): Retrofit{
            val httpCliente= OkHttpClient.Builder()
            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpCliente.build())// quem vai gerenciar as conexões a http
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
        return  retrofit

        }

        fun <S> createService(serviceClass: Class<S>): S{
            return getRetrofitInstance().create(serviceClass)

        }
    }

}