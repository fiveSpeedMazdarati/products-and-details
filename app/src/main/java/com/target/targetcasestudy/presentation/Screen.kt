package com.target.targetcasestudy.presentation
sealed class Screen(val route: String) {
    data object DealListScreen: Screen("deal_list_screen")
    data object DealDetailScreen: Screen("deal_detail_screen")

}