package py.com.konecta.testmaterialapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import py.com.konecta.testmaterialapp.Item;
import py.com.konecta.testmaterialapp.R;

/**
 * Created by Francisco on 25/02/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Item> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ViewHolder(View v) {
            super(v);
            view = v;
            mTextView1 = (TextView) view.findViewById(R.id.linea1);
            mTextView2 = (TextView) view.findViewById(R.id.linea2);
            mTextView3 = (TextView) view.findViewById(R.id.linea3);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Item> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        System.out.println("Datos item " + position + " : " + mDataset.get(position).getLinea1());
        holder.mTextView1.setText(mDataset.get(position).getLinea1());
        holder.mTextView2.setText(mDataset.get(position).getLinea2());
        holder.mTextView3.setText(mDataset.get(position).getLinea3());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
