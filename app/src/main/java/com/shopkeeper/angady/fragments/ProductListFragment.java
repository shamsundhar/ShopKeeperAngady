package com.shopkeeper.angady.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import angady.com.customer.R;
import angady.com.customer.adapters.OnItemClickListener;
import angady.com.customer.adapters.ProductListRecyclerViewAdapter;
import angady.com.customer.model.Shop;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shyam on 2/26/2018.
 */

public class ProductListFragment extends Fragment {
    @BindView(R.id.RecyclerView)
    RecyclerView recyclerView;
    private ProductListRecyclerViewAdapter productListRecyclerViewAdapter;
    public ProductListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ShopListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, null);
        ButterKnife.bind(this, view);
        productListRecyclerViewAdapter = new ProductListRecyclerViewAdapter(getSampleArrayList());
        recyclerView.setAdapter(productListRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productListRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String storeName) {
//                Intent intent = new Intent(getActivity(), ProductListActivity.class);
//                intent.putExtra(BUNDLE_KEY_SHOP_NAME, storeName);
//                startActivity(intent);
            }
        });
        return view;
    }
    private ArrayList<Object> getSampleArrayList() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new Shop("Prasanna Mart1", "T Nagar"));
        items.add(new Shop("Prasanna Mart2", "Bangalore"));
        items.add(new Shop("Prasanna Mart3", "Hyderabad"));
        items.add(new Shop("Prasanna Mart4", "Secunderabad"));
        items.add(new Shop("Prasanna Mart5", "vijayawada"));
        items.add(new Shop("Prasanna Mart6", "Vishakapatnam"));
        items.add(new Shop("Prasanna Mart7", "Kurnool"));
        items.add(new Shop("Prasanna Mart8", "Kadapa"));
        items.add(new Shop("Prasanna Mart9", "Chennai"));
        items.add(new Shop("Prasanna Mart10", "Cochin"));
        return items;
    }
}
