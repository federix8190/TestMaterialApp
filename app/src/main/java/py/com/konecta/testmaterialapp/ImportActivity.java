package py.com.konecta.testmaterialapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import py.com.konecta.testmaterialapp.adapter.MyAdapter;
import py.com.konecta.testmaterialapp.adapter.model.Cpt;
import py.com.konecta.testmaterialapp.service.TestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImportActivity extends AppCompatActivity implements Callback<List<Cpt>> {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(
                mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL
        );
        divider.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.line_separator));
        mRecyclerView.addItemDecoration(divider);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.21:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TestService service = retrofit.create(TestService.class);

        Call<List<Cpt>> call = service.listRepos();
        call.enqueue(this);

        // specify an adapter (see also next example)
        Item item1 = new Item("All Connors", "Brunch this weekend?", "I'll be in your neighborhood doing errands");
        Item item2 = new Item("All Connors", "Brunch this weekend?", "I'll be in your neighborhood doing errands");
        Item item3 = new Item("All Connors", "Brunch this weekend?", "I'll be in your neighborhood doing errands");
        Item item4 = new Item("All Connors", "Brunch this weekend?", "I'll be in your neighborhood doing errands");
        Item item5 = new Item("All Connors", "Brunch this weekend?", "I'll be in your neighborhood doing errands");
        Item[] myDataset = {item1, item2, item3, item4, item5};
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResponse(Call<List<Cpt>> call, Response<List<Cpt>> response) {
        if(response.isSuccessful()) {
            List<Cpt> cptList = response.body();
            for (Cpt c : cptList) {
                System.err.println("Cpt : " + c.getDenominacion());
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Cpt>> call, Throwable t) {
        t.printStackTrace();
    }
}
