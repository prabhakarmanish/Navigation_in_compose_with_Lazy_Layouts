package prabhakar.manish.navigation_in_compose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prabhakar.manish.navigation_in_compose.Data.EmployeeColumn


@Composable
fun ColumnPage(empl: List<EmployeeColumn>) {

    val context = LocalContext.current
    //for Search Implementation
    var searchText by remember { mutableStateOf("") }
    val filteredList = empl.filter { it.name.contains(searchText, ignoreCase = true) }

    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") }
        )

        LazyColumn(
            modifier = Modifier
                .padding(8.dp) // Adds padding around the entire list
        ) {
            items(filteredList) { employee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .clickable {
                            Toast
                                .makeText(context, "Clicked on ${employee.name}", Toast.LENGTH_LONG)
                                .show()
                        }, // Space between cards
                    elevation = CardDefaults.cardElevation(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), // Padding inside the card
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = "ID: ${employee.employee_Id}")
                        Text(text = "Age: ${employee.age}")
                        Text(text = "Name: ${employee.name}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewColumn() {
    ColumnPage(empl = prabhakar.manish.navigation_in_compose.Data.employees)
}