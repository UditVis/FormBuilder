package inc.peace.formbuilder.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.adapters.FormListAdapter;
import inc.peace.formbuilder.listener.FormListRecyclerListener;
import inc.peace.formbuilder.model.FormModel;

/**
 * Created by Udit on 2/8/2018.
 */

public class FormsListActivity extends AppCompatActivity {

    private List<FormModel> forms = new ArrayList<FormModel>();
    private RecyclerView formListRecycler;
    private FormListAdapter formsAdapter;
    private FloatingActionButton addFormFab;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formlist);

        mContext = this;
        init();
    }

    private void init(){
        formListRecycler = (RecyclerView)this.findViewById(R.id.form_list_recycler);
        addFormFab = (FloatingActionButton) this.findViewById(R.id.add_form_fab);

        formsAdapter = new FormListAdapter(forms);
        RecyclerView.LayoutManager recyclerLM = new LinearLayoutManager(getApplicationContext());
        formListRecycler.setLayoutManager(recyclerLM);
        formListRecycler.setItemAnimator(new DefaultItemAnimator());
        formListRecycler.setAdapter(formsAdapter);

        //TODO get data from DB(local) and prepare list and display

        prepareFormData();
        addFormFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareFormData();
            }
        });
    }

    public void prepareFormData(){
        for(int i = 0;i<10;i++){
            FormModel mmm = new FormModel();
            mmm.setFormName("TestFF_" + i);
            mmm.setNoOfFields(i);
            forms.add(mmm);
        }
        formsAdapter.notifyDataSetChanged();
    }

    private FormListRecyclerListener getRecyclerItemListener(){
        return new FormListRecyclerListener(mContext, formListRecycler, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //TODO openBottomSheetModal()
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        })
    }

    /**
     * Created by Udit on 2/11/2018.
     */

    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }
}
