package inc.peace.formbuilder.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.model.FormModel;

/**
 * Created by Udit on 2/11/2018.
 */

public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.FormViewHolder> {
    private List<FormModel> forms;

    public class FormViewHolder extends RecyclerView.ViewHolder{

        public TextView formNameTextView,noOfFieldsTextView;

        public FormViewHolder(View itemView) {
            super(itemView);
            formNameTextView = (TextView) itemView.findViewById(R.id.fl_formname_textview);
            noOfFieldsTextView = (TextView) itemView.findViewById(R.id.fl_fieldno_textview);
        }
    }

    public FormListAdapter(List<FormModel> forms) {
        this.forms = forms;
    }

    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.form_list_row,parent,false);
        return new FormViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {
        FormModel formModel = forms.get(position);
        holder.formNameTextView.setText(formModel.getFormName().trim());
        holder.noOfFieldsTextView.setText("Fields : " + formModel.getNoOfFields());
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }
}
