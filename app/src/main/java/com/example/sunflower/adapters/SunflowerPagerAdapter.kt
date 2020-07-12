package com.example.sunflower.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflower.GardenFragment
import com.example.sunflower.PlantListFragment
import java.lang.IndexOutOfBoundsException

/**
 * 文件名: SunflowerPagerAdapter
 * 创建者: Gu
 * 创建日期: 2020/5/28 19:39
 * 邮箱: 1203249465@qq.com
 * 描述:
 */

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MY_GARDEN_PAGE_INDEX to { GardenFragment() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}