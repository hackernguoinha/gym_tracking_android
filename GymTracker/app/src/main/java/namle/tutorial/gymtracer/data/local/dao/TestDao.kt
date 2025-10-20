package namle.tutorial.gymtracer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import namle.tutorial.gymtracer.data.local.entity.TestEntity

@Dao
interface TestDao {
    @Insert
    suspend fun insertTest(test: TestEntity)

    @Query("SELECT * FROM test")
    fun getAllTest(): Flow<List<TestEntity>>
}