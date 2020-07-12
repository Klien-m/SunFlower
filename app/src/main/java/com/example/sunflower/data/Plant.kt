package com.example.sunflower.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

/**
 * 文件名: Plant
 * 创建者: Gu
 * 创建日期: 2020/5/28 19:53
 * 邮箱: 1203249465@qq.com
 * 描述:
 */

@Entity(tableName = "plants")
data class Plant (
    @PrimaryKey @ColumnInfo(name = "id") val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,  // how often the plant should be watered, in days
    val imageUrl: String = ""
) {
    fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar) =
        since > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name
}