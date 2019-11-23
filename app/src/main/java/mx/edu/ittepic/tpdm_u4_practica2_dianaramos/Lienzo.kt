package mx.edu.ittepic.tpdm_u4_practica2_dianaramos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo(p:MainActivity): View(p) {
    var puntero = p
    var x1=0f
    var picono:Imagen?=null
    var icono1 = Imagen(this, 20f, 400f, R.drawable.arbol)
    var icono2 = Imagen(this, 250f, 400f, R.drawable.carta)
    var icono3 = Imagen(this, 510f, 400f, R.drawable.esferas)
    var icono4 = Imagen(this, 700f, 400f, R.drawable.oso)
    var icono5 = Imagen(this, 910f, 400f, R.drawable.santa)

    var icono11 = Imagen(this, 20f, 400f, R.drawable.arbol_b)
    var icono12 = Imagen(this, 250f, 400f, R.drawable.carta_b)
    var icono13 = Imagen(this, 510f, 400f, R.drawable.esferas_b)
    var icono14 = Imagen(this, 700f, 400f, R.drawable.oso_b)
    var icono15 = Imagen(this, 910f, 400f, R.drawable.santa_b)

    var icono21 = Imagen(this, 20f, 400f, R.drawable.arbol_v)
    var icono22 = Imagen(this, 250f, 400f, R.drawable.carta_v)
    var icono23 = Imagen(this, 510f, 400f, R.drawable.esferas_v)
    var icono24 = Imagen(this, 700f, 400f, R.drawable.oso_v)
    var icono25 = Imagen(this, 910f, 400f, R.drawable.santa_v)

    var arrayImgC = arrayListOf(icono1,icono2,icono3,icono4,icono5)
    var arrayImgB = arrayListOf(icono1,icono12,icono13,icono14,icono15)
    var arrayImgV = arrayListOf(icono1,icono22,icono23,icono24,icono25)
    var invisible=false
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p= Paint()
        if(puntero.prox==0f ){
            invisible=true
            p.color= Color.WHITE
            c.drawCircle(100f,500f,1000f,p)
        }
        if(invisible==false) {
            when (puntero.shake) {
                0 -> {
                    icono1.pintar(c)
                    icono2.pintar(c)
                    icono3.pintar(c)
                    icono4.pintar(c)
                    icono5.pintar(c)
                    imagenes()
                }
                1 -> {
                    icono1.pintar(c)
                    icono12.pintar(c)
                    icono13.pintar(c)
                    icono14.pintar(c)
                    icono15.pintar(c)
                    imagenes2()
                }
                2 -> {
                    icono1.pintar(c)
                    icono22.pintar(c)
                    icono23.pintar(c)
                    icono24.pintar(c)
                    icono25.pintar(c)
                    imagenes3()

                }
                3 -> {
                    puntero.shake = 0
                    icono2.pintar(c)
                    icono3.pintar(c)
                    icono4.pintar(c)
                    icono5.pintar(c)
                    imagenes()
                }
            }
        }

    }

    fun  imagenes() {

        if (puntero.xS > 0) {
            x1 = 0f
            arrayImgC.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        if (puntero.xS <0) {
            x1 = 1f
            arrayImgC.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        invalidate()
    }

    fun  imagenes2() {
        if (puntero.xS > 0) {
            x1 = 0f
            arrayImgB.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        if (puntero.xS <0) {
            x1 = 1f
            arrayImgB.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        invalidate()
    }
    fun  imagenes3() {
        if (puntero.xS > 0) {
            x1 = 0f
            arrayImgV.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        if (puntero.xS <0) {
            x1 = 1f
            arrayImgV.forEach {
                it.mover(x1)
            }
            invalidate()
        }
        invalidate()
    }


    override fun onTouchEvent(e: MotionEvent): Boolean {

        when(e.action) {
            MotionEvent.ACTION_DOWN -> {
                if (icono1.estaEnArea(e.getX(), e.getY()) ||
                    icono11.estaEnArea(e.getX(), e.getY()) ||
                    icono21.estaEnArea(e.getX(), e.getY())
                )
                {
                    Toast.makeText(puntero, "Tocaste el arbol", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono1

                }
                if (icono2.estaEnArea(e.getX(), e.getY()) ||
                    icono12.estaEnArea(e.getX(), e.getY()) ||
                    icono22.estaEnArea(e.getX(), e.getY())
                ) {
                    Toast.makeText(puntero, "Tocaste las cartas", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono2
                }
                if (icono3.estaEnArea(e.getX(), e.getY()) ||
                    icono13.estaEnArea(e.getX(), e.getY()) ||
                    icono23.estaEnArea(e.getX(), e.getY())
                ) {
                    Toast.makeText(puntero, "Tocaste las esferas", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono3
                }
                if (icono4.estaEnArea(e.getX(), e.getY()) ||
                    icono14.estaEnArea(e.getX(), e.getY()) ||
                    icono24.estaEnArea(e.getX(), e.getY())
                ) {
                    Toast.makeText(puntero, "Tocaste al oso", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono4
                }
                if (icono5.estaEnArea(e.getX(), e.getY()) ||
                    icono15.estaEnArea(e.getX(), e.getY()) ||
                    icono25.estaEnArea(e.getX(), e.getY())
                ) {
                    Toast.makeText(puntero, "Tocaste a santa", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono5
                }
            }
        }
        return true
    }

}//class Lienzo