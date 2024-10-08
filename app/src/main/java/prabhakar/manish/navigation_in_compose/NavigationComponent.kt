package prabhakar.manish.navigation_in_compose

import GridPage
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import prabhakar.manish.navigation_in_compose.Data.employees
import prabhakar.manish.navigation_in_compose.Data.groceries
import prabhakar.manish.navigation_in_compose.Data.students

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = "Navigation in Compose")
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "main_screen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("main_screen") { MainScreen(navController) }
            composable("row_page") { RowPage(students) }
            composable("column_page") { ColumnPage(employees) }
            composable("grid_page") { GridPage(students) }
            composable("staggered_list") { StaggeredList(employees) }
            composable("search_in_lazy_column") { Searchinlazycolumn(groceries) }
        }
    }
}