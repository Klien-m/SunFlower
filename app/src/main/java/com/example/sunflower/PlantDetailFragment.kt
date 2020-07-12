package com.example.sunflower

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sunflower.utilities.InjectorUtils
import com.example.sunflower.viewmodels.PlantDetailViewModel
import androidx.navigation.fragment.navArgs
import com.example.sunflower.data.Plant
import com.example.sunflower.databinding.FragmentPlantDetailBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * 文件名: PlantDetailFragment
 * 创建者: Gu
 * 创建日期: 2020/5/28 22:36
 * 邮箱: 1203249465@qq.com
 * 描述:
 */
class PlantDetailFragment : Fragment() {

    private val args: PlantDetailFragmentArgs by navArgs()

    private val plantDetailViewModel: PlantDetailViewModel by viewModels {
        InjectorUtils.providePlantDetailViewModelFactory(requireActivity(), args.plantId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater, R.layout.fragment_plant_detail, container, false
        ).apply {
            viewModel = plantDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun add(plant: Plant?) {
                    plant?.let {
                        hideAppBarFab(fab)
                        plantDetailViewModel.addPlantToGarden()
                        Snackbar.make(root, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }

            var isToolbarShown = false

            plantDetailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                    val shouldShowToolbar = scrollY > toolbar.height

                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar
                        appbar.isActivated = shouldShowToolbar
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }
            )

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    @Suppress("DEPRECATION")
    private fun createShareIntent() {
        val shareText = plantDetailViewModel.plant.value.let { plant ->
            if (plant == null) {
                ""
            } else {
                getString(R.string.share_text_plant, plant.name)
            }
        }
        val shareIntent = activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        }
        startActivity(shareIntent)
    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    interface Callback {
        fun add(plant: Plant?)
    }
}