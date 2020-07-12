package com.example.sunflower.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.sunflower.data.PlantRepository

/**
 * 文件名: PlantListViewModelFactory
 * 创建者: Gu
 * 创建日期: 2020/5/29 7:42
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantListViewModelFactory(
    private val repository: PlantRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return PlantListViewModel(repository, handle) as T
    }
}