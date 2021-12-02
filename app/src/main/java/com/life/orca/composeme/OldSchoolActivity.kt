package com.life.orca.composeme

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.life.orca.composeme.ui.components.wrapper.YotiButtonPrimaryWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OldSchoolActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old_school)

        with(findViewById<YotiButtonPrimaryWrapper>(R.id.primaryButton)) {
            onClick = {
                Toast.makeText(this@OldSchoolActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}