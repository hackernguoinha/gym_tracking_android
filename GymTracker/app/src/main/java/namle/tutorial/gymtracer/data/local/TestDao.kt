package namle.tutorial.gymtracer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Insert
    suspend fun insertTest(test: TestEntity)

    @Query("SELECT * FROM test")
    fun getAllTest(): Flow<List<TestEntity>>
}