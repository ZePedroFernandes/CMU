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
        Question("Pergunta 4", "2*3=", "6"),
        Question("Pergunta 5", "Clique em submeter", ""),
        Question("Pergunta 6", "Clique em submeter", ""),
        Question("Pergunta 7", "Clique em submeter", ""),
        Question("Pergunta 8", "Clique em submeter", ""),
        Question("Pergunta 9", "Clique em submeter", ""),
        Question("Pergunta 10", "Clique em submeter", "")
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