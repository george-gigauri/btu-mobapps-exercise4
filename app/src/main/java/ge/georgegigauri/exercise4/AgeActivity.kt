package ge.georgegigauri.exercise4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged

class AgeActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var etAge: EditText
    private lateinit var btnNext: Button

    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        init()
        addListener()
    }

    private fun init() {
        tvName = findViewById(R.id.tvName)
        etAge = findViewById(R.id.etAge)
        btnNext = findViewById(R.id.btnNext)
        name = intent.getStringExtra("name") ?: ""

        tvName.text = "$name, შეიყვანე შენი ასაკი:"

        btnNext.setOnClickListener { onNextClicked() }
    }

    private fun addListener() {
        etAge.doAfterTextChanged {
            btnNext.isVisible = it.toString().isNotEmpty()
        }
    }

    private fun onNextClicked() {
        val intent = Intent(this, EmailActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("age", etAge.text.toString())
        startActivity(intent)
    }
}