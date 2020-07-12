package com.example.sunflower

import android.os.Bundle
import android.view.*
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.sunflower.adapters.PlantAdapter
import com.example.sunflower.databinding.FragmentPlantListBinding
import com.example.sunflower.utilities.InjectorUtils
import com.example.sunflower.viewmodels.PlantListViewModel

/**
 * 文件名: PlantListFragment
 * 创建者: Gu
 * 创建日期: 2020/5/29 9:49
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantListFragment : Fragment() {

    private val viewModel: PlantListViewModel by viewModels {
        InjectorUtils.providePlantListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = PlantAdapter()
        binding.plantList.adapter = adapter
        subscribUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                updateData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribUi(adapter: PlantAdapter) {
        viewModel.plants.observe(viewLifecycleOwner) { plants ->
            adapter.submitList(plants)
        }
    }

    private fun updateData() {
        with(viewModel) {
            if (isFiltered()) {
                clearGrowZoneNumber()
            } else {
//                val growZoneNumbers: Int[] = intArrayOf(2, 3, 4, 5, 7, 8, 9, 10, 11)
//                var numberPicker: NumberPicker = NumberPicker(requireContext())
//                numberPicker.displayedValues(growZoneNumbers)
//                numberPicker.minValue = 1
//                numberPicker.maxValue = 9
//                numberPicker.value = 1
//                numberPicker.wrapSelectorWheel = true
//                numberPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

                setGrowZoneNumber(9)
            }
        }
    }
}