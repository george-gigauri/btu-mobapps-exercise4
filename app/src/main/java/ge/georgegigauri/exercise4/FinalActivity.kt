package ge.georgegigauri.exercise4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {

    private lateinit var tvNameAndAge: TextView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val name = intent.getStringExtra("name").orEmpty()
        val age = intent.getStringExtra("age").orEmpty()
        val email = intent.getStringExtra("email").orEmpty()

        tvNameAndAge = findViewById(R.id.tvNameAge)
        tvEmail = findViewById(R.id.tvEmail)

        tvNameAndAge.text = "${name}, $age წლისა"
        tvEmail.text = email
    }
}