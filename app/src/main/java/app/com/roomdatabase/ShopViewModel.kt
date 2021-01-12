package app.com.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ShopViewModel (application: Application): AndroidViewModel(application){

    var allData : LiveData<List<Shopping>>
   private var repository : Repository
   init {
       val shoppingDao = AppDb.getDb(application).ShopDao()
        repository = Repository(shoppingDao)
         allData = repository.shoppings
   }

    fun addShopping(shopping: Shopping)
    {
        viewModelScope.launch{
            repository.addShopping(shopping)
        }
    }
    fun deleteAllShoppings()
    {
      viewModelScope.launch {
          repository.deleteAll()
      }
    }




}