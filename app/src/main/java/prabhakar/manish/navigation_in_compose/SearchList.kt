package prabhakar.manish.navigation_in_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import prabhakar.manish.navigation_in_compose.Data.Grocery

@Composable
fun Searchinlazycolumn(grocery: List<Grocery>) {

    //for Search Implementation
    var searchText by remember { mutableStateOf("") }
    val filteredList = grocery.filter { it.gro.contains(searchText, ignoreCase = true) }

    // SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing), onRefresh = { refreshList() }) {

    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") }
        )
        LazyColumn {
            items(filteredList) {
                Text(it.gro, modifier = Modifier.padding(20.dp))
            }
        }
    }

}