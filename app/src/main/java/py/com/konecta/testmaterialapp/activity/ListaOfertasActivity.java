package py.com.konecta.testmaterialapp.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

import py.com.konecta.testmaterialapp.R;
import py.com.konecta.testmaterialapp.adapter.OfertasAdapter;
import py.com.konecta.testmaterialapp.model.Oferta;
import py.com.konecta.testmaterialapp.service.ListaResponse;
import py.com.konecta.testmaterialapp.service.ServiceBuilder;
import py.com.konecta.testmaterialapp.service.OfertaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaOfertasActivity extends BaseActivity implements Callback<ListaResponse<Oferta>> {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar progressBar;

    @Override
    protected void inint() {

        loadLayout(R.layout.activity_import, "Ofertas");
        progressBar = (ProgressBar) findViewById(R.id.progressbar_login);
        mRecyclerView = getRecyclerView(R.id.my_recycler_view);

        OfertaService service = (OfertaService) ServiceBuilder.create(OfertaService.class);
        Call<ListaResponse<Oferta>> call = service.listar();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListaResponse<Oferta>> call, Response<ListaResponse<Oferta>> response) {
        if (response.isSuccessful()) {
            ListaResponse<Oferta> ofertas = response.body();
            mAdapter = new OfertasAdapter(ofertas.getRows());
            mRecyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(this, "Ocurrio un error al procesar la respuesta del Servidor", Toast.LENGTH_SHORT).show();
        }
        showProgress(false);
    }

    @Override
    public void onFailure(Call<ListaResponse<Oferta>> call, Throwable t) {
        t.printStackTrace();
        showProgress(false);
        List<Oferta> ofertas = new ArrayList<>();
        ofertas.add(new Oferta());
        ofertas.add(new Oferta());
        ofertas.add(new Oferta());
        mAdapter = new OfertasAdapter(ofertas);
            mRecyclerView.setAdapter(mAdapter);
        Toast.makeText(this, "Ocurrio un error al invocar al servicio : " + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void showProgress(final boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(show? View.GONE: View.VISIBLE);
    }

}
