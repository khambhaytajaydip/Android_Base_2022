package com.jai.base.data.source
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jai.base.data.model.TestTable
import com.jai.base.data.source.dao.TestTableDao
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
@Singleton
@Database(entities = [TestTable::class], version = 1, exportSchema = false)
@TypeConverters
abstract class LocalDb : RoomDatabase() {
    abstract fun testTableDao(): TestTableDao
}