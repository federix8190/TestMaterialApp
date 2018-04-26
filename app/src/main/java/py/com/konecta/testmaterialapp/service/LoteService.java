package py.com.konecta.testmaterialapp.service;

import py.com.konecta.testmaterialapp.model.Lote;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface LoteService {

    @GET("/TestRest/api/lotes")
    Call<ListaResponse<Lote>> listar();

    @GET("/TestRest/api/listar/lotes")
    Call<List<Lote>> getAll();

}

