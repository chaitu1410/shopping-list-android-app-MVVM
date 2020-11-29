package com.chaittnyashinde.shoppingcart.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 2
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE shopping_items "
                            + "ADD COLUMN item_taken INTEGER DEFAULT 0 NOT NULL"
                )
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ShoppingDatabase::class.java,
            "ShoppingDB.db"
        )
            .addMigrations(MIGRATION_1_2)
            .build()


    }
}