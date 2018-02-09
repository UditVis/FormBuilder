package inc.peace.formbuilder.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Udit on 2/10/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "fmdb";

    public static final String TABLE_FORMS = "form";
    public static final String TABLE_FIELDS = "fields";
    public static final String TABLE_FORMFIELD = "form_fields_table";
    public static final String TABLE_USERTABLE = "users";
    public static final String TABLE_FORMUSER = "form_user_table";



    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(getCreateTableQuery(TABLE_FIELDS));
        sqLiteDatabase.execSQL(getCreateTableQuery(TABLE_FORMS));
        sqLiteDatabase.execSQL(getCreateTableQuery(TABLE_FORMFIELD));
        sqLiteDatabase.execSQL(getCreateTableQuery(TABLE_FORMFIELD));
        sqLiteDatabase.execSQL(getCreateTableQuery(TABLE_FORMUSER));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FIELDS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMFIELD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMFIELD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMUSER);

        onCreate(sqLiteDatabase);
    }
    //fieldName;
    /*private String fieldReference;
    private String fieldQuestion;
    private String fieldType;
    private JSONObject fieldProperties;
    private boolean isRequired;*/

    private String getCreateTableQuery(String tableName){
        String query = "";
        switch (tableName){
            case TABLE_FORMS:
                query = "CREATE TABLE IF NOT EXISTS form (id INTEGER PRIMARY KEY AUTOINCREMENT,form_uid TEXT NOT NULL,form_name TEXT NOT NULL,fields_id TEXT,owner_id TEXT,created_date DATETIME,modified_date DATETIME)";
                break;
            case TABLE_FIELDS:
                query = "CREATE TABLE IF NOT EXISTS field (id INTEGER PRIMARY KEY AUTOINCREMENT, field_uid TEXT NOT NULL,field_name TEXT NOT NULL,field_ref TEXT NOT NULL,field_que TEXT NOT NULL,field_type TEXT NOT NULL,is_required TEXT,field_prop TEXT NOT NULL,form_rel_id TEXT NOT NULL,created_date DATETIME,modified_date DATETIME)";
                break;
            case TABLE_FORMFIELD:
                query = "CREATE TABLE IF NOT EXISTS form_fields_table (id INTEGER PRIMARY KEY AUTOINCREMENT,form_id TEXT NOT NULL,field_id TEXT NOT NULL,created_date DATETIME,modified_date DATETIME)";
                break;
            case TABLE_USERTABLE:
                query = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT,userid TEXT NOT NULL,username TEXT NOT NULL,password TEXT NOT NULL,email TEXT NOT NULL,phone TEXT NOT NULL,created_date DATETIME,modified_date DATETIME,form_rel_id TEXT)";
                break;
            case TABLE_FORMUSER:
                query = "CREATE TABLE IF NOT EXISTS form_user_table (id INTEGER PRIMARY KEY AUTOINCREMENT,form_id TEXT NOT NULL,user_id TEXT NOT NULL,created_date DATETIME,modified_date DATETIME)";
                break;
        }
        return query;
    }
}
