package com.sprout.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sprout.net.Injection
import com.sprout.base.BaseViewModel
import com.sprout.model.HomeData
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel(Injection.repository) {

    var homeData:MutableLiveData<HomeData> = MutableLiveData()

    /**
     * 加载首页数据
     */
    fun loadHomeData(){
        viewModelScope.launch {
            var result = repository.getHome()
            homeData.postValue(result.data)
        }
    }

}