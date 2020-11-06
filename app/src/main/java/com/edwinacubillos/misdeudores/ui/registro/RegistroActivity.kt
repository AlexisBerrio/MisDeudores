package com.edwinacubillos.misdeudores.ui.registro

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.data.database.entities.Usuario
import com.edwinacubillos.misdeudores.databinding.ActivityRegistroBinding
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {

    //  private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistroBinding

    /* companion object {
         private const val EMPTY = ""
         private const val SPACE = " "
         private val TAG = RegistroActivity::class.simpleName
     }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro)

        // Initialize Firebase Auth
        //     auth = FirebaseAuth.getInstance()

        binding.registrarButton.setOnClickListener {
            val correo = binding.correoEditText.text.toString()
            val contrasena = binding.contrasenaEditText.text.toString()
            val nombre = binding.nombreEditText.text.toString()
            val telefono = binding.telefonoEditText.text.toString()
            val repContrasena = binding.repContrasenaEditText.text.toString()

            when {
                nombre.isEmpty() -> binding.nombreEditText.error = getString(R.string.campo_vacio)
                correo.isEmpty() -> binding.correoEditText.error = getString(R.string.campo_vacio)
                telefono.isEmpty() -> binding.telefonoEditText.error =
                    getString(R.string.campo_vacio)
                contrasena.isEmpty() -> binding.contrasenaEditText.error =
                    getString(R.string.campo_vacio)
                repContrasena.isEmpty() -> binding.repContrasenaEditText.error =
                    getString(R.string.campo_vacio)
                contrasena.length < 6 -> {
                    binding.contrasenaEditText.error = getString(R.string.contrasenacorta)
                }
                contrasena != repContrasena -> {
                    binding.contrasenaEditText.error = getString(R.string.error_contrasena)
                }


                // If any error, send user information and go to Login
                else -> {

                    val usuario = Usuario(NULL, nombre, correo, telefono, contrasena)
                    val usuarioDAO: UsuarioDAO = MisDeudores.database.UsuarioDAO()
                    usuarioDAO.insertUsuario(usuario)

                    Toast.makeText(
                        applicationContext,
                        getString(R.string.registro_guardado),
                        Toast.LENGTH_SHORT
                    ).show()

                    goToLoginActivity()
                }
            }

        }

    }

    /*
        private fun registroEnFirebase(correo: String, contrasena: String) {
            auth.createUserWithEmailAndPassword(correo, contrasena)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        goToLoginActivity()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }
        }
    */
    private fun goToLoginActivity() {
        onBackPressed()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Método", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método", "onRestart")
    }
}






