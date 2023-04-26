package com.optic.paqta.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.optic.paqta.core.Constants.BACKPACKS
import com.optic.paqta.core.Constants.CATEGORIES
import com.optic.paqta.core.Constants.MEMBERS
import com.optic.paqta.core.Constants.POINTS
import com.optic.paqta.core.Constants.POSTS
import com.optic.paqta.core.Constants.USERS
import com.optic.paqta.data.repository.AuthRepositoryImpl
import com.optic.paqta.data.repository.BackpacksRepositoryImpl
import com.optic.paqta.data.repository.CategoriesRepositoryImpl
import com.optic.paqta.data.repository.MembersRepositoryImpl
import com.optic.paqta.data.repository.PointsRepositoryImpl
import com.optic.paqta.data.repository.PostsRepositoryImpl
import com.optic.paqta.data.repository.UsersRepositoryImpl
import com.optic.paqta.domain.repository.AuthRepository
import com.optic.paqta.domain.repository.BackpacksRepository
import com.optic.paqta.domain.repository.CategoriesRepository
import com.optic.paqta.domain.repository.MembersRepository
import com.optic.paqta.domain.repository.PointsDangerRepository
import com.optic.paqta.domain.repository.PostsRepository
import com.optic.paqta.domain.repository.UsersRepository
import com.optic.paqta.domain.use_cases.auth.*
import com.optic.paqta.domain.use_cases.backpacks.AddItemBackpack
import com.optic.paqta.domain.use_cases.backpacks.BackpacksUseCases
import com.optic.paqta.domain.use_cases.backpacks.CreateBackpack
import com.optic.paqta.domain.use_cases.backpacks.DeleteBackpack
import com.optic.paqta.domain.use_cases.backpacks.DeleteItemBackpack
import com.optic.paqta.domain.use_cases.backpacks.GetBackpacks
import com.optic.paqta.domain.use_cases.backpacks.GetBackpacksByIdUser
import com.optic.paqta.domain.use_cases.backpacks.UpdateBackpack
import com.optic.paqta.domain.use_cases.categories.CategoriesUseCases
import com.optic.paqta.domain.use_cases.categories.GetCategories
import com.optic.paqta.domain.use_cases.members.CreateMember
import com.optic.paqta.domain.use_cases.members.MembersUseCases
import com.optic.paqta.domain.use_cases.points.CreatePointDanger
import com.optic.paqta.domain.use_cases.points.GetPointsByIdUser
import com.optic.paqta.domain.use_cases.points.PointsUseCases
import com.optic.paqta.domain.use_cases.points.SaveImagePointDanger
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

    @Provides
    @Named(CATEGORIES)
    fun provideStorageCategoriesRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(CATEGORIES)

    @Provides
    @Named(CATEGORIES)
    fun provideCategoriesRef(db: FirebaseFirestore): CollectionReference = db.collection(CATEGORIES)

    @Provides
    @Named(BACKPACKS)
    fun provideStorageBackpacksRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(BACKPACKS)

    @Provides
    @Named(BACKPACKS)
    fun provideBackpacksRef(db: FirebaseFirestore): CollectionReference = db.collection(BACKPACKS)

    @Provides
    @Named(MEMBERS)
    fun provideStorageMembersRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(MEMBERS)

    @Provides
    @Named(MEMBERS)
    fun provideMembersRef(db: FirebaseFirestore): CollectionReference = db.collection(MEMBERS)

    @Provides
    @Named(POINTS)
    fun providePointsRef(db: FirebaseFirestore): CollectionReference = db.collection(POINTS)

    @Provides
    @Named(POINTS)
    fun provideStoragePointsRef(storage: FirebaseStorage): StorageReference =
        storage.reference.child(POINTS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun providePostsRepository(impl: PostsRepositoryImpl): PostsRepository = impl

    @Provides
    fun provideCategoriesRepository(impl: CategoriesRepositoryImpl): CategoriesRepository = impl

    @Provides
    fun provideBackpacksRepository(impl: BackpacksRepositoryImpl): BackpacksRepository = impl

    @Provides
    fun provideMembersRepository(impl: MembersRepositoryImpl): MembersRepository = impl

    @Provides
    fun providePointsRepository(impl: PointsRepositoryImpl): PointsDangerRepository = impl

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
        saveImage = SaveImage(repository),
        addMember = AddMember(repository),
        addPointDanger = AddPointDanger(repository)
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

    @Provides
    fun provideCategoriesUseCases(repository: CategoriesRepository) = CategoriesUseCases(
        getCategories = GetCategories(repository)
    )

    @Provides
    fun provideMembersUseCases(repository: MembersRepository) = MembersUseCases(
        create = CreateMember(repository),
        saveImage = com.optic.paqta.domain.use_cases.members.SaveImage(repository)
    )

    @Provides
    fun provideBackpacksUseCases(repository: BackpacksRepository) = BackpacksUseCases(
        create = CreateBackpack(repository),
        deleteBackpack = DeleteBackpack(repository),
        getBackpacks = GetBackpacks(repository),
        updateBackpack = UpdateBackpack(repository),
        addItemBackpack = AddItemBackpack(repository),
        deleteItemBackpack = DeleteItemBackpack(repository),
        getBackpacksByIdUser = GetBackpacksByIdUser(repository)
    )

    @Provides
    fun providePointsUseCases(repository: PointsDangerRepository) = PointsUseCases(
        createPointDanger = CreatePointDanger(repository),
        saveImage = SaveImagePointDanger(repository),
        getPointsByIdUser = GetPointsByIdUser(repository)
    )

}