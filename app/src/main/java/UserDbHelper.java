import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * Created by azfardaher on 09/04/2017.
 */

public abstract class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "USERINFO_DB";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_QUERY = "CREATE TABLE " + AppInfo.UserApp.TABLE_NAME +"(" + AppInfo.UserApp.APP_EVENT +"TEXT,"+ AppInfo.UserApp.APP_TIME +"TEXT," + AppInfo.UserApp.APP_DETAIL+"TEXT);";
    public UserDbHelper(Context context) {



        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e ("DATABASE OPERATIONS", "Database opened.");
    }

    public void OnCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_QUERY);
        Log.e ("DATABASE OPERATIONS", "Table created.");
    }

    public void addInfo(String appevent, String apptime, String appdetail, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppInfo.UserApp.APP_EVENT, appevent);
        contentValues.put(AppInfo.UserApp.APP_TIME, apptime);
        contentValues.put(AppInfo.UserApp.APP_DETAIL, appdetail);
        db.insert(AppInfo.UserApp.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "one row inserted.");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }
}
