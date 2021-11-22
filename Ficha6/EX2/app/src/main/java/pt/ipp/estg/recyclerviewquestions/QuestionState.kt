package pt.ipp.estg.recyclerviewquestions

import java.io.Serializable


enum class QuestionState : Serializable {
    NOT_ANSWERED, CORRECT, INCORRECT
}