package com.example.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sunflower.data.GardenPlantingRepository

/**
 * 文件名: GardenPlantingListViewModelFactory
 * 创建者: Gu
 * 创建日期: 2020/5/29 7:55
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class GardenPlantingListViewModelFactory(
    private val repository: GardenPlantingRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CASE")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}