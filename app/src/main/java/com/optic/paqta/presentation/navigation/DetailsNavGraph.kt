package com.optic.paqta.presentation.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.optic.paqta.domain.model.Category
import com.optic.paqta.presentation.screens.add_family.AddFamilyScreen
import com.optic.paqta.presentation.screens.detail_backpack.DetailBackpackScreen
import com.optic.paqta.presentation.screens.detail_category_backpack.DetailCategoryBakpackScreen
import com.optic.paqta.presentation.screens.detail_post.DetailPostScreen
import com.optic.paqta.presentation.screens.new_backpack.NewBackpackScreen
import com.optic.paqta.presentation.screens.new_data_croquis.NewDataCroquisScreen
import com.optic.paqta.presentation.screens.new_post.NewPostScreen
import com.optic.paqta.presentation.screens.profile_update.ProfileUpdateScreen
import com.optic.paqta.presentation.screens.update_post.UpdatePostScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {
        
        composable(route = DetailsScreen.NewPost.route) {
            NewPostScreen(navController = navController)
        }

        composable(route = DetailsScreen.NewBackpack.route) {
            NewBackpackScreen(navController = navController)
        }
        
        composable(route = DetailsScreen.NewDataCroquis.route) {
            NewDataCroquisScreen(navController = navController)
        }
        
        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, user = it)
            }
        }

        composable(
            route = DetailsScreen.AddMember.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                AddFamilyScreen(navController)
            }
        }

        composable(
            route = DetailsScreen.DetailPost.route,
            arguments = listOf(navArgument("post"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let {
                DetailPostScreen(navController, post = it)
            }
        }

        composable(
            route = DetailsScreen.DetailCategory.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                DetailCategoryBakpackScreen(navController, category = it)
            }
        }

        composable(
            route = DetailsScreen.DetailBackpack.route,
            arguments = listOf(navArgument("backpack"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("backpack")?.let {
                DetailBackpackScreen(navController, backpack = it)
            }
        }

        composable(
            route = DetailsScreen.UpdatePost.route,
            arguments = listOf(navArgument("post"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let {
                UpdatePostScreen(navController, post = it)
            }
        }



    }

}

sealed class DetailsScreen(val route: String) {
    object NewPost: DetailsScreen("posts/new")
    object NewBackpack: DetailsScreen("backpacks/new")
    object NewDataCroquis: DetailsScreen("croquis/new")
    object ProfileUpdate: DetailsScreen("profile/update/{user}") {
        fun passUser(user: String) = "profile/update/$user"
    }

    object AddMember: DetailsScreen("profile/update/member/{user}") {
        fun passMember(user: String) = "profile/update/member/$user"
    }

    object DetailPost: DetailsScreen("posts/detail/{post}") {
        fun passPost(post: String) = "posts/detail/$post"
    }

    object DetailBackpack: DetailsScreen("backpacks/detail/{backpack}") {
        fun passBackpack(backpack: String) = "backpacks/detail/$backpack"
    }

    object DetailCategory: DetailsScreen("categories/detail/{category}") {
        fun passCategory(category: String) = "categories/detail/$category"
    }


    object UpdatePost: DetailsScreen("posts/update/{post}") {
        fun passPost(post: String) = "posts/update/$post"
    }


}