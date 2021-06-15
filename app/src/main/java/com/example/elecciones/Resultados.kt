package com.example.elecciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultados.*

class Resultados : AppCompatActivity() {

    private var votos : ArrayList<Int>? = null
    private var total:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        votos = intent.getIntegerArrayListExtra("votos")

        setTotalVotes()
        setPercentages()

    }

    private fun setTotalVotes() {
//        Ponemos el texto de los votos obtenidos por partidos
        panTotal.text = votos?.get(0).toString()
        priTotal.text = votos?.get(1).toString()
        morTotal.text = votos?.get(2).toString()
        movTotal.text = votos?.get(3).toString()
        ptTotal.text = votos?.get(4).toString()
        prdTotal.text = votos?.get(5).toString()
    }
    private fun setPercentages() {
//        hacemos un reduce para calcular el total de votos
        total = votos?.reduce(operation = {acc, num -> acc+num})

//        Calculamos el porcentaje dividiendo los votos obtenidos entre el total, y luego multiplicando por 100
//        Siguiendo las buenas prácticas de android, se usa una String template, definida en Strings.xml
//        Se le pasa el resultado como parámetro, para evitar la concatenación de texto
        panP.text = getString(R.string.result_percentage,(votos!![0].toFloat()/total!!.toFloat())*100)
        priP.text = getString(R.string.result_percentage,(votos!![1].toFloat()/total!!.toFloat())*100)
        morP.text = getString(R.string.result_percentage,(votos!![2].toFloat()/total!!.toFloat())*100)
        movP.text = getString(R.string.result_percentage,(votos!![3].toFloat()/total!!.toFloat())*100)
        ptP.text = getString(R.string.result_percentage,(votos!![4].toFloat()/total!!.toFloat())*100)
        prdP.text = getString(R.string.result_percentage,(votos!![5].toFloat()/total!!.toFloat())*100)
    }
}