package namle.tutorial.gymtracer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TestEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao

}