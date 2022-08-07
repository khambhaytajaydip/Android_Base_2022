package com.jai.base.di

import android.content.Context
import androidx.room.Room
import com.jai.base.data.source.LocalDb
import com.jai.base.data.source.dao.TestTableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    @Singleton
    internal fun provideDb(context: Context): LocalDb {
        return Room.databaseBuilder(context, LocalDb::class.java, "Adani_DB")
//            .fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
//            .addMigrations(MIGRATION_1_2)
//            .createFromAsset("spotbill.db")
            .build()
    }
    //    val MIGRATION_1_2 = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("ALTER TABLE route ADD COLUMN test TEXT NOT NULL DEFAULT 'absc'")
//        }
//    }

    @Provides
    @Singleton
    internal fun provideTrackSession(context: Context): TestTableDao {
        return provideDb(context).testTableDao()
    }
}