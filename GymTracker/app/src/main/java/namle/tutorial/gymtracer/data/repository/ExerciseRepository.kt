package namle.tutorial.gymtracer.data.repository

import namle.tutorial.gymtracer.data.local.dao.ExerciseDao
import namle.tutorial.gymtracer.data.local.entity.ExerciseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepository @Inject constructor(private val exerciseDao: ExerciseDao) {
    suspend fun addExercise(exerciseEntity: ExerciseEntity){
        exerciseDao.insertExercise(exerciseEntity)
    }

    fun getAllTest() = exerciseDao.getAllExercise()
}