package com.example.mytodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    // ItemDaoインターフェースをクラスのプロパティとして定義
    abstract fun todoDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: TodoDatabase? = null

        // データベースインスタンスを取得するメソッド
        fun getDatabase(context: Context): TodoDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context, TodoDatabase::class.java, "todo_database"
                ).build().also { Instance = it }
            }
        }
    }
}