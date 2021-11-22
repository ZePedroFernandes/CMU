package pt.ipp.estg.recyclerviewquestions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import pt.ipp.estg.recyclerviewquestions.data_base.Question

class AnswerQuestionActivity : AppCompatActivity() {
    val INTENT_FILTER = "receiveQuestionAnswer"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_question)

        val question = intent.getSerializableExtra("question") as Question

        findViewById<TextView>(R.id.tvQuestionTitle).text = question.title
        findViewById<TextView>(R.id.tvQuestionDescription).text = question.description
        findViewById<Button>(R.id.btnSubmitAnswer).setOnClickListener {
            val answer = findViewById<EditText>(R.id.etAnswer).text.toString()
            val questionNumber = this.intent.getIntExtra("questionNumber", -1)

            Intent().apply {
                action = INTENT_FILTER
                putExtra("answer", answer)
                putExtra("questionNumber", questionNumber)
                sendBroadcast(this)
            }

            finish()
        }
    }
}