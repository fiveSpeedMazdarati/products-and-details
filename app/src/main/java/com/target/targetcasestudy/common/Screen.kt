package com.target.targetcasestudy.common
/*
Sealed class to keep track of route strings for navigation

Creating a new screen needs a new navigation route to be added here as well
 */
sealed class Screen(val route: String) {
    data object DealListScreen: Screen("deal_list_screen")
    data object DealDetailScreen: Screen("deal_detail_screen")
    // add new screens and routes as part of the sealed class for navigation
}