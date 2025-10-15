package namle.tutorial.gymtracer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class TestEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = ""
)