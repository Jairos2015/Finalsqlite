package com.app.mttc.finalsqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseCreation(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val user_table = "CREATE TABLE ${DatabaseColumns.TABLE_NAME}  (${DatabaseColumns.USER_NAME} TEXT, ${DatabaseColumns.USER_EMAIL} TEXT, ${DatabaseColumns.USER_PASS} TEXT)"

    val user_drop = "DROP TABLE IF EXISTS ${DatabaseColumns.TABLE_NAME}"
    override fun onCreate(db: SQLiteDatabase?) {
        // ? llamada segura o !! non-null asserted
        db!!.execSQL(user_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // ? llamada segura o !! non-null asserted
        db!!.execSQL(user_drop)
        onCreate(db)
    }

    companion object{
        const val DB_NAME = "users.db"
        const val DB_VERSION = 1
    }

}