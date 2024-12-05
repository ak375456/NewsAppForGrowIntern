package com.example.newsapp.di

import com.example.newsapp.news.data.repository.NewsRepositoryImpl
import com.example.newsapp.news.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: NewsRepositoryImpl): NewsRepository
}