package com.example.supermarket;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SuperMarketSource {
    private SQLiteDatabase database;
    private SuperMarketDBHelper dbHelper;

    public SuperMarketSource(Context context){
        dbHelper = new SuperMarketDBHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }
    public boolean insertSuperMarket(SuperMarket c){
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("superMarketName",c.getSuperMarketName());
            initialValues.put("superMarketAddress",c.getSuperMarketAddress());


            didSucceed = database.insert("contact",null,initialValues)>0;
        }
        catch (Exception e) {
        }
        return didSucceed;
    }

    public boolean updateSuperMarket(SuperMarket c) {
        boolean didSucceed = false;
        try {
            ContentValues updateValues = new ContentValues();
            int rowId = c.getId();
            updateValues.put("contactName",c.getSuperMarketName());
            updateValues.put("streetAddress",c.getSuperMarketAddress());

            int rowsUpdated = database.update("superMarket",updateValues,"_id="+ rowId,
                    null);

            if(rowsUpdated >0){
                didSucceed = true;
            }
        }
        catch (Exception e) {
        }
        return didSucceed;
    }
}