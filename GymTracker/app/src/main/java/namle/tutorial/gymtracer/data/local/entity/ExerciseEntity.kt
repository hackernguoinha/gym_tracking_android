package namle.tutorial.gymtracer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val picture: String = "",
    val note: String = "",
    val muscleGroupId: Int = 0,
    val status: Int = 0
)

