package namle.tutorial.gymtracer.data.repository

import namle.tutorial.gymtracer.data.local.TestDao
import namle.tutorial.gymtracer.data.local.TestEntity

class TestRepository(private val testDao: TestDao) {
    suspend fun addTest(name: String){
        val test = TestEntity(name = name)
        testDao.insertTest(test)
    }

    suspend fun getAllTest(): List<TestEntity>{
        return testDao.getAllTest()
    }
}