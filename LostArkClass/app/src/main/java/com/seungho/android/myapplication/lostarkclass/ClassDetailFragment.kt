package com.seungho.android.myapplication.lostarkclass

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
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.databinding.FragmentClassDetailBinding
import com.seungho.android.myapplication.lostarkclass.utills.InjectorUtils
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassDetailViewModel

class ClassDetailFragment: Fragment() {

    private val args: ClassDetailFragmentArgs by navArgs()

    private val classDetailViewModel: ClassDetailViewModel by viewModels {
        InjectorUtils.provideClassDetailViewModelFactory(requireActivity(), args.classId)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentClassDetailBinding>(
            inflater, R.layout.fragment_class_detail, container, false
        ).apply {
            viewModel = classDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun add(classs: Classs?) {
                    classs?.let {
                        hideAppBarFab(fab)
                        classDetailViewModel.addClassToFavorite()
                        Snackbar.make(root, "Added class to Favorite", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
            var isToolbarShown = false

            classDetailScrollview.setOnScrollChangeListener(
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
                when(item.itemId) {
                    R.id.action_share -> {
                        createShareIntnet()
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
    private fun createShareIntnet() {
        val shareText = classDetailViewModel.classs.value.let { classs ->
            if (classs == null) {
                ""
            } else {
                "Check out the {classs.name} plant in the Android..."
            }
        }
        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
            .setText(shareText)
            .setType("text/classs")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    interface Callback {
        fun add(classs: Classs?)
    }
}