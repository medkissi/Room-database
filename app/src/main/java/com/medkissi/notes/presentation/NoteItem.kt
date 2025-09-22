package com.medkissi.notes.presentation

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.medkissi.notes.data.Note
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Locale.getDefault


@Composable
fun NoteItem( note: Note){

    Card(
        modifier = Modifier
            .padding(8.dp)
            .padding(vertical = 20.dp)
            .clip(RoundedCornerShape(16.dp))
    ){
        Row ( modifier  = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment =Alignment.CenterVertically
        ){
            Column {
                Text(text = note.title.replaceFirstChar { if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString() }, style = MaterialTheme.typography.titleMedium)
                Text(text = note.description, style = MaterialTheme.typography.bodyMedium)




            }
            Column {
                Icon(
                    modifier = Modifier.align(Alignment.End),
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note",
                    tint = MaterialTheme.colorScheme.error
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 16.dp),
                    text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(note.dateAdded), style = MaterialTheme.typography.bodySmall)
            }


        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_TYPE_NORMAL

)
@Composable
fun previewNoteItem(){
    val date  = System.currentTimeMillis()
    val note = Note(title = "test", description = "description de ma note de test", dateAdded = date)
    NoteItem( note = note)
}