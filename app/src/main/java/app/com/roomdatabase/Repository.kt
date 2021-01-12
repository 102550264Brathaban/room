package app.com.roomdatabase

import androidx.lifecycle.LiveData

class Repository (private val shopdao : ShoppingDao) {

    val shoppings : LiveData<List<Shopping>> = shopdao.ShowShopping()


    suspend fun addShopping(shopping: Shopping)
    {

        shopdao.SaveShopping(shopping)
    }

    suspend fun deleteAll()
    {
        shopdao.DeleteAll()
    }

    suspend fun getAllData() : LiveData<List<Shopping>>
    {
        return shoppings
    }
}

