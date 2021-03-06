package com.sha.bulletin

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

/**
 * [LinearLayout] that wraps the icon of the [Bulletin].
 */
class IconContainer: LinearLayout {
    lateinit var rectangleView: View
    private lateinit var ivIcon: ImageView
    lateinit var ivTriangle: TriangleImageView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun onFinishInflate() {
        super.onFinishInflate()
        rectangleView = findViewById(R.id.rectangleView)
        ivIcon = findViewById(R.id.ivIcon)
        ivTriangle = findViewById(R.id.ivTriangle)
    }

    fun setup(setup: IconSetup) {
        if (setup.iconDrawableRes == -1){
            visibility = View.GONE
            return
        }
        visibility = View.VISIBLE
        ivIcon.setImageResource(setup.iconDrawableRes)

        if (setup.containerColorRes == -1)
            setup.containerColorRes = BulletinConfig.iconSetup.containerColorRes

        ContextCompat.getColor(context, setup.containerColorRes).run {
            rectangleView.setBackgroundColor(this)
            ivTriangle.color = this
        }
    }

}