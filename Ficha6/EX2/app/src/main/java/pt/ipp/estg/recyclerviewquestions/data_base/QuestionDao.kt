package pt.ipp.estg.recyclerviewquestions.data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionDao {

    @Query("SELECT * FROM Question")
    fun getAll(): List<Question>

    @Insert
    fun insertQuestion(question: Question)

    @Insert
    fun insertQuestions(questions: List<Question>)

    @Update
    fun updateQuestion(question: Question)
}