package com.example.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sunflower.data.GardenPlantingRepository
import com.example.sunflower.data.PlantAndGardenPlantings

/**
 * 文件名: GardenPlantingListViewModel
 * 创建者: Gu
 * 创建日期: 2020/5/29 7:53
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}