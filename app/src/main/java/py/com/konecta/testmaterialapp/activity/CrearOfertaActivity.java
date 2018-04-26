package py.com.konecta.testmaterialapp.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import py.com.konecta.testmaterialapp.R;
import py.com.konecta.testmaterialapp.adapter.OfertasAdapter;
import py.com.konecta.testmaterialapp.model.Lote;
import py.com.konecta.testmaterialapp.model.Oferta;
import py.com.konecta.testmaterialapp.service.ListaResponse;
import py.com.konecta.testmaterialapp.service.LoteService;
import py.com.konecta.testmaterialapp.service.OfertaService;
import py.com.konecta.testmaterialapp.service.ServiceBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

public class CrearOfertaActivity extends BaseActivity implements Callback<ListaResponse<Lote>>, AdapterView.OnItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar progressBar;

    @Override
    protected void inint() {

        loadLayout(R.layout.activity_crear_oferta, "Nueva Oferta");
        //progressBar = (ProgressBar) findViewById(R.id.progressbar_login);
        LoteService service = (LoteService) ServiceBuilder.create(LoteService.class);
        Call<ListaResponse<Lote>> call = service.listar();
        call.enqueue(this);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onResponse(Call<ListaResponse<Lote>> call, Response<ListaResponse<Lote>> response) {
        if (response.isSuccessful()) {
            ListaResponse<Lote> lotes = response.body();
            List<Lote> lista = lotes.getRows();
        } else {
            Toast.makeText(this, "Ocurrio un error al procesar la respuesta del Servidor", Toast.LENGTH_SHORT).show();
        }
        showProgress(false);
    }

    @Override
    public void onFailure(Call<ListaResponse<Lote>> call, Throwable t) {
        t.printStackTrace();
        showProgress(false);
        Toast.makeText(this, "Ocurrio un error al invocar al servicio : " + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void showProgress(final boolean show) {
        //progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        //mRecyclerView.setVisibility(show? View.GONE: View.VISIBLE);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        ;
    }
}

