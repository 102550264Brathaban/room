package app.com.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    // val background : ExecutorService = Executors.newFixedThreadPool(2)

     //val shopViewModel : ShopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopViewModel = ViewModelProvider(this).get(ShopViewModel::class.java)

        val shop = Shopping()
        shop.IsBigSale = true
        shop.amount = 100
        shop.name = "lentil"
        shopViewModel.deleteAllShoppings()
        shopViewModel.addShopping(shop)


     shopViewModel.allData.observe(this, Observer {
         it.forEach {
             Log.i("hai", it.name)
             Log.i("hai", it.amount.toString())
         }

     })

    }
}