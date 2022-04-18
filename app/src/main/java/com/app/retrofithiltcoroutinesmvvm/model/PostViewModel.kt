package com.app.retrofithiltcoroutinesmvvm.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.retrofithiltcoroutinesmvvm.util.Resource
import com.app.retrofithiltcoroutinesmvvm.item.FreeData
import com.app.retrofithiltcoroutinesmvvm.repository.PostRepository
import com.app.retrofithiltcoroutinesmvvm.util.ResponseCodeCheck
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository,
) : ViewModel() {

    val freeDataSend: MutableLiveData<Resource<FreeData>> = MutableLiveData()

    @Inject
    lateinit var responseCodeCheck: ResponseCodeCheck

    init {
        getData()
    }

    private fun getData() {

        freeDataSend.postValue(Resource.loading(null))
        var response: Response<FreeData>
        CoroutineScope(Dispatchers.IO).launch {
            try {

                /*if (repository.getData().code() == 200) {
                    if (repository.getData().isSuccessful) {
                        response = repository.getData()
                        freeDataSend.postValue(Resource.success(response.body()))
                    } else {
                        freeDataSend.postValue(
                            Resource.error(
                                "No data found please try again",
                                null
                            )
                        )
                    }
                } else {
                    freeDataSend.postValue(Resource.error("No data found please try again", null))
                }*/

                response = repository.getData()
                freeDataSend.postValue(responseCodeCheck.getResponseResult(response))

            } catch (e: Exception) {
                Log.d("data_information", e.toString())
                freeDataSend.postValue(Resource.error("No data found please try again", null))
            }
        }

    }

}