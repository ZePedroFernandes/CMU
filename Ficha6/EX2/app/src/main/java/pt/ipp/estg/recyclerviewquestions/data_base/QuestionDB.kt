package pt.ipp.estg.recyclerviewquestions.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.Serializable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Question::class], version = 1)
abstract class QuestionDB : RoomDatabase(), Serializable {

    abstract fun getQuestionsDao(): QuestionDao

    companion object {

        private var instance: QuestionDB? = null

        private val executors = Executors.newFixedThreadPool(2)

        fun getInstance(context: Context): QuestionDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    QuestionDB::class.java, "question_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }

        fun getExecutorService(): ExecutorService{
            return executors
        }

    }
}