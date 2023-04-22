package com.optic.paqta.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants
import com.optic.paqta.core.Constants.POSTS
import com.optic.paqta.core.Constants.USERS
import com.optic.paqta.data.repository.AuthRepositoryImpl
import com.optic.paqta.data.repository.ItemsRepositoryImpl
import com.optic.paqta.data.repository.PostsRepositoryImpl
import com.optic.paqta.data.repository.UsersRepositoryImpl
import com.optic.paqta.domain.repository.AuthRepository
import com.optic.paqta.domain.repository.ItemsRepository
import com.optic.paqta.domain.repository.PostsRepository
import com.optic.paqta.domain.repository.UsersRepository
import com.optic.paqta.domain.use_cases.auth.*
import com.optic.paqta.domain.use_cases.posts.*
import com.optic.paqta.domain.use_cases.users.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(USERS)

    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)

    @Provides()
    @Named(Constants.BACKPACKS)
    fun provideStorageBackpacksRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(
            Constants.BACKPACKS
        )

    @Provides
    @Named(Constants.BACKPACKS)
    fun provideBackpacksRef(db: FirebaseFirestore): CollectionReference = db.collection(Constants.BACKPACKS)

    @Provides()
    @Named(Constants.ITEMS)
    fun provideItemsRef(db: FirebaseFirestore): CollectionReference = db.collection(Constants.ITEMS)

    @Provides()
    @Named(Constants.ITEMS)
    fun provideStorageItemsRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(
            Constants.ITEMS
        )

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun providePostsRepository(impl: PostsRepositoryImpl): PostsRepository = impl

    @Provides
    fun provideItemsRepository(impl: ItemsRepositoryImpl): ItemsRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository)
    )

    @Provides
    fun providePostsUseCases(repository: PostsRepository) = PostsUseCases(
        create = CreatePost(repository),
        getPosts = GetPosts(repository),
        getPostsByIdUser = GetPostsByIdUser(repository),
        deletePost = DeletePost(repository),
        updatePost = UpdatePost(repository),
        likePost = LikePost(repository),
        deleteLikePost = DeleteLikePost(repository)
    )

}