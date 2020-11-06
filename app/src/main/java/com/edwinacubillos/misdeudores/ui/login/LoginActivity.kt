package com.edwinacubillos.misdeudores.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.databinding.ActivityLoginBinding
import com.edwinacubillos.misdeudores.ui.bottom.BottomActivity
import com.edwinacubillos.misdeudores.ui.registro.RegistroActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)


        // Goto registro activity
        binding.registrarButton.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        // Verify login data
        binding.loginButton.setOnClickListener {

            val correo = binding.correoEditText.text.toString()
            val contrasena = binding.contrasenaEditText.text.toString()

            val usuarioDAO: UsuarioDAO = MisDeudores.database.UsuarioDAO()
            val usuario = usuarioDAO.searchUsuario(correo)

            // Looking for empty fields
            when {
                correo.isEmpty() -> binding.correoEditText.error = getString(R.string.campo_vacio)
                contrasena.isEmpty() -> binding.contrasenaEditText.error =
                    getString(R.string.campo_vacio)
                usuario == null || usuario.contrasena != contrasena -> {
                    Toast.makeText(this, getString(R.string.no_existe), Toast.LENGTH_SHORT).show()
                    binding.contrasenaEditText.text = null
                }
                else -> goToBottomActivity()
            }
        }
    }

    // Goto bottom activity
    fun goToBottomActivity() {
        val intent = Intent(this, BottomActivity::class.java)
        startActivity(intent)
        finish()
    }
}