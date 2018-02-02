package org.unitec.clinicamovil

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_main.*
import org.unitec.clinicamovil.R.id.spinner
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.unitec.clinicamovil.R.id.spinner





class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog2))
        // Add the buttons
        builder.setNegativeButton("Aceptar") { dialog, id ->
            //  Aqui se conetcta al servicio para guardar la estación: SErvico esta dado por la TareaClimaUsuario
            // Toast.makeText(applicationContext,"La estacion se guardara",Toast.LENGTH_SHORT).show();



        }
        builder.setView(R.layout.dialogo_inicial2)
        builder.setTitle("Error de autenticación")
        // builder.setMessage("Para buscar una estación y ver el clima  navega sobre el mapa y toca la pantalla para indicar en donde quieres emepzar la busqueda de tu estacion" +
        //       " más cerca")
        // Set other dialog properties






        var list_of_items = arrayOf("Director", "Profesor", "Externo")

       var spinner= spiner_roles
       spinner.prompt="Selecciona un Rol"
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)

        // Set layout to use when the list of choices appear
       aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)


        ingresar.setOnClickListener{
            //var correo=email.text.toString()
        var rol=    spinner.selectedItem.toString()
            var nipi=nip.text.toString()
            println("EL ESCOGIDO ES   "+rol)

            if(rol.equals("Director")&&nipi.equals("321")){
                var i = Intent(applicationContext, MapsActivity::class.java)
                startActivity(i)

            }else if(nipi.equals("321")){
                var i = Intent(applicationContext, PrincipalActivity::class.java)
                startActivity(i)
            }
            else{
                // Create the AlertDialog
                val dialog = builder.create()
                dialog.show()

            }

        }
    }
}
