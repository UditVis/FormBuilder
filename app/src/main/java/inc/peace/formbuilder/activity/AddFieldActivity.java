package inc.peace.formbuilder.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.model.FieldModel;
import inc.peace.formbuilder.util.UtilityMethods;
import inc.peace.formbuilder.views.ThreeButtonView;

/**
 * Created by Udit on 2/4/2018.
 */

public class AddFieldActivity extends AppCompatActivity{

    private EditText fieldNameEditText,fieldQuestionEditText;
    private CheckBox isRequiredCheckbox,isEmailCheckbox,isPhoneCheckbox,isNumberCheckbox,isDecimalCheckbox;
    private Spinner numOfDigitsSpinner,numOfDeciSpinner;
    private ThreeButtonView threeButtonView;
    private List numOfDigitsList,numOfDeciList;
    private View.OnClickListener addBtnClickListener,resetBtnClickListener,cancelBtnClickListener;
    private Context mContext;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_field_input);
        mContext = this;
        init();
    }

    private void init(){
        fieldNameEditText = this.findViewById(R.id.field_name_edittext);
        fieldQuestionEditText = this.findViewById(R.id.field_question_edittext);
        isRequiredCheckbox = this.findViewById(R.id.isrequired_checkbox);
        isNumberCheckbox = this.findViewById(R.id.isnumber_checkbox);
        isDecimalCheckbox = this.findViewById(R.id.isdecimal_checkbox);
        isEmailCheckbox = this.findViewById(R.id.isemail_checkbox);
        isPhoneCheckbox = this.findViewById(R.id.isphone_checkbox);
        numOfDigitsSpinner = this.findViewById(R.id.numdigits_spinner);
        numOfDeciSpinner = this.findViewById(R.id.decidigits_spinner);
        threeButtonView = this.findViewById(R.id.add_input_threebuttonview);
        resetToDefault();
        initCheckboxListeners();
        threeButtonView.init(this);
        threeButtonView.setResetBtnListener(getResetBtnClickListener());
        threeButtonView.setAddBtnListener(getAddBtnClickListener());
        threeButtonView.setCancelBtn(getCancelBtnClickListener());
    }

    private void initCheckboxListeners(){
        isNumberCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    isEmailCheckbox.setEnabled(false);
                    isPhoneCheckbox.setEnabled(false);
                    isDecimalCheckbox.setEnabled(true);
                    numOfDigitsSpinner.setEnabled(true);
                }else{
                    isEmailCheckbox.setEnabled(true);
                    isPhoneCheckbox.setEnabled(true);
                    isDecimalCheckbox.setEnabled(false);
                    numOfDigitsSpinner.setEnabled(false);
                }
            }
        });
        isDecimalCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    numOfDeciSpinner.setEnabled(true);
                }else{
                    numOfDeciSpinner.setEnabled(false);
                }
            }
        });
        isPhoneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    isEmailCheckbox.setEnabled(false);
                    isNumberCheckbox.setChecked(false);
                    isNumberCheckbox.setEnabled(false);
                }else{
                    isEmailCheckbox.setEnabled(true);
                    isNumberCheckbox.setEnabled(true);
                }
            }
        });
        isEmailCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    isPhoneCheckbox.setEnabled(false);
                    isNumberCheckbox.setChecked(false);
                    isNumberCheckbox.setEnabled(false);
                }else{
                    isPhoneCheckbox.setEnabled(true);
                    isNumberCheckbox.setEnabled(true);
                }
            }
        });
    }


    private List getNumOfDigitsList(){
        numOfDigitsList = new ArrayList();
        for(int i = 1;i<=20;i++){
            numOfDigitsList.add(i);
        }
        return numOfDigitsList;
    }
    private List getNumOfDeciDig(){
        numOfDeciList = new ArrayList();
        for(int i = 1;i<=5;i++){
            numOfDeciList.add(i);
        }
        return numOfDeciList;
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
    private void resetToDefault(){
        fieldNameEditText.setText("");
        fieldQuestionEditText.setText("");
        isRequiredCheckbox.setChecked(false);
        isNumberCheckbox.setChecked(false);
        isDecimalCheckbox.setEnabled(false);
        numOfDigitsSpinner.setEnabled(false);
        numOfDeciSpinner.setEnabled(false);
        isEmailCheckbox.setChecked(false);
        isPhoneCheckbox.setChecked(false);
        ArrayAdapter spinnerAdapter =  new ArrayAdapter(this,R.layout.layout_spinner_item,getNumOfDigitsList());
        spinnerAdapter.setDropDownViewResource(R.layout.layout_spinner_item);
        numOfDigitsSpinner.setAdapter(spinnerAdapter);
        spinnerAdapter = new ArrayAdapter(this,R.layout.layout_spinner_item,getNumOfDeciDig());
        spinnerAdapter.setDropDownViewResource(R.layout.layout_spinner_item);
        numOfDeciSpinner.setAdapter(spinnerAdapter);
        numOfDigitsSpinner.setSelection(10);
        numOfDeciSpinner.setSelection(1);
    }

    private void showConfirmResetDialog(){
        new AlertDialog.Builder(mContext).setTitle("Confirm").setMessage("Are you sure you want to clear all the fields?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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

    private FieldModel getFieldModelFromSettings(){
       try{
           String formId = UtilityMethods.getRandomRefId(6,"Form1"); //count->length of ID,
           // fieldName->To generate based on field name
           String fieldId = UtilityMethods.getUUID();
           String fieldName = fieldNameEditText.getText().toString();
           String fieldQuestion = fieldQuestionEditText.getText().toString();
           boolean isRequired = isRequiredCheckbox.isChecked();
           String fieldType = "INPUT";
           String fieldRef = UtilityMethods.getRandomRefId(6,fieldName);
           boolean isPhone = isPhoneCheckbox.isChecked();
           boolean isEmail = isEmailCheckbox.isChecked();
           boolean isNumber = isNumberCheckbox.isChecked();
           boolean isDecimal = isDecimalCheckbox.isChecked();
           int numberLength = (int)numOfDigitsSpinner.getSelectedItem();
           int numOfDeci = (int)numOfDeciSpinner.getSelectedItem();
           JSONObject otherFieldProperties = new JSONObject();
           if(isPhone){
               otherFieldProperties.put("input_type","PHONE");
           }else if(isEmail){
               otherFieldProperties.put("input_type","EMAIL");
           }else if(isNumber){
               otherFieldProperties.put("input_type","NUMBER");
               otherFieldProperties.put("length",numberLength);
               if(isDecimal){
                   otherFieldProperties.put("input_type","DECIMAL");
                   otherFieldProperties.put("digits_after_deci",numOfDeci);
               }
           }else{
               otherFieldProperties.put("input_type","TEXT");
           }
           FieldModel newField = new FieldModel();
           newField.setFormID(formId);
           newField.setFieldID(fieldId);
           newField.setFieldName(fieldName);
           newField.setFieldQuestion(fieldQuestion);
           newField.setFieldType(fieldType);
           newField.setRequired(isRequired);
           newField.setFieldReference(fieldRef);
           newField.setFieldProperties(otherFieldProperties);
           return newField;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }



}
