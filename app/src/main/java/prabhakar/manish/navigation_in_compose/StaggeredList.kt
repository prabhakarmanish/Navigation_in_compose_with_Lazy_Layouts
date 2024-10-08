package prabhakar.manish.navigation_in_compose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prabhakar.manish.navigation_in_compose.Data.EmployeeColumn
import prabhakar.manish.navigation_in_compose.Data.employees

@Composable
fun StaggeredList(employee: List<EmployeeColumn>) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier
            .padding(8.dp) // Adds padding around the entire list
    ) {
        items(items = employee) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        Toast
                            .makeText(context, "Clicked on ${it.name}", Toast.LENGTH_LONG)
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
                    Text(text = "ID: ${it.employee_Id}")
                    Text(text = "Age: ${it.age}")
                    Text(text = "Name: ${it.name}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewsteggered() {
    StaggeredList(employees)
}