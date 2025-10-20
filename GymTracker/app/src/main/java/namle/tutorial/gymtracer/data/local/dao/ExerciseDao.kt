package namle.tutorial.gymtracer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import namle.tutorial.gymtracer.data.local.entity.ExerciseEntity

@Dao
interface ExerciseDao {
    @Insert
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Query("SELECT * FROM exercise")
    fun getAllExercise(): Flow<List<ExerciseEntity>>
}