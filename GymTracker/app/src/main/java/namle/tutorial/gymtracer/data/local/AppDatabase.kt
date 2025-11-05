package namle.tutorial.gymtracer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import namle.tutorial.gymtracer.data.local.dao.ExerciseDao
import namle.tutorial.gymtracer.data.local.dao.MuscleGroupDao
import namle.tutorial.gymtracer.data.local.dao.TestDao
import namle.tutorial.gymtracer.data.local.entity.ExerciseEntity
import namle.tutorial.gymtracer.data.local.entity.MuscleGroupEntity
import namle.tutorial.gymtracer.data.local.entity.TestEntity

@Database(entities = [TestEntity::class,
    ExerciseEntity::class,
    MuscleGroupEntity::class], version = 3, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun muscleGroupDao(): MuscleGroupDao

}