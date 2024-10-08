package prabhakar.manish.navigation_in_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("row_page") }) {
            Text("Row Page")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("column_page") }) {
            Text("Column Page")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("grid_page") }) {
            Text("Grid Page")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("staggered_list") }) {
            Text("Staggered List")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("search_in_lazy_column") }) {
            Text("Search in Lazy Column")
        }
    }
}