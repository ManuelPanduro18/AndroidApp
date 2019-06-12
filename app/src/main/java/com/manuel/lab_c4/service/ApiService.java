package com.manuel.lab_c4.service;

import com.manuel.lab_c4.models.ResponseMessage;
import com.manuel.lab_c4.models.Solicitud;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    String API_BASE_URL = "http://192.168.43.116:8084";

    @GET("/solicitudes")
    Call<List<Solicitud>> getSolicitudes();

    @FormUrlEncoded
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitud(@Field("tipo") String tipo,
                                          @Field("correo") String correo,
                                          @Field("descripcion") String descripcion);
    @Multipart
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitudWithImage(
            @Part("tipo") RequestBody tipo,
            @Part("correo") RequestBody correo,
            @Part("descripcion") RequestBody descripcion,
            @Part MultipartBody.Part imagen
    );


}
