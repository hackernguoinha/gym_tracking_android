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
    MuscleGroupEntity::class], version = 4, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun muscleGroupDao(): MuscleGroupDao

//    companion object {
//        // 🔹 Migration từ 1 → 3
//        val MIGRATION_1_3 = object : Migration(1, 3) {
//            override fun migrate(db: SupportSQLiteDatabase) {
//                db.execSQL(
//                    "ALTER TABLE exercise ADD COLUMN age INTEGER NOT NULL DEFAULT 0"
//                )
//
//                db.execSQL(
//                    "ALTER TABLE muscle_group ADD COLUMN age INTEGER NOT NULL DEFAULT 0"
//                )
//            }
//        }
//    }
}