package com.example.sunflower.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.sunflower.data.AppDatabase
import com.example.sunflower.data.GardenPlantingRepository
import com.example.sunflower.data.PlantRepository
import com.example.sunflower.viewmodels.GardenPlantingListViewModelFactory
import com.example.sunflower.viewmodels.PlantDetailViewModelFactory
import com.example.sunflower.viewmodels.PlantListViewModelFactory

object InjectorUtils {

    private fun getPlantRepository(
        context: Context
    ): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(
                context.applicationContext
            ).plantDao()
        )
    }

    private fun getGardenPlantingRepository(
        context: Context
    ): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(
                context.applicationContext
            ).gardenPlantingDao()
        )
    }

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return GardenPlantingListViewModelFactory(repository)
    }

    fun providePlantListViewModelFactory(
        fragment: Fragment
    ): PlantListViewModelFactory {
        val repository = getPlantRepository(fragment.requireContext())
        return PlantListViewModelFactory(repository, fragment)
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(getPlantRepository(context),
                getGardenPlantingRepository(context), plantId)
    }
}