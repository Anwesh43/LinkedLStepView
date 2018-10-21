package com.anwesh.uiprojects.lstepview

/**
 * Created by anweshmishra on 21/10/18.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.content.Context

val nodes : Int = 5

fun Canvas.drawLStep(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / 3
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.parseColor("#3F51B5")
    save()
    translate(gap * i + gap, h/2)
    for (j in 0..1) {
        val sc : Float = Math.min(0.5f, Math.min(0f, scale - 0.5f * j)) * 2
        save()
        rotate(-90f * j)
        drawLine(0f, 0f, (size/2 * j + size/2) * sc, 0f, paint)
        restore()
    }
    restore()
}