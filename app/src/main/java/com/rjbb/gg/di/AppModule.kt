package com.rjbb.gg.di

import android.content.Context
import androidx.room.Room
import com.rjbb.gg.data.db.AppDatabase
import com.rjbb.gg.domain.search.MemoryScanner
import com.rjbb.gg.domain.search.SearchEngine
import com.rjbb.gg.domain.memory.MemoryModifier
import com.rjbb.gg.domain.functions.FunctionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "rjbb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMemoryScanner(): MemoryScanner {
        return MemoryScanner()
    }

    @Provides
    @Singleton
    fun provideSearchEngine(
        memoryScanner: MemoryScanner
    ): SearchEngine {
        return SearchEngine(memoryScanner)
    }

    @Provides
    @Singleton
    fun provideMemoryModifier(): MemoryModifier {
        return MemoryModifier()
    }

    @Provides
    @Singleton
    fun provideFunctionManager(): FunctionManager {
        return FunctionManager()
    }
}