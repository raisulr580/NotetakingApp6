import android.content.Context
import androidx.activity.result.launch
import androidx.annotation.WorkerThread
import androidx.lifecycle.lifecycleScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}

fun newFunction() {
    val applicationContext = null
    val repository = NoteRepository(NoteDatabase.getDatabase(applicationContext).noteDao())

// Insert a note
    val lifecycleScope = null
    lifecycleScope.launch {
        repository.insert(Note(title = "My Note", content = "Note content"))
    }

// Observe notes
    lifecycleScope.launch {
        repository.allNotes.collect { notes ->
            // Update UI with notes
        }
    }
}