package inc.peace.formbuilder.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.model.FormModel;
import inc.peace.formbuilder.util.UtilityMethods;
import inc.peace.formbuilder.views.ThreeButtonView;

/**
 * Created by Udit on 2/8/2018.
 */

public class CreateFormActivity extends AppCompatActivity {
    private EditText formNameEditText;
    private ThreeButtonView addFormThreeButtonView;
    private View.OnClickListener addBtnClickListener,resetBtnClickListener,cancelBtnClickListener;
    private FormModel form;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        mContext = this;
        initView();
    }

    public void initView(){
        formNameEditText = this.findViewById(R.id.form_name_edittext);
        addFormThreeButtonView = this.findViewById(R.id.add_form_threebuttonview);
        addFormThreeButtonView.init(mContext);
        addFormThreeButtonView.setAddBtnListener(getAddBtnClickListener());
        addFormThreeButtonView.setResetBtnListener(getResetBtnClickListener());
        addFormThreeButtonView.setCancelBtn(getCancelBtnClickListener());
    }


    private View.OnClickListener getAddBtnClickListener(){
        addBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"You Clicked on Add!",Toast.LENGTH_SHORT).show();
                //TODO first check for whether fieldname and fieldquestion have been supplied or not
                //TODO if proper, then save this field model in DB(Local) and go back to main
                // form view
            }
        };
        return addBtnClickListener;
    }
    private View.OnClickListener getResetBtnClickListener(){
        resetBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmResetDialog();
            }
        };
        return resetBtnClickListener;
    }
    private View.OnClickListener getCancelBtnClickListener(){
        cancelBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"You Clicked on cancel!",Toast.LENGTH_SHORT).show();
            }
        };
        return cancelBtnClickListener;
    }

    private void showConfirmResetDialog(){
        new AlertDialog.Builder(mContext).setTitle("Confirm").setMessage("Are you sure you want to clear?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetToDefault();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Do nothing when click No
            }
        }).show();
    }

    private void resetToDefault(){
        formNameEditText.setText("");
        Toast.makeText(mContext,"Field clear",Toast.LENGTH_SHORT).show();
    }

    private void addForm(){
        try{
            String formName = formNameEditText.getText().toString();
            String formUID = UtilityMethods.getUUID();
            form.setFormName(formName);
            form.setFormUID(formUID);
            //TODO addFormToDB()
            //TODO add form to recycler view adapter for formlistactivity
            //TODO ask for another form? Dialog like 'DO you want to create another form?YES/NO'
        }catch (Exception e){e.printStackTrace();}
    }

}
