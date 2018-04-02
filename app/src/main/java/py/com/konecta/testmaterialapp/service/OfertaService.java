package py.com.konecta.testmaterialapp.service;

import py.com.konecta.testmaterialapp.model.Oferta;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface OfertaService {

    @GET("/TestRest/api/ofertas")
    Call<ListaResponse<Oferta>> listar();

    @GET("/TestRest/api/listar/ofertas")
    Call<List<Oferta>> getAll();

}

