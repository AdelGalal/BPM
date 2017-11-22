/*
 * Copyright 2016. Alejandro Sánchez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package psystems.co.bpm.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import psystems.co.bpm.ui.model.ZipCodeData;

public class ZipCodesAdapter extends RecyclerView.Adapter<ZipCodesAdapter.ZipCodesViewHolder>{

    private List<ZipCodeData> zipCodeDataList;

    @Inject
    public ZipCodesAdapter() {
        zipCodeDataList = new ArrayList<>();
    }

    public void setZipCodeDataList(List<ZipCodeData> zipCodeDataList) {
        this.zipCodeDataList = zipCodeDataList;
    }

    @Override
    public int getItemCount() {
        return zipCodeDataList.size();
    }

    @Override
    public ZipCodesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.list_item_zip_code, null);
        return null;
    }

    @Override
    public void onBindViewHolder(ZipCodesViewHolder holder, int position) {
        holder.bind( zipCodeDataList.get( position ) );
    }

    protected static class ZipCodesViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCityName, tvCityZip, tvCityAreaCode, tvCityState;

        public ZipCodesViewHolder(View itemView) {
            super(itemView);
//            tvCityAreaCode= (TextView)itemView.findViewById(R.id.tv_city_area_code);
//            tvCityName= (TextView)itemView.findViewById(R.id.tv_city_name);
//            tvCityZip= (TextView)itemView.findViewById(R.id.tv_city_zip);
//            tvCityState= (TextView)itemView.findViewById(R.id.tv_city_state);
        }

        public void bind(ZipCodeData data){

//            tvCityName.setText(data.getCity());
//
//            tvCityAreaCode.setText( itemView.getContext().getString(R.string.item_area, data.getAreaCode() ) );
//
//            tvCityZip.setText(itemView.getContext().getString(R.string.item_zip, data.getZipCode() ) );
//
//            tvCityState.setText(itemView.getContext().getString(R.string.item_state, data.getState() ) );getState
        }

    }

}
