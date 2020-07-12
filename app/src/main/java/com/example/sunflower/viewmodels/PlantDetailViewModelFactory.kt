package com.example.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sunflower.data.GardenPlantingRepository
import com.example.sunflower.data.PlantRepository

/**
 * 文件名: PlantDetailViewModelFactory
 * 创建者: Gu
 * 创建日期: 2020/5/29 8:01
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantDetailViewModelFactory(
    private val plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantRepository, gardenPlantingRepository, plantId) as T
    }
}