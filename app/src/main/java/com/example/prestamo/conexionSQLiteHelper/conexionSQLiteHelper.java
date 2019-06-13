//package com.example.prestamo.conexionSQLiteHelper;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import com.example.ejemplosqlite.utilidades.utilidades;
//import com.example.prestamo.Entidades.Entidad_Prestamos;
//
//public class conexionSQLiteHelper extends SQLiteOpenHelper {
//    public conexionSQLiteHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
////    @Override
////    public void onCreate(SQLiteDatabase db) {
////        db.execSQL(Entidad_Prestamos.CREATE_TABLA_USUARIO);
////    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS usuario");
//        onCreate(db);
//    }
//}
