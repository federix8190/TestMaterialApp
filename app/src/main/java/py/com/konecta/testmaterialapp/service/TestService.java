package py.com.konecta.testmaterialapp.service;

import java.util.List;

import py.com.konecta.testmaterialapp.Item;
import py.com.konecta.testmaterialapp.adapter.model.Cpt;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by konecta on 04/03/18.
 */

public interface TestService {

    @GET("/TestRest/test/items")
    Call<List<Item>> getItems();
}
