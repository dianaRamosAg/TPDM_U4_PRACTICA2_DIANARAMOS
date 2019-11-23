package mx.edu.ittepic.tpdm_u4_practica2_dianaramos

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class Shake  (p:MainActivity): SensorEventListener {
    var puntero = p
    var lastUpdate: Long = 0

    var x = 0f
    var y = 0f
    var z = 0f
    var last_x = 0f
    var last_y = 0f
    var last_z = 0f

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var curTime: Long = System.currentTimeMillis()

        if ((curTime - lastUpdate) > 100) {
            var diffTime = (curTime - lastUpdate)
            lastUpdate = curTime;

            x = event!!.values[0]
            y = event!!.values[1]
            z = event!!.values[2]

            var speed:Float = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > 800) {
                if(puntero.shake==3){puntero.shake = 0}
                else
                    puntero.shake++

            }
            last_x = x
            last_y = y
            last_z = z
        }
    }

}