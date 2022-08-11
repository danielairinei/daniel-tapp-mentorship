package com.example.mentorship.features.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private var percentage: Int = 0
    private var percentageTextView: String

    private val paintFill = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    private val paintBorder = Paint().apply {
        color = Color.GRAY
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    private val paintText = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
        textSize = 60f
    }

    init {
        percentageTextView = percentage.toString()
    }

    fun setPercentage(newValue: Int) {
        if (newValue > 100) {
            this.percentage = 100
        } else {
            this.percentage = newValue
        }
        percentageTextView = percentage.toString()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0F, 0F, width.toFloat() * percentage / 100, 110f, paintFill)
        canvas.drawRect(0F, 0F, width.toFloat(), 110f, paintBorder)
        canvas.drawText(percentageTextView, (width / 2).toFloat(), 70f, paintText)

        invalidate()
    }
}