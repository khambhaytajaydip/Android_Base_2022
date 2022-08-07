package com.jai.base.ui.fragment.dashboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jai.base.R
import com.jai.base.databinding.FragmentDashboardBinding
import com.jai.base.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Jaydeep Khambhayta
 */
@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>() {
    @Inject
    lateinit var dashboardViewModel: DashboardViewModel

    override fun getLayoutId() = R.layout.fragment_dashboard

    override fun getViewModel() = dashboardViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("jai", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        // code here
        mViewDataBinding.btnMYRoute.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_myRouteFragment)
        }
        mViewDataBinding.textView2.text =dashboardViewModel.data

        if(dashboardViewModel.data.isEmpty()){
            dashboardViewModel.data  = "Empty DATA"
        }else{
            dashboardViewModel.data  = "Not Empty DATA "
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("jai", "onCreate")
        super.onCreate(savedInstanceState)


    }

    override fun onResume() {
        Log.d("jai", "onResume")
        super.onResume()
    }

    override fun onDestroyView() {
        Log.d("jai", "On destroy called")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("jai", "onDetach")
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        Log.d("jai", "onAttach")
        super.onAttach(context)
    }

    override fun onDestroy() {
        Log.d("jai", "onDestroy")
        super.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("jai", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}