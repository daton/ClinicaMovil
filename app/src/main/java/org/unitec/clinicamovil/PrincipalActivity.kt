package org.unitec.clinicamovil

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.app_bar_principal.*
import android.widget.ArrayAdapter
import android.widget.Spinner

import android.R.array
import android.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import kotlinx.android.synthetic.main.contenido_incidencias.*
import kotlinx.android.synthetic.main.content_principal.*
import org.unitec.clinicamovil.R.layout.content_principal



class PrincipalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        setSupportActionBar(toolbar)


        //Para el spinner


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        //Ocultramos todo
        ocultarTodo();
        val principal = contenido_principal as LinearLayout
        principal.visibility = View.VISIBLE


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                var i= Intent(applicationContext, MapsActivity::class.java)
                startActivity(i)
            }
            R.id.nav_gallery -> {

                ocultarTodo();
                val incidencias = id_contenido_incidencias as ScrollView
                incidencias.visibility = View.VISIBLE


            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun ocultarTodo() {
        val principal = contenido_principal as LinearLayout
      var incidencias = id_contenido_incidencias as ScrollView
      //  var incidencias = id_contenido_incidencias as Fragment
        principal.visibility = View.INVISIBLE
      incidencias.visibility = View.INVISIBLE
    }
}
