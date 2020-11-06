package com.edwinacubillos.misdeudores.ui.crear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.DeudorDAO
import com.edwinacubillos.misdeudores.data.database.entities.Deudor
import com.edwinacubillos.misdeudores.databinding.FragmentCrearBinding
import java.sql.Types.NULL

class CrearFragment : Fragment() {

    private lateinit var binding: FragmentCrearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCrearBinding.bind(view)

        binding.guardarButton.setOnClickListener {
            val nombre = binding.nombreEditText.text.toString()
            val telefono = binding.telefonoEditText.text.toString()
            val valor = binding.valorEditText.text.toString().toLong()

            val deudor = Deudor(NULL, nombre, telefono, valor)

            val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()
            deudorDAO.insertDeudor(deudor)

        }
    }

    companion object
}