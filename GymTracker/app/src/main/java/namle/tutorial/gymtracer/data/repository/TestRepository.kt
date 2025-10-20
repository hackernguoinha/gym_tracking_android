package namle.tutorial.gymtracer.data.repository

import namle.tutorial.gymtracer.data.local.dao.TestDao
import namle.tutorial.gymtracer.data.local.entity.TestEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton //chỉ gọi 1 lần để dùng, những thằng gọi lại sẽ sử dụng chung data
class TestRepository @Inject constructor(private val testDao: TestDao) {
    suspend fun addTest(name: String){
        val test = TestEntity(name = name)
        testDao.insertTest(test)
    }

    fun getAllTest()= testDao.getAllTest()

}