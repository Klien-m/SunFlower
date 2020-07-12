package com.example.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunflower.data.GardenPlantingRepository
import com.example.sunflower.data.PlantAndGardenPlantings
import com.example.sunflower.data.PlantRepository
import kotlinx.coroutines.launch

/**
 * 文件名: PlantDetailViewModel
 * 创建者: Gu
 * 创建日期: 2020/5/28 22:10
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantDetailViewModel(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModel() {
    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
    val plant = plantRepository.getPlant(plantId)

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }
}