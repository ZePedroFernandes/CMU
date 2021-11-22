package pt.ipp.estg.recyclerviewquestions.models

import java.io.Serializable

data class Question(
    val title: String,
    val description: String,
    val correctAnswer: String,
    var state: QuestionState = QuestionState.NOT_ANSWERED
) : Serializable{
    fun isCorrect(answer: String): Boolean{
        return (answer == correctAnswer)
    }

    fun answer(answer: String): QuestionState{
        return if (answer == correctAnswer){
            this.state = QuestionState.CORRECT
            QuestionState.CORRECT
        } else {
            this.state = QuestionState.INCORRECT
            QuestionState.INCORRECT
        }
    }
}

enum class QuestionState : Serializable {
    NOT_ANSWERED, CORRECT, INCORRECT
}