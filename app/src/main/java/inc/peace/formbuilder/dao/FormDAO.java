package inc.peace.formbuilder.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import inc.peace.formbuilder.helper.DBHelper;
import inc.peace.formbuilder.model.FormModel;

/**
 * Created by Udit on 2/10/2018.
 */

public class FormDAO {
    private DBHelper helper;
    private SQLiteDatabase sqLiteDatabase;
    private String sql = "";
    private FormModel formModel
    public void addForm(Context context,FormModel... forms){
        helper = new DBHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
        try{
            if(forms.length > 1){
                for(int i = 0;i < forms.length;i++){
                    formModel = forms[i];
                    sql = "INSERT INTO " + DBHelper.TABLE_FORMS + "(form_uid,form_name,owner_id,created_date)" +  " VALUES ('" +
                            formModel.getFormUID() + "','" + formModel.getFormName() +
                            "','" + formModel.getOwnerId() + "',NOW()"
                            + ")";
                    sqLiteDatabase.execSQL(sql);
                }
            }
            else{
                formModel = forms[0];
                sql = "INSERT INTO " + DBHelper.TABLE_FORMS + "(form_uid,form_name,owner_id,created_date)" +  " VALUES ('" +
                        formModel.getFormUID() + "','" + formModel.getFormName() +
                        "','" + formModel.getOwnerId() + "',NOW()"
                        + ")";
                sqLiteDatabase.execSQL(sql);
            }
        }catch (Exception e){e.printStackTrace();}
    }
}
