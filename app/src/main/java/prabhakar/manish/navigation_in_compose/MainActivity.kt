package prabhakar.manish.navigation_in_compose

import GridPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import prabhakar.manish.navigation_in_compose.Data.students

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //  RowPage(students)
          //  ColumnPage(employees)
             GridPage(students)
            //  StaggeredList(employees)
           // Searchinlazycolumn(groceries)
        }
    }
}
