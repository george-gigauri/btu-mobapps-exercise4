package ge.georgegigauri.exercise4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        addListener()
    }

    private fun init() {
        etName = findViewById(R.id.etName)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener { onNextClicked() }
    }

    private fun addListener() {
        etName.doAfterTextChanged {
            btnNext.isVisible = it.toString().isNotEmpty()
        }
    }

    private fun onNextClicked() {
        val intent = Intent(this, AgeActivity::class.java)
        intent.putExtra("name", etName.text.toString())
        startActivity(intent)
    }
}