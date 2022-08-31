package com.example.mad_p03mapbuilder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM2 = "parama2";

    // TODO: Rename and change types of parameters
    private MapData mapData = MapData.get();

    private String parama2 = "";

    public MapFragment() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapData.regenerate();
        RecyclerView rv = view.findViewById(R.id.mapRecyclerView);
        rv.setLayoutManager(new GridLayoutManager(getContext(),MapData.HEIGHT,GridLayoutManager.HORIZONTAL,false));
        MyAdapter myAdapter = new MyAdapter(mapData);

        rv.setAdapter(myAdapter);
        return view;


    }


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private CommonData viewModel;
        MapData mapData;

        public MyAdapter(MapData mapData)
        {
            this.mapData = mapData;
        }

        @Override
        public int getItemCount()
        {
            return mapData.HEIGHT*mapData.WIDTH;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewtype)
        {
            LayoutInflater li = LayoutInflater.from(getActivity());
            return new MyViewHolder(li,parent);
        }

        @Override
        public void onBindViewHolder (MyViewHolder vh, int index)
        {
            int row = index % mapData.HEIGHT;
            int col = index / mapData.WIDTH;

            vh.tl.setImageDrawable(getResources().getDrawable(mapData.get(col,row).getNorthWest()));
            vh.tr.setImageDrawable(getResources().getDrawable(mapData.get(col,row).getNorthEast()));
            vh.br.setImageDrawable(getResources().getDrawable(mapData.get(col,row).getSouthEast()));
            vh.bl.setImageDrawable(getResources().getDrawable(mapData.get(col,row).getSouthWest()));

          /*  viewModel = new ViewModelProvider(requireActivity()).get(CommonData.class);

            vh.itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewModel.setValue(id);
                }

            });*/

        };
    }// END OF ADAPTER

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tl;
        ImageView tr;
        ImageView br;
        ImageView bl;
        ImageView lm;

        public MyViewHolder(@NonNull LayoutInflater li, ViewGroup parent){
            super(li.inflate(R.layout.grid_cell,parent,false));

            int size = parent.getMeasuredHeight()/MapData.HEIGHT + 1;
            ViewGroup. LayoutParams lp = itemView.getLayoutParams();
            lp.width = size;
            lp.height = size;

            tl = (ImageView) itemView.findViewById(R.id.northWest);
            tr = (ImageView) itemView.findViewById(R.id.northEast);
            br = (ImageView) itemView.findViewById(R.id.southEast);
            bl = (ImageView) itemView.findViewById(R.id.southWest);
            lm = (ImageView) itemView.findViewById(R.id.landmark);

        }
    }// END OF MYVIEWHOLDER
}//END OF MapFragment