import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prabhakar.manish.navigation_in_compose.Data.StudentRow

@Composable
fun GridPage(students: List<StudentRow>) {

    //for Search Implementation
    var searchText by remember { mutableStateOf("") }
    val filteredList = students.filter { it.Name.contains(searchText, ignoreCase = true) }

    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") }
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Fixed number of columns
            // columns = GridCells.Adaptive(minSize = 130.dp), // Adaptive grid
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp), // Padding for outer grid
            contentPadding = PaddingValues(8.dp) // Inner padding
        ) {
            items(filteredList) { student ->
                StudentCard(student = student)
            }
        }
    }
}

@Composable
fun StudentCard(student: StudentRow) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .heightIn(min = 80.dp, max = 160.dp), // Adaptive height for staggered effect
        // Light teal background color
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = student.Name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    color = Color(0xFF00796B), // Dark teal text color
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
