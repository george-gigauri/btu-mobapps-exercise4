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

class EmailActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var etEmail: EditText
    private lateinit var btnNext: Button

    private var name: String = ""
    private var age: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        init()
        addListener()
    }

    private fun init() {
        tvName = findViewById(R.id.tvName)
        etEmail = findViewById(R.id.etEmail)
        btnNext = findViewById(R.id.btnNext)

        name = intent.getStringExtra("name") ?: ""
        age = intent.getStringExtra("age") ?: ""

        tvName.text = "${name}, შეიყვანე შენი ელ. ფოსტა:"

        btnNext.setOnClickListener { onNextClicked() }
    }

    private fun addListener() {
        etEmail.doAfterTextChanged {
            btnNext.isVisible = it.toString().isNotEmpty()
        }
    }

    private fun onNextClicked() {
        val intent = Intent(this, FinalActivity::class.java)
        intent.putExtra("name", intent.extras?.getString("name"))
        intent.putExtra("age", intent.extras?.getString("age"))
        intent.putExtra("email", etEmail.text.toString())
        startActivity(intent)
    }
}