package com.example.sunflower.data

/**
 * 文件名: PlantRepository
 * 创建者: Gu
 * 创建日期: 2020/5/28 22:11
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantRepository private constructor(private val plantDao: PlantDao) {

    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {
        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao) =
            instance ?: synchronized(this) {
                instance ?: PlantRepository(plantDao).also {
                    instance = it
                }
            }
    }
}