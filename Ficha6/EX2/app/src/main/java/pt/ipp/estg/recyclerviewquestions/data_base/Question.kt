package pt.ipp.estg.recyclerviewquestions.data_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import pt.ipp.estg.recyclerviewquestions.QuestionState
import java.io.Serializable

@Entity
data class Question(
    @PrimaryKey val title: String,
    val description: String,
    val correctAnswer: String,
    var state: QuestionState = QuestionState.NOT_ANSWERED
) : Serializable{
    fun isCorrect(answer: String): Boolean {
        return (answer == correctAnswer)
    }

    fun answer(answer: String): QuestionState {
        return if (answer == correctAnswer) {
            this.state = QuestionState.CORRECT
            QuestionState.CORRECT
        } else {
            this.state = QuestionState.INCORRECT
            QuestionState.INCORRECT
        }
    }
}
