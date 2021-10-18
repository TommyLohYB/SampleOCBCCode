package com.example.sampleocbccode.domain.di.module

import com.example.sampleocbccode.domain.EnglishPerson
import com.example.sampleocbccode.domain.Person
import com.example.sampleocbccode.domain.SpanishPerson
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class PersonModule {

    @EnglishQualifier
    @Binds
    abstract fun EnglishPersonImpl(englishPerson: EnglishPerson): Person

    @SpanishQualifier
    @Binds
    abstract fun SpanishPeopleImpl(spanishPerson: SpanishPerson): Person
}

@Qualifier
annotation class EnglishQualifier

@Qualifier
annotation class SpanishQualifier