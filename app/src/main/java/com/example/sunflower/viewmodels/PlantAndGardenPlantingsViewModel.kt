package com.example.sunflower.viewmodels

import com.example.sunflower.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

/**
 * 文件名: PlantAndGardenPlantingsViewModel
 * 创建者: Gu
 * 创建日期: 2020/5/28 20:59
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlanting.lastWateringDate.time)
    val wateringInterval get() = plant.wateringInterval
    val imageUrl get() = plant.imageUrl
    val plantName get() = plant.name
    val plantDateString: String = dateFormat.format(gardenPlanting.plantDate.time)
    val plantId get() = plant.plantId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.CHINA)
    }
}