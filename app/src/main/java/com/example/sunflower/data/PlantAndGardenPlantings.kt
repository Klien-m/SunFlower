package com.example.sunflower.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * 文件名: PlantAndGardenPlantings
 * 创建者: Gu
 * 创建日期: 2020/5/28 19:47
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
data class PlantAndGardenPlantings(
    @Embedded
    val plant: Plant,

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantings: List<GardenPlanting> = emptyList()
)