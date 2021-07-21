package com.example.projetct_mb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.projetct_mb.model.*;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    final static String DBNAME = "shop.db";
    final static int DBVERSION =10;
    final static String TYPE = "type";
    final static String ID_TYPE = "IdType";
    final static String NAME_TYPE = "NameType";
    final static String IMG_TYPE = "ImgType";
    public DBhelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //bảng type
        String sql1="CREATE TABLE \"type\" (\n" +
                "\t\"IdType\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"NameType\"\tTEXT,\n" +
                "\t\"ImgType\"\tTEXT\n" +
                ");";
        //bảng customer
        String sql2="CREATE TABLE customer(\n" +
                "    IdCus integer NOT NULL PRIMARY KEY,\n" +
                "    NameCus text,\n" +
                "    BirthCus text,\n" +
                "    PhoneCus text,\n" +
                "    EmailCus text,\n" +
                "    AddressCus text,\n" +
                "    UsernameCus text,\n" +
                "    PassCus text,\n" +
                "    ImgCus blob\n" +
                ");";
        //bảng product
        String sql3="CREATE TABLE product(\n" +
                "    IdPro integer NOT NULL PRIMARY KEY,\n" +
                "    NamePro text,\n" +
                "    DesPro text,\n" +
                "    PricePro real,\n" +
                "    ImgPro text,\n" +
                "    IdType integer,\n" +
                "    CONSTRAINT fk_product_type FOREIGN KEY (IdType) REFERENCES type(IdType)\n" +
                " );";
        //bảng bill
        String sql4="CREATE TABLE bill(\n" +
                "     IdBill integer NOT NULL PRIMARY KEY,\n" +
                "     IdCus integer,\n" +
                "     DayBill text,\n" +
                "     AmountBill integer,\n" +
                "     Total real,\n" +
                "     CONSTRAINT fk_bill_cus FOREIGN KEY (IdCus) REFERENCES customer(IdCus)\n" +
                "     );";
        //bảng detail
        String sql5=" CREATE TABLE billdetail(\n" +
                "     IdDetail integer not null PRIMARY KEY,\n" +
                "     IdPro integer ,\n" +
                "     IdBill integer ,\n" +
                "     Amount integer,\n" +
                "     TotalDetal real,\n" +
                "     CONSTRAINT fk_detail_bill FOREIGN KEY (IdBill) REFERENCES bill(IdBill),\n" +
                "     CONSTRAINT fk_detail_pro FOREIGN KEY (IdPro) REFERENCES product(IdPro)\n" +
                " );";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists type");
        db.execSQL("DROP table if exists customer");
        db.execSQL("DROP table if exists bill");
        db.execSQL("DROP table if exists product");
        db.execSQL("DROP table if exists billdetail");
        onCreate(db);
    }
    //
    //bảng type
    public void addType(type contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NameType", contact.getName()); // Contact Name
        values.put("ImgType", contact.getImg()); // Contact Phone

        // Inserting Row
        db.insert("type", null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public ArrayList<type> getAllType(){
        ArrayList<type> typeList=new ArrayList<>();
        String sql="SELECT* FROM type";
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                type item=new type();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));
                item.setImg(cursor.getString(2));
                typeList.add(item);
            }while (cursor.moveToNext());
        }
        return typeList;
    }

    //
    //bảng product
    public void addProduct(product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NamePro", product.getTensanpham());
        values.put("DesPro", product.getMotasanpham());
        values.put("PricePro", product.getGiasanpham());
        values.put("ImgPro", product.getHinhanhsanpham());
        values.put("IdType", product.getIDSanpham());

        // Inserting Row
        db.insert("product", null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public product getProduct(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query("product",new String[]{"IdPro","NamePro","DesPro","PricePro","ImgPro","IdTypr"},"IdPro"+"=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        product item=new product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),Double.parseDouble(cursor.getString(3)),cursor.getString(4),
                cursor.getString(2),Integer.parseInt(cursor.getString(5)));
        return item;
    }

    public ArrayList<product> getAllProduct(){
        ArrayList<product> productArrayList=new ArrayList<>();
        String sql="SELECT* FROM product";
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                product item=new product();
                item.setID(Integer.parseInt(cursor.getString(0)));
                item.setTensanpham(cursor.getString(1));
                item.setMotasanpham(cursor.getString(2));
                item.setGiasanpham(Double.parseDouble(cursor.getString(3)));
                item.setHinhanhsanpham(cursor.getString(4));
                item.setIDSanpham(Integer.parseInt(cursor.getString(5)));
                productArrayList.add(item);
            }while (cursor.moveToNext());
        }
        return productArrayList;
    }
    public ArrayList<product>getTypeProduct(int i){
        ArrayList<product> productArrayList=new ArrayList<>();
        String sql="SELECT* FROM product WHERE idType="+String.valueOf(i);
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                product item=new product();
                item.setID(Integer.parseInt(cursor.getString(0)));
                item.setTensanpham(cursor.getString(1));
                item.setMotasanpham(cursor.getString(2));
                item.setGiasanpham(Double.parseDouble(cursor.getString(3)));
                item.setHinhanhsanpham(cursor.getString(4));
                item.setIDSanpham(Integer.parseInt(cursor.getString(5)));
                productArrayList.add(item);
            }while (cursor.moveToNext());
        }
        return productArrayList;
    }
    public void addCustomer(customer cus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NameCus", cus.getNameCus());
        values.put("BirthCus", cus.getDateCus());
        values.put("PhoneCus", cus.getPhoneCus());
        values.put("AddressCus", cus.getAddressCus());
        values.put("UsernameCus", cus.getUserCus());
        values.put("PassCus", cus.getPassCus());
        values.put("ImgCus", cus.getImgCus());
        values.put("EmailCus",cus.getEmailCus());
        // Inserting Row
        db.insert("customer", null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM customer WHERE UsernameCus = ?",new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean CheckUserPass(String user,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM customer WHERE UsernameCus = ? and PassCus = ?",new String[]{user,pass});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkPhone(String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM customer WHERE PhoneCus = ?",new String[]{phone});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public customer getCustomer(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query("customer",new String[]{"IdCus","NameCus","BirthCus","PhoneCus","EmailCus","AddressCus","UsernameCus","PassCus","ImgCus"},"IdCus"+"=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        customer item=new customer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getBlob(8));
        return item;
    }
    public customer getCustomerbyUser(String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query("customer",new String[]{"IdCus","NameCus","BirthCus","PhoneCus","EmailCus","AddressCus","UsernameCus","PassCus","ImgCus"},"UsernameCus"+"=?",
                new String[]{user},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        customer item=new customer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(6),cursor.getString(7),
                cursor.getString(3),cursor.getString(2),cursor.getString(5),cursor.getString(4),cursor.getBlob(8));
        return item;
    }
    public ArrayList<customer> getAllCustomer(){
        ArrayList<customer> typeList=new ArrayList<>();
        String sql="SELECT* FROM customer";
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                customer item=new customer();
                item.setIdCus(Integer.parseInt(cursor.getString(0)));
                item.setNameCus(cursor.getString(1));
                item.setDateCus(cursor.getString(2));
                item.setPhoneCus(cursor.getString(3));
                item.setAddressCus(cursor.getString(4));
                item.setUserCus(cursor.getString(5));
                item.setPassCus(cursor.getString(6));
                item.setImgCus(cursor.getBlob(7));
                typeList.add(item);
            }while (cursor.moveToNext());
        }
        return typeList;
    }
    public void deleteCustomer(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("customer", "IdCus" + " = ?",
                new String[] { String.valueOf(i)});
        db.close();
    }
    public int updatePass(String pass, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("PassCus", pass);

        // updating row
        return db.update("customer", values, "UsernameCus" + " = ?",
                new String[] { name });
    }
    public int updateCus(customer cus) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NameCus", cus.getNameCus());
        values.put("BirthCus", cus.getDateCus());
        values.put("AddressCus", cus.getAddressCus());
        values.put("PassCus", cus.getPassCus());
        values.put("ImgCus", cus.getImgCus());
        values.put("EmailCus",cus.getEmailCus());

        // updating row
        return db.update("customer", values, "UsernameCus" + " = ?",
                new String[] { cus.getUserCus() });
    }

    //bill
    public void addBill(bill contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IdCus", contact.getIdCus());
        values.put("DayBill",contact.getDayBill());
        values.put("AmountBill", contact.getAmountBill());
        values.put("Total",contact.getTotal());

        // Inserting Row
        db.insert("bill", null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    //bill detail
    public void addBillDetail(billdetail contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IdPro", contact.getIdPro());
        values.put("IdBill",contact.getIdBill());
        values.put("Amount", contact.getAmount());
        values.put("TotalDetal",contact.getTotalDetail());

        // Inserting Row
        db.insert("billdetail", null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public void deleteBill(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("bill", "IdBill" + " = ?",
                new String[] { String.valueOf(i)});
        db.close();
    }
    public int getBill(){
        int x=0;
        String sql="select * from bill ORDER by IdBill DESC LIMIT 1";
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                x=Integer.parseInt(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return x;
    }
}
