package namle.tutorial.gymtracer.data.repository

import namle.tutorial.gymtracer.data.local.dao.ExerciseDao
import namle.tutorial.gymtracer.data.local.dao.MuscleGroupDao
import namle.tutorial.gymtracer.data.local.entity.ExerciseEntity
import namle.tutorial.gymtracer.data.local.entity.MuscleGroupEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MuscleGroupRepository @Inject constructor(private val muscleGroupDao: MuscleGroupDao) {
    suspend fun add(muscleGroupEntity: MuscleGroupEntity){
        muscleGroupDao.insert(muscleGroupEntity)
    }

    fun getAll() = muscleGroupDao.getAll()
}