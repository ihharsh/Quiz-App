package com.example.myqyizapp

object Constants {

    const val USER_NAME: String = " user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANS: String = "correct_ans"

    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What is this Animal",R.drawable.keshav,
            "Keshav", "Bishnoi", "Gulabi", "Ganganagar", 3
        )

        questionList.add(que1)

        val que2 = Question(
            1,"What is this Animal",R.drawable.munish,
            "All sports", "Lakkad Bagha", "Iron Fist", "Dog", 3
        )
        questionList.add(que2)
        val que3 = Question(
            1,"What is this Animal",R.drawable.shiva,
            "Shiva", "BeediFukka", "chikni", "Horse", 2
        )
        questionList.add(que3)
        val que4 = Question(
            1,"What is this Animal",R.drawable.sans,
            "Suraj", "Kya hai yarr", "Snake", "Elephant", 1
        )
        questionList.add(que4)
        val que5 = Question(
            1,"What is this Animal",R.drawable.chidiya,
            "Piyush", "Ram", "Ananjay", "Chidiya Ghar", 4
        )
        questionList.add(que5)
        return questionList

    }
}