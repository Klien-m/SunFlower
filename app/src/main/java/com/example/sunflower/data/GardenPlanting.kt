package com.example.sunflower.data

import androidx.room.*
import java.util.*

/**
 * 文件名: GardenPlanting
 * 创建者: Gu
 * 创建日期: 2020/5/28 20:01
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
@Entity(
    tableName = "garden_plantings",
    foreignKeys = [
        ForeignKey(
            entity = Plant::class, parentColumns = ["id"],
            childColumns = ["plant_id"]
        )],
    indices = [Index("plant_id")]
)
data class GardenPlanting(
    @ColumnInfo(name = "plant_id") val plantId: String,
    @ColumnInfo(name = "plant_date") val plantDate: Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "last_watering_data")
    val lastWateringDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var gardenPlantingId: Long = 0
}