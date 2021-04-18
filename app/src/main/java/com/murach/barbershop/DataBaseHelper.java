package com.murach.barbershop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_FNAME = "USER_FNAME";
    public static final String COLUMN_USER_LNAME = "USER_LNAME";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PHONE = "USER_PHONE";
    public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_ID = "USER_ID";

    //Constructor
    public DataBaseHelper(Context context) {
        super(context, "BarberShop.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_FNAME + " TEXT, " + COLUMN_USER_LNAME + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PHONE + " TEXT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists userInformation");
    }

    public boolean addNewUser(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_FNAME, userModel.getfName());
        cv.put(COLUMN_USER_LNAME, userModel.getlName());
        cv.put(COLUMN_USER_EMAIL, userModel.getEmail());
        cv.put(COLUMN_USER_PHONE, userModel.getPhoneNumber());
        cv.put(COLUMN_USER_USERNAME, userModel.getUserName());
        cv.put(COLUMN_USER_PASSWORD, userModel.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }

    public List<UserModel> getAllUsers() {

        List<UserModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do {
                int userID = cursor.getInt(0);
                String userFName = cursor.getString(1);
                String userLName = cursor.getString(2);
                String userEmail = cursor.getString(3);
                String userPhoneNumber = cursor.getString(4);
                String userUsername = cursor.getString(5);
                String userPassword = cursor.getString(6);

                UserModel newUser = new UserModel(userID, userFName, userLName, userEmail, userPhoneNumber, userUsername, userPassword);
                returnList.add(newUser);

            } while (cursor.moveToNext());
        } else {
            //failure. do not add anything to the list.
        }

        cursor.close();
        db.close();
        return returnList;
    }

    public boolean checkIfUsernameExists(String username) {

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select * from USER_TABLE where USER_USERNAME = ?", new String[]{username});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsernameAndPassword(String username, String password) {

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select * from USER_TABLE where USER_USERNAME = ? and USER_PASSWORD = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {

            return true;

        } else {

            return false;
        }
    }

    public String getUserId(String username, String password){

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select USER_ID from USER_TABLE where USER_USERNAME = ? and USER_PASSWORD = ?",new String[]{username, password});
        int userID = cursor.getInt(0);
        String userId = String.valueOf(userID);

        return userId;
    }

    public String getUserFName(String username, String password){

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select USER_FNAME from USER_TABLE where USER_USERNAME = ? and USER_PASSWORD = ?",new String[]{username, password});
        String userFName = cursor.getString(1);

        return userFName;
    }

    public String getUserLName(String username, String password){

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select USER_LNAME from USER_TABLE where USER_USERNAME = ? and USER_PASSWORD = ?",new String[]{username, password});
        String userLName = cursor.getString(2);

        return userLName;
    }
}
