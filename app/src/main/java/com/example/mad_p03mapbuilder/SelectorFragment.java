package com.example.mad_p03mapbuilder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MotionEvent;
import android.view.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM2 = "parama2";

    // TODO: Rename and change types of parameters
    private StructureData dataList = StructureData.get();
    private CommonData bviewModel;

    public SelectorFragment() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectorFragment newInstance() {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        RecyclerView rv = view.findViewById(R.id.selectorRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        MyAdapter myAdapter = new MyAdapter(dataList);
        rv.setAdapter(myAdapter);
        return view;


    }


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private CommonData viewModel;
        StructureData dataList;

        public MyAdapter(StructureData dataList)
        {
            this.dataList = dataList;
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
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
            vh.itemName.setText(dataList.get(index).getLabel());
            int id = dataList.get(index).getDrawableId();
            int check = 0;
            vh.itemButton.setImageDrawable(getResources().getDrawable(id));
            bviewModel = new ViewModelProvider(requireActivity()).get(CommonData.class);

            vh.itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bviewModel.setValue(id);
                }

            });

            vh.itemButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP: {
                            v.getBackground().clearColorFilter();
                            v.invalidate();
                            break;
                        }
                    }

                    return false;
                }
            });

        };
    }// END OF ADAPTER

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageButton itemButton;

        public MyViewHolder(@NonNull LayoutInflater li, ViewGroup parent){
            super(li.inflate(R.layout.list_selection,parent,false));
            itemName = (TextView) itemView.findViewById(R.id.locationName);
            itemButton = (ImageButton) itemView.findViewById(R.id.location);

        }
    }// END OF MYVIEWHOLDER
}//END OF SELECTORFRAGMENT