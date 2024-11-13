package lab03.eim.systems.cs.pub.ro.practicaltest01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PracticalTest01MainActivity : AppCompatActivity() {
    // Legarea elementelor din layout
    private lateinit var leftTextView: TextView
    private lateinit var rightTextView: TextView
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var navigateButton: Button


    // Chei pentru salvarea valorilor în Bundle
    companion object {
        private const val LEFT_COUNT_KEY = "leftCount"
        private const val RIGHT_COUNT_KEY = "rightCount"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_main)
        // Legarea elementelor din layout
        leftTextView = findViewById(R.id.left_text_view)
        rightTextView = findViewById(R.id.right_text_view)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)
        navigateButton = findViewById(R.id.navigate_button)
        // Ascultător pentru butonul din stânga
        leftButton.setOnClickListener {
            val leftCount = leftTextView.text.toString().toInt()
            leftTextView.text = (leftCount + 1).toString()
        }

        // Ascultător pentru butonul din dreapta
        rightButton.setOnClickListener {
            val rightCount = rightTextView.text.toString().toInt()
            rightTextView.text = (rightCount + 1).toString()
        }
        // Setează ascultătorul pentru butonul de navigare către activitatea secundară
        navigateButton.setOnClickListener {
            val totalClicks = leftTextView.text.toString().toInt() + rightTextView.text.toString().toInt()
            val intent = Intent(this, PracticalTest01SecondaryActivity::class.java)
            intent.putExtra("totalClicks", totalClicks)
            startActivityForResult(intent, 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Salvează valorile din TextView-uri în Bundle
        outState.putString(LEFT_COUNT_KEY, leftTextView.text.toString())
        outState.putString(RIGHT_COUNT_KEY, rightTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restaurează valorile salvate din Bundle, dacă există
        leftTextView.text = savedInstanceState.getString(LEFT_COUNT_KEY, "0")
        rightTextView.text = savedInstanceState.getString(RIGHT_COUNT_KEY, "0")
    }
    // Metoda pentru a primi rezultatul din activitatea secundară
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            // Afisează rezultatul în Toast în funcție de codul rezultatului
            val message = when (resultCode) {
                Activity.RESULT_OK -> "Returned with OK"
                Activity.RESULT_CANCELED -> "Returned with Cancel"
                else -> "Unknown Result"
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

}