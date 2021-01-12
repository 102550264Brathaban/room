package app.com.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi



//@Database(entities = [(Shopping::class)], version = 1)
//abstract class AppDb : RoomDatabase() {

//   abstract fun ShopDao() : ShoppingDao
//}
@Database(entities = ([Shopping::class]),version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase()
{
   abstract fun ShopDao() : ShoppingDao


   companion object {
       @Volatile
       private var INSTANCE: AppDb? = null


       fun getDb(context: Context): AppDb {
           val tempInstance = INSTANCE
           if (tempInstance != null) {
               return tempInstance
           }
           synchronized(this) {
               val instance =
                   Room.databaseBuilder(context.applicationContext, AppDb::class.java, "Sopping")
                       .build()
               INSTANCE = instance
               return instance

           }
       }
   }


}

