package gridview.sample.test.lktailor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.id.content;
import static android.R.id.list;

/**
 * Created by IT sohit on 3/27/2018.
 */

public class LkDatabaseClass extends SQLiteOpenHelper {
        public static final String DATABASE_Name = "LKDatabase.db";
        public static final int DATABASE_VERSION = 1;
        public static final String TABLE_NAME = "LkTable";
        SQLiteDatabase ds;

    public LkDatabaseClass(Context context) {
        super(context,DATABASE_Name,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table "+TABLE_NAME+"(ID INT AUTO INCREMENT,Email varchar(25)" +
                    ",Password varchar(25),Username varchar(25),PhoneNo varchar(10),Address varchar(35),Country varchar(15))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public Boolean Login(String email,String pass){
        ds = this.getWritableDatabase();
           Cursor c = ds.rawQuery("select * from LkTable where Email=? and Password=?",new String []{email,pass});
           c.moveToFirst();
        try {
            if (c.getString(1).equals(email) && c.getString(2).equals(pass))
                return false;
        }catch(Exception e){
            return true;
        }
        return true;
    }
    public Boolean registration(String email,String pass,String unm,String pno,String address,String country){
        ds = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
         contentValues.put("Email",email);
         contentValues.put("Password",pass);
         contentValues.put("Username",unm);
         contentValues.put("PhoneNo",pno);
         contentValues.put("Address",address);
         contentValues.put("Country",country);
      long l =  ds.insert(TABLE_NAME,"id = ?",contentValues);
        if(l==-1)
                return true;
        else
            return false;
    }
    public Boolean getCheckEmail(String email){
            ds = this.getReadableDatabase();
          Cursor c=  ds.rawQuery("select * from LkTable where Email=?",new String[]{email});
            c.moveToNext();
        try{
            if(c.getString(1).equals(email))
                return false; }
        catch(Exception e){
            return true;
        }
        return true;
    }
    public Boolean updatePassword(String email,String pass){
            ds = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
                contentValues.put("Password",pass);
         if(ds.update(TABLE_NAME,contentValues,"Email = ?",new String[]{email})==-1)
                    return true;
        return false;
    }
}
