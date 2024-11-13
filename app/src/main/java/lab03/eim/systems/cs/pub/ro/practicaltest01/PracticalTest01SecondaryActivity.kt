package lab03.eim.systems.cs.pub.ro.practicaltest01

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_secondary)

        // Legarea elementelor din layout
        val totalClicksTextView = findViewById<TextView>(R.id.total_clicks_text_view)
        val okButton = findViewById<Button>(R.id.ok_button)
        val cancelButton = findViewById<Button>(R.id.cancel_button)

        // Obține numărul total de accesări de la activitatea principală
        val totalClicks = intent.getIntExtra("totalClicks", 0)
        totalClicksTextView.text = "Total Clicks: $totalClicks"

        // Configurarea butonului Ok pentru a returna RESULT_OK
        okButton.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        // Configurarea butonului Cancel pentru a returna RESULT_CANCELED
        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}