package com.target.targetcasestudy.common
/*
Sealed class to keep track of route strings for navigation
 */
sealed class Screen(val route: String) {
    data object DealListScreen: Screen("deal_list_screen")
    data object DealDetailScreen: Screen("deal_detail_screen")

}