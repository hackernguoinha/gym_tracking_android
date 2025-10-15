package namle.tutorial.gymtracer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TestDao {
    @Insert
    suspend fun insertTest(test: TestEntity)

    @Query("SELECT * FROM test")
    suspend fun getAllTest(): List<TestEntity>
}