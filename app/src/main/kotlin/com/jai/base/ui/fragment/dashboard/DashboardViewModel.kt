package com.jai.base.ui.fragment.dashboard

import com.jai.base.data.DataManager
import com.jai.base.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Jaydeep Khambhayta
 */
class DashboardViewModel @Inject constructor(val dataManager: DataManager): BaseViewModel() {
    var data = ""
}