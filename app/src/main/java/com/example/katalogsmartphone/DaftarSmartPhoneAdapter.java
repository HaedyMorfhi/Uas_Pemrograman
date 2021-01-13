package com.example.katalogsmartphone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.katalogsmartphone.model.HandPhone;

import java.util.List;

public class DaftarSmartPhoneAdapter extends ArrayAdapter<HandPhone> {
    Context context;

    public DaftarSmartPhoneAdapter(@NonNull Context context, @NonNull List<HandPhone> objects) {
        super(context, R.layout.row_phone, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txSpesifikasi;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HandPhone tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_phone, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txSpesifikasi = convertView.findViewById(R.id.row_spec);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txSpesifikasi.setText(tr.getSpesifikasi());
        return convertView;
    }
}
