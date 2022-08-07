package com.jai.base.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Jaydeep Khambhayta
 */
@Entity(tableName = "testTable")
data class TestTable(
    @PrimaryKey(autoGenerate = false)
    val INDEXID: Int,
    val MRIDNO :String
)
