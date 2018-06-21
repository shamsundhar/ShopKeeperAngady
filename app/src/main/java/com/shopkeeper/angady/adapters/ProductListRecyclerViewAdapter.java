package com.shopkeeper.angady.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import angady.com.customer.R;
import angady.com.customer.model.Shop;

/**
 * Created by shyam on 2/26/2018.
 */

public class ProductListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> items;
    private final int PRODUCT_LIST_ITEM = 0;
    private OnItemClickListener listener;

    public ProductListRecyclerViewAdapter(List<Object> items){
        this.items = items;
    }
    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.listener = clickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if(viewType == PRODUCT_LIST_ITEM){
            View v1 = inflater.inflate(R.layout.layout_productlistitem, viewGroup, false);
            viewHolder = new ProductListRecyclerViewAdapter.ViewHolder1(v1);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case PRODUCT_LIST_ITEM:
                ProductListRecyclerViewAdapter.ViewHolder1 vh1 = (ProductListRecyclerViewAdapter.ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            default:
                //  RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
                //  configureDefaultViewHolder(vh, position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Shop) {
            return PRODUCT_LIST_ITEM;
        }
        return -1;
    }
    private void configureViewHolder1(final ProductListRecyclerViewAdapter.ViewHolder1 vh1, int position) {
        Shop shopModel = (Shop) items.get(position);
        if (shopModel != null) {
            vh1.getItemName().setText(shopModel.getShopName());
            vh1.getItemShortDesc().setText(shopModel.getShopShortAddress());
          //  vh1.bind(shopModel, listener);

//            vh1.getAdd_item().setOnClickListener(
//                    new View.OnClickListener() {
//
//                        @Override
//                        public void onClick(View v) {
//                            //current object
//                            Product tempObj = productList.get(position);
//
//
//                            //if current object is lready in shopping list
//                            if (CenterRepository.getCenterRepository()
//                                    .getListOfProductsInShoppingList().contains(tempObj)) {
//
//
//
//
//
//
//
//                                // update quanity in shopping list
//                                CenterRepository
//                                        .getCenterRepository()
//                                        .getListOfProductsInShoppingList()
//                                        .get(indexOfTempInShopingList)
//                                        .setQuantity(
//                                                String.valueOf(Integer
//                                                        .valueOf(tempObj
//                                                                .getQuantity()) + 1));
//
//
//                                //update checkout amount
//                                ((ECartHomeActivity) getContext()).updateCheckOutAmount(
//                                        BigDecimal
//                                                .valueOf(Long
//                                                        .valueOf(productList
//                                                                .get(position)
//                                                                .getSellMRP())),
//                                        true);
//
//                                // update current item quanitity
//                                vh1.getItem_count().setText("1");
//
//                            } else {
//
//                                ((ECartHomeActivity) getContext()).updateItemCount(true);
//
//                                tempObj.setQuantity(String.valueOf(1));
//
//                                holder.quanitity.setText(tempObj.getQuantity());
//
//                                CenterRepository.getCenterRepository()
//                                        .getListOfProductsInShoppingList().add(tempObj);
//
//                                ((ECartHomeActivity) getContext()).updateCheckOutAmount(
//                                        BigDecimal
//                                                .valueOf(Long
//                                                        .valueOf(productList
//                                                                .get(position)
//                                                                .getSellMRP())),
//                                        true);
//
//                            }
//
//                            Utils.vibrate(getContext());
//
//
//                        }
//                    });
//
//            holder.removeItem.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//
//                    Product tempObj = (productList).get(position);
//
//                    if (CenterRepository.getCenterRepository().getListOfProductsInShoppingList()
//                            .contains(tempObj)) {
//
//                        int indexOfTempInShopingList = CenterRepository
//                                .getCenterRepository().getListOfProductsInShoppingList()
//                                .indexOf(tempObj);
//
//                        if (Integer.valueOf(tempObj.getQuantity()) != 0) {
//
//                            CenterRepository
//                                    .getCenterRepository()
//                                    .getListOfProductsInShoppingList()
//                                    .get(indexOfTempInShopingList)
//                                    .setQuantity(
//                                            String.valueOf(Integer.valueOf(tempObj
//                                                    .getQuantity()) - 1));
//
//                            ((ECartHomeActivity) getContext()).updateCheckOutAmount(
//                                    BigDecimal.valueOf(Long.valueOf(productList
//                                            .get(position).getSellMRP())),
//                                    false);
//
//                            holder.quanitity.setText(CenterRepository
//                                    .getCenterRepository().getListOfProductsInShoppingList()
//                                    .get(indexOfTempInShopingList).getQuantity());
//
//                            Utils.vibrate(getContext());
//
//                            if (Integer.valueOf(CenterRepository
//                                    .getCenterRepository().getListOfProductsInShoppingList()
//                                    .get(indexOfTempInShopingList).getQuantity()) == 0) {
//
//                                CenterRepository.getCenterRepository()
//                                        .getListOfProductsInShoppingList()
//                                        .remove(indexOfTempInShopingList);
//
//                                notifyDataSetChanged();
//
//                                ((ECartHomeActivity) getContext())
//                                        .updateItemCount(false);
//
//                            }
//
//                        }
//
//                    } else {
//
//                    }
//
//                }
//
//            });
        }
    }


    class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView item_name, item_short_desc;
        private TextView add_item;
        private TextView remove_item;
        private TextView item_count;

        public TextView getAdd_item() {
            return add_item;
        }

        public void setAdd_item(TextView add_item) {
            this.add_item = add_item;
        }

        public TextView getRemove_item() {
            return remove_item;
        }

        public void setRemove_item(TextView remove_item) {
            this.remove_item = remove_item;
        }

        public TextView getItem_count() {
            return item_count;
        }

        public void setItem_count(TextView item_count) {
            this.item_count = item_count;
        }



        public TextView getItemName() {
            return item_name;
        }

        public void setItemName(TextView item_name) {
            this.item_name = item_name;
        }

        public TextView getItemShortDesc() {
            return item_short_desc;
        }

        public void setItemShortDesc(TextView subtitle) {
            this.item_short_desc = subtitle;
        }

        public ViewHolder1(View v) {
            super(v);
            item_name = (TextView) v.findViewById(R.id.item_name);
            item_short_desc = (TextView) v.findViewById(R.id.item_short_desc);
            add_item = (TextView) v.findViewById(R.id.add_item);
            remove_item = (TextView) v.findViewById(R.id.remove_item);
            item_count = (TextView) v.findViewById(R.id.item_count);
        }
        public void bind(final Shop shop, final OnItemClickListener listener) {
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                    listener.onItemClick(shop.getShopName());
//                }
//            });
        }
    }

}
