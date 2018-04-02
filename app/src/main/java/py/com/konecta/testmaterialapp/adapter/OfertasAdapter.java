package py.com.konecta.testmaterialapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import py.com.konecta.testmaterialapp.model.Oferta;
import py.com.konecta.testmaterialapp.R;

public class OfertasAdapter extends RecyclerView.Adapter<OfertasAdapter.ViewHolder> {

    private List<Oferta> mDataset;
    
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ViewHolder(View v) {
            super(v);
            view = v;
            mTextView1 = (TextView) view.findViewById(R.id.titulo);
            mTextView2 = (TextView) view.findViewById(R.id.estado);
            mTextView3 = (TextView) view.findViewById(R.id.monto_base);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public OfertasAdapter(List<Oferta> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OfertasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_ofertas, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
		Oferta oferta = mDataset.get(position);
        holder.mTextView1.setText(oferta.getTitulo());
        holder.mTextView2.setText(oferta.getEstado());
        //holder.mTextView3.setText(oferta.getMontoBase());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
