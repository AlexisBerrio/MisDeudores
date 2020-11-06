package com.edwinacubillos.misdeudores.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwinacubillos.misdeudores.data.database.dao.DeudorDAO
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.data.database.entities.Deudor
import com.edwinacubillos.misdeudores.data.database.entities.Usuario

@Database(
    entities =
    [Deudor::class,
        Usuario::class],
    version = 1
)
abstract class DeudorDatabase : RoomDatabase() {

    abstract fun DeudorDAO(): DeudorDAO
    abstract fun UsuarioDAO(): UsuarioDAO
}
