package mx.edu.ittepic.tpdm_u4_practica2_dianaramos

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteAcelerometro (p:MainActivity): SensorEventListener {
    var puntero = p
    var l:Lienzo?=null
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.xS = event!!.values[0]
        // l?.imagenes()
        //   Toast.makeText(puntero,"x = "+puntero.x, Toast.LENGTH_SHORT)
        //     .show()


    }

}