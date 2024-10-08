package prabhakar.manish.navigation_in_compose

import GridPage
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var toolbarTitle by remember { mutableStateOf("Navigation in Compose") }

    Scaffold(
        topBar = {
            TopAppBar(title = toolbarTitle)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "main_screen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("main_screen") {
                MainScreen(navController)
                toolbarTitle = "Main Screen"
            }
            composable("row_page") {
                RowPage(students)
                toolbarTitle = "Row Page"
            }
            composable("column_page") {
                ColumnPage(employees)
                toolbarTitle = "Column Page"
            }
            composable("grid_page") {
                GridPage(students)
                toolbarTitle = "Grid Page"
            }
            composable("staggered_list") {
                StaggeredList(employees)
                toolbarTitle = "Staggered List"
            }
            composable("search_in_lazy_column") {
                Searchinlazycolumn(groceries)
                toolbarTitle = "Search"
            }
        }
    }
}