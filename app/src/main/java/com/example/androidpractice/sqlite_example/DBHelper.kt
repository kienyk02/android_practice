package com.example.androidpractice.sqlite_example

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context) : SQLiteOpenHelper(context, "MyDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable =
            "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT, $AGE INTEGER)"
        db?.execSQL(createUserTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun get() {
        val cursor = readableDatabase.query(TABLE_NAME,null,null,null,null,null,null)
        cursor.let {
            val id = cursor.getColumnIndex(ID)
            val name = cursor.getColumnIndex(NAME)
            val age = cursor.getColumnIndex(AGE)
            if (cursor.moveToFirst()){
                do {
                    val user = User(
                        cursor.getInt(id),
                        cursor.getString(name),
                        cursor.getInt(age)
                    )
                    Log.d("user", user.toString())
                }while (cursor.moveToNext())
            }
        }
    }

    fun add(user: User) {
        val contentValue = ContentValues()
        contentValue.put(NAME, user.name)
        contentValue.put(AGE, user.age)
        writableDatabase.insert(TABLE_NAME, null, contentValue)
        writableDatabase.close()
    }

    fun update(user: User){
        val contentValue = ContentValues()
        contentValue.put(NAME, user.name)
        contentValue.put(AGE, user.age)
        writableDatabase.update(TABLE_NAME,  contentValue, "$ID = ${user.id}", null)
        writableDatabase.close()
    }

    fun delete(userId:Int){
        writableDatabase.delete(TABLE_NAME, "$ID = ?", arrayOf(userId.toString()))
        writableDatabase.close()
    }

    companion object{
        val ID = "id"
        val NAME = "name"
        val AGE = "age"
        val TABLE_NAME = "users"
    }
}
