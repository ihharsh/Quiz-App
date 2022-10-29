package com.example.myqyizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPos =  1
    private var QuestionsList: ArrayList<Question>? = null
    private var selectedOptionPos: Int = 0
    private var username: String? = null
    private var numcorrectANS: Int = 0

    private var progressbar : ProgressBar? = null
    private var tvprogress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivimg : ImageView? = null
    private var opt1: TextView? = null
    private var opt2: TextView? = null
    private var opt3: TextView? = null
    private var opt4: TextView? = null
    private var submit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressbar = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tvquestion)
        ivimg = findViewById(R.id.img)
        opt1 = findViewById(R.id.tv_opt1)
        opt2 = findViewById(R.id.tv_opt2)
        opt3 = findViewById(R.id.tv_opt3)
        opt4 = findViewById(R.id.tv_opt4)
        submit = findViewById(R.id.submit)
        username = intent.getStringExtra(Constants.USER_NAME)

        opt1?.setOnClickListener(this)
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)
        submit?.setOnClickListener(this)




        QuestionsList = Constants.getQuestions()
        setQuestion()




    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = QuestionsList!![currentPos - 1]
        ivimg?.setImageResource(question.image)
        progressbar?.progress = currentPos
        tvprogress?.text = "$currentPos/${progressbar?.max}"
        tvQuestion?.text = question.question
        opt1?.text = question.opt1
        opt2?.text = question.opt2
        opt3?.text = question.opt3
        opt4?.text = question.opt4

        if(currentPos == QuestionsList!!.size){
            submit?.text = "FINISH"
        }else {
            submit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        opt1?.let {
            options.add(0,it)
        }
        opt2?.let {
            options.add(1,it)
        }
        opt3?.let {
            options.add(2,it)
        }
        opt4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.xyz)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){
        defaultOptionView()
        selectedOptionPos = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background= ContextCompat.getDrawable(this,R.drawable.selected_opt_border_bg)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_opt1 ->{
                opt1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_opt2 ->{
                opt2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_opt3 ->{
                opt3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_opt4 ->{
                opt4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submit ->{
                if (selectedOptionPos==0){
                    currentPos++
                    when{
                        currentPos<= QuestionsList!!.size ->{
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,finish_activity::class.java)
                            intent.putExtra(Constants.USER_NAME,username)
                            intent.putExtra(Constants.CORRECT_ANS,numcorrectANS)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, QuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                }
                else{
                    val question = QuestionsList?.get(currentPos-1)
                    if (question!!.correctAns != selectedOptionPos){
                        answerView(selectedOptionPos, R.drawable.wrong_opt_border_bg)
                    }
                    else{
                        numcorrectANS++
                    }
                    answerView(question.correctAns, R.drawable.correct_opt_border_bg)

                    if (currentPos==QuestionsList?.size){
                        submit?.text = "FINISH"
                    }
                    else{
                        submit?.text = "NEXT QUESTION"
                    }

                    selectedOptionPos=0
                }

            }
        }
    }

    private fun answerView(answer : Int, drawableView: Int){
        when(answer){
            1->{
                opt1?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            2->{
                opt2?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            3->{
                opt3?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            4->{
                opt4?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
        }
    }

}