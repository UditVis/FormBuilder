package inc.peace.formbuilder.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.dao.FormDAO;
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
        if(formNameEditText.isFocused()){
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
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
                addForm();
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
        if(formNameEditText.isFocused()){
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
        Toast.makeText(mContext,"All Fields Clear",Toast.LENGTH_SHORT).show();
    }

    private void addForm(){
        try{
            String formName = formNameEditText.getText().toString();
            String formUID = UtilityMethods.getUUID();
            form = new FormModel();
            form.setFormName(formName);
            form.setFormUID(formUID);
            form.setOwnerId("ownerid");
            FormDAO formDAO = new FormDAO();
            boolean isFormAdded = false;
            isFormAdded = formDAO.addForm(mContext,form);
            Log.d("addForm()","addF()" + isFormAdded);
            if(isFormAdded){
                Toast.makeText(mContext,"Form Created " + form.getFormName(),Toast.LENGTH_LONG).show();
                formNameEditText.setText("");
                showAddAnotherFormDialog();
                //TODO add form to recycler view adapter for formlistactivity
            }else{
                Toast.makeText(mContext,"Unable To Create Form " + form.getFormName(),Toast.LENGTH_LONG).show();
                formNameEditText.setText("");
            }
        }catch (Exception e){e.printStackTrace();}
    }

    private void showAddAnotherFormDialog(){
        new AlertDialog.Builder(mContext).setTitle("Confirm").setMessage("Do you want to create another form?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetToDefault();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Do nothing when click No
                //TODO Go back to formlist with updated adapter for form list
            }
        }).show();
    }

}
