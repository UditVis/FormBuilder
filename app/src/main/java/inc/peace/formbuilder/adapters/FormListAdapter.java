package inc.peace.formbuilder.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.model.FormModel;

/**
 * Created by Udit on 2/11/2018.
 */

public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.FormViewHolder> {
    private List<FormModel> forms;
    private Context mContext;

    public class FormViewHolder extends RecyclerView.ViewHolder{

        public TextView formNameTextView,noOfFieldsTextView;
        public ImageView moreImageView;

        public FormViewHolder(View itemView) {
            super(itemView);
            formNameTextView = (TextView) itemView.findViewById(R.id.fl_formname_textview);
            noOfFieldsTextView = (TextView) itemView.findViewById(R.id.fl_fieldno_textview);
            moreImageView = (ImageView) itemView.findViewById(R.id.formlist_more);
        }
    }

    public FormListAdapter(List<FormModel> forms,Context context) {
        this.forms = forms;
        this.mContext = context;
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
        holder.moreImageView.setOnClickListener(getMenuClickListener(holder));
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    public View.OnClickListener getMenuClickListener(final FormViewHolder holder){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(mContext,holder.moreImageView);
                popupMenu.getMenuInflater().inflate(R.menu.menu_formlist_popup,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(mContext,"Clicked on : " + menuItem.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        };
    }
}
