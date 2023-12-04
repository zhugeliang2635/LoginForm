package com.example.maphistory;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.maphistory.databinding.ActivityMainBinding;
import com.example.maphistory.databinding.FragmentInforBinding;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InforFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InforFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Activity context;
    FragmentInforBinding binding;

    InforFragment i = new InforFragment();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InforFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InforFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InforFragment newInstance(String param1, String param2) {
        InforFragment fragment = new InforFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        context = getActivity();
        Intent move = new Intent(context, ListActivity.class);
        startActivity(move);

//        binding = FragmentInforBinding.inflate(getLayoutInflater());
//
//
//        int[] imgageId = {R.drawable.img_7, R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7, R.drawable.img_7,
//                R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7};
//        String[] name = {"Trận Bạch Đằng", "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng",
//                "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng"};
//        String[] time = {"Năm 938", "Năm 938","Năm 938","Năm 938","Năm 938","Năm 938","Năm 938",
//                "Năm 938","Năm 938","Năm 938",};
//
//        ArrayList<ListData> eventList = new ArrayList<>();
//
//        for (int i = 0; i < imgageId.length; i++) {
//            ListData listData = new ListData(name[i], time[i], imgageId[i]);
//            eventList.add(listData);
//        }
//
//        ListAdapter listAdapter = new ListAdapter(i, eventList);
//
//        binding.listview.setAdapter(listAdapter);
//        binding.listview.setClickable(true);
//        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.fragment_infor, container, false);
        return view1;
    }
}