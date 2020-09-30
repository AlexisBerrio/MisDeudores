package com.edwinacubillos.misdeudores

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registrar_button.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            intent.putExtra("numero", 100)
            startActivity(intent)
            finish()
        }
    }
}