package py.com.konecta.testmaterialapp.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import py.com.konecta.testmaterialapp.Item;
import py.com.konecta.testmaterialapp.R;
import py.com.konecta.testmaterialapp.adapter.MyAdapter;
import py.com.konecta.testmaterialapp.service.ServiceBuilder;
import py.com.konecta.testmaterialapp.service.TestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImportActivity extends BaseActivity implements Callback<List<Item>> {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBar;

    @Override
    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
        if (response.isSuccessful()) {
            List<Item> items = response.body();
            mAdapter = new MyAdapter(items);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(this, "Ocurrio un error al procesar la respuesta del Servidor", Toast.LENGTH_SHORT).show();
        }
        showProgress(false);
    }

    @Override
    public void onFailure(Call<List<Item>> call, Throwable t) {
        t.printStackTrace();
        showProgress(false);
        Toast.makeText(this, "Ocurrio un error al invocar al servicio", Toast.LENGTH_SHORT).show();
    }

    public void showProgress(final boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(show? View.GONE: View.VISIBLE);
    }

    @Override
    protected void inint() {

        loadLayout(R.layout.activity_import, "Importar");
        progressBar = (ProgressBar) findViewById(R.id.progressbar_login);
        mRecyclerView = getRecyclerView(R.id.my_recycler_view);        

        TestService service = (TestService) ServiceBuilder.create(TestService.class);
        Call<List<Item>> call = service.getItems();
        call.enqueue(this);
    }
}
