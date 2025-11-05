package namle.tutorial.gymtracer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import namle.tutorial.gymtracer.data.local.entity.MuscleGroupEntity

@Dao
interface MuscleGroupDao {
    @Insert
    suspend fun insert(entity: MuscleGroupEntity)

    @Query("SELECT * FROM muscle_group")
    fun getAll(): Flow<List<MuscleGroupEntity>>
}