package namle.tutorial.gymtracer.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TestEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao

    companion object{
        @Volatile
        private var instant: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instant ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gym_tracer_db"
                ).build()
                instant = instance
                instance
            }
        }
    }
}