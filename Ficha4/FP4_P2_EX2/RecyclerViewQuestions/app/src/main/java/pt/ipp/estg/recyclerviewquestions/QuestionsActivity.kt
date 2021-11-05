package pt.ipp.estg.recyclerviewquestions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.recyclerviewquestions.adapters.QuestionAdapter
import pt.ipp.estg.recyclerviewquestions.models.Question

class QuestionsActivity : AppCompatActivity() {

    val INTENT_FILTER = "receiveQuestionAnswer"
    private val questionsList: List<Question> = listOf(
        Question("Pergunta 1", "Quanto é 2+2?", "4"),
        Question("Pergunta 2", "Qual o melhor amigo do Homem?", "Cão"),
        Question("Pergunta 3", "Escreva \"Olá\"", "Olá"),
        Question("Pergunta 4", "", ""),
        Question("Pergunta 5", "", ""),
        Question("Pergunta 6", "", ""),
        Question("Pergunta 7", "", ""),
        Question("Pergunta 8", "", ""),
        Question("Pergunta 9", "", ""),
        Question("Pergunta 10", "", ""),
        Question("Pergunta 11", "", ""),
        Question("Pergunta 12", "", ""),
        Question("Pergunta 13", "", ""),
        Question("Pergunta 14", "", ""),
        Question("Pergunta 15", "", ""),
        Question("Pergunta 16", "", ""),
        Question("Pergunta 17", "", ""),
        Question("Pergunta 18", "", ""),
        Question("Pergunta 19", "", ""),
        Question("Pergunta 20", "", ""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions_list_layout)

        val questionAdapter = QuestionAdapter(this, questionsList)

        findViewById<RecyclerView>(R.id.rvQuestions).apply {
            adapter = questionAdapter
            layoutManager = LinearLayoutManager(this@QuestionsActivity)
        }

        val broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                val answer = intent.getStringExtra("answer")!!
                val questionNumber = intent.getIntExtra("questionNumber", -1)

                questionsList[questionNumber].answer(answer)
                questionAdapter.notifyItemChanged(questionNumber)
            }
        }
        val filter = IntentFilter(INTENT_FILTER)

        registerReceiver(broadcastReceiver, filter)
    }
}