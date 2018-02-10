package inc.peace.formbuilder.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import inc.peace.formbuilder.helper.DBHelper;
import inc.peace.formbuilder.model.FormModel;

/**
 * Created by Udit on 2/10/2018.
 */

public class FormDAO {
    private DBHelper helper;
    private SQLiteDatabase sqLiteDatabase;
    private String sql = "";
    private FormModel formModel;
    private Context mContext;

    //datetime() ---> sqlite method to get current date and time

    public boolean addForm(Context context,FormModel... forms){
        boolean isFormAdded = false;
        helper = new DBHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
        Log.d("addForm()","addForm");
        try{
            if(forms.length > 1){
                for(int i = 0;i < forms.length;i++){
                    formModel = forms[i];
                    sql = "INSERT INTO " + DBHelper.TABLE_FORMS + "(form_uid,form_name,owner_id,created_date)" +  " VALUES ('" +
                            formModel.getFormUID() + "','" + formModel.getFormName() +
                            "','" + formModel.getOwnerId() + "',datetime()"
                            + ")";
                    sqLiteDatabase.execSQL(sql);
                    Log.d("addForm()","INSERT");
                }
                isFormAdded = true;
            }
            else{
                formModel = forms[0];
                if(isFormNameAvailable(formModel.getFormName().trim())){
                    return false;
                }else{
                    sql = "INSERT INTO " + DBHelper.TABLE_FORMS + "(form_uid,form_name,owner_id,created_date)" +  " VALUES ('" +
                            formModel.getFormUID().trim() + "','" + formModel.getFormName().trim() +
                            "','" + formModel.getOwnerId().trim() + "',datetime()"
                            + ")";
                    sqLiteDatabase.execSQL(sql);
                    isFormAdded = true;
                    Log.d("addForm()","INSERT" + isFormAdded);
                }
            }
        }catch (Exception e){
            isFormAdded = false;
            e.printStackTrace();
        }
        return isFormAdded;
    }

    public boolean isFormNameAvailable(String formName){
        boolean isFormWithSameNameAvailable = false;
        String query = "";
        if(sqLiteDatabase != null){
            query = "SELECT form_name from " + DBHelper.TABLE_FORMS + " WHERE form_name = '" + formName + "'";
            Cursor cursor = sqLiteDatabase.rawQuery(query,null);
            if(!cursor.moveToNext()){
                isFormWithSameNameAvailable = false;
            }else{
                isFormWithSameNameAvailable = true;
            }
        }else{
            return false;
        }

        Log.d("addForm()","isFormNameAvailable" + isFormWithSameNameAvailable);
        return isFormWithSameNameAvailable;
    }
}
