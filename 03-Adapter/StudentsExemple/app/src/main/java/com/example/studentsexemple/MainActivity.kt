package com.example.studentsexemple

import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AlignmentSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import android.text.Layout.Alignment  // This is the required import

class MainActivity : AppCompatActivity() {
    private val students = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        val nameInput = findViewById<EditText>(R.id.aluno)
        val choiceInput = findViewById<EditText>(R.id.areadeescolha)
        val resultView = findViewById<TextView>(R.id.result)
        val countView = findViewById<TextView>(R.id.contadoralunos)
        val insertButton = findViewById<Button>(R.id.btn)
        val resetButton = findViewById<Button>(R.id.zerar)

        insertButton.setOnClickListener {
            val studentName = nameInput.text.toString()
            val studentChoice = choiceInput.text.toString()

            // Add the student's data to the list
            if (studentName.isNotEmpty() && studentChoice.isNotEmpty()) {
                val currentDate = getCurrentDate()

                val studentData = "$studentName - $studentChoice - $currentDate"
                students.add(studentData)

                updateStudentList(resultView, countView)

                nameInput.text.clear()
                choiceInput.text.clear()
            }
        }

        resetButton.setOnClickListener {
            students.clear()
            updateStudentList(resultView, countView)
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
        return dateFormat.format(Date())
    }

    private fun updateStudentList(resultView: TextView, countView: TextView) {
        val builder = SpannableStringBuilder()

        for (student in students) {
            val parts = student.split(" - ")

            if (parts.size == 3) {
                val nameAndChoice = parts[0] + " - " + parts[1]
                val date = parts[2]

                val nameChoiceSpan = SpannableString(nameAndChoice)


                val dateSpan = SpannableString(date)
                dateSpan.setSpan(
                    AlignmentSpan.Standard(Alignment.ALIGN_OPPOSITE),
                    0, dateSpan.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                builder.append(nameChoiceSpan).append("\n").append(dateSpan).append("\n\n")
            }
        }

        resultView.text = builder
        countView.text = students.size.toString()
    }
}
