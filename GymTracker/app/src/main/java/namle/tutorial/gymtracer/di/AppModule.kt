package namle.tutorial.gymtracer.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import namle.tutorial.gymtracer.data.local.AppDatabase
import namle.tutorial.gymtracer.data.local.dao.ExerciseDao
import namle.tutorial.gymtracer.data.local.dao.MuscleGroupDao
import namle.tutorial.gymtracer.data.local.dao.TestDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "gym_tracer_db")
            //.fallbackToDestructiveMigration() ROOM hơi khó chịu chỗ version DB, thêm cột mới nhớ migrate, nếu quên dùng cái này để reset DB, và phải luôn tăng ver DB
            //.addMigrations(AppDatabase.MIGRATION_1_3/*, AppDatabase.MIGRATION_1_4*/)
            .build()

    @Provides
    fun provideTestDao(db: AppDatabase): TestDao = db.testDao()
    @Provides
    fun provideExerciseDao(db: AppDatabase): ExerciseDao = db.exerciseDao()
    @Provides
    fun provideMuscleGroupDao(db: AppDatabase): MuscleGroupDao = db.muscleGroupDao()
}