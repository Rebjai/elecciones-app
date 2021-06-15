package com.example.elecciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

//    Se declaran e inicializan los contadores
        private var pri = 0
        private var pan = 0
        private var prd = 0
        private var pt = 0
        private var mov = 0
        private var mor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    Se crea un click handler por cada partido, el cual aumenta el contador de dicho partido
    fun votoPAN( view: View) {
    pan++
    }
    fun votoPRI(view: View) {
        pri++
    }
    fun votoMorena(view: View) {
        mor++
    }
    fun votoMOV(view: View) {
        mov++
    }
    fun votoPT(view: View) {
        pt++
    }
    fun votoPRD(view: View) {
        prd++
    }

//    Handler de botón de resultados
    fun showResultsVotes( view: View) {
//    Se crea un ArrayList de los resultados obtenidos, se le pasa al intent con el método putExtra()
        val resv = arrayListOf(pan,pri,mor,mov,pt,prd)
        val vista = Intent(this,Resultados::class.java).apply {
            putExtra("votos",resv)
        }
        startActivity(vista)

    }
}