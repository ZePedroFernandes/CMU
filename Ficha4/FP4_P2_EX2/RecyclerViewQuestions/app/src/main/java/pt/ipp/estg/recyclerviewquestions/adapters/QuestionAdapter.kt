package pt.ipp.estg.recyclerviewquestions.adapters

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.recyclerviewquestions.AnswerQuestionActivity
import pt.ipp.estg.recyclerviewquestions.R
import pt.ipp.estg.recyclerviewquestions.models.Question
import pt.ipp.estg.recyclerviewquestions.models.QuestionState

class QuestionAdapter(private val context: Context, private val dataSet: List<Question>) :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionState: ImageView = view.findViewById(R.id.ivQuestionState)
        val questionTitle: TextView = view.findViewById(R.id.tvQuestionTitle)
        val btnGoToQuestion: Button = view.findViewById(R.id.btnGoToQuestion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = dataSet[position]

        holder.apply {
            questionTitle.text = question.title
            questionState.background = getAnswerCircle(question.state)
            btnGoToQuestion.setOnClickListener(getBtnQuestionClickListener(question, position))
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    /**
     * Retorna a imagem correspondente ao estado da pergunta, pode ser um circulo verde, vermelho ou cinzento.
     */
    fun getAnswerCircle(questionState: QuestionState): Drawable {
        return when (questionState) {
            QuestionState.CORRECT -> ContextCompat.getDrawable(this.context, R.drawable.circle_green)!!
            QuestionState.INCORRECT -> ContextCompat.getDrawable(this.context, R.drawable.circle_red)!!
            else -> ContextCompat.getDrawable(this.context, R.drawable.circle_gray)!!
        }
    }

    /**
     * Retorna um OnClickListener que envia um intent, com uma questão, para uma "AnswerQuestionActivity"
     */
    fun getBtnQuestionClickListener(question: Question, position: Int): View.OnClickListener{
        return View.OnClickListener {
            val intent = Intent(this.context, AnswerQuestionActivity::class.java).apply {
                putExtra("question", question)
                putExtra("questionNumber", position)
            }

            this.context.startActivity(intent)
        }
    }
}