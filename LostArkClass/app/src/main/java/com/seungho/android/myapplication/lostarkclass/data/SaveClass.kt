package com.seungho.android.myapplication.lostarkclass.data

import androidx.room.*

@Entity(
    tableName = "save_class",
    foreignKeys = [
        ForeignKey(entity = Classs::class, parentColumns = ["classId"], childColumns = ["classs_id"])
    ],
    indices = [Index("classs_id")]
)
data class SaveClass (
    @ColumnInfo(name = "classs_id") val classId: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "classsId")
    var saveClassId: Long = 0
}