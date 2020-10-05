package id.yuana.itemsettingview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_item_setting.view.*

/**
 * Created by yuana on 1/28/18.
 */

class ItemSettingView : FrameLayout {

    private var mView: View? = null
    private var viewCustomAction: View? = null

    private var strLabel: String? = null
    private var strDescription: String? = null
    private var drawableIcon: Drawable? = null
    private var drawableActionIcon: Drawable? = null
    private var colorLabel: Int = 0
    private var colorDescription: Int = 0
    private var clickableAction: Boolean = true
    private var cardBackgroundColor: Int = 0
    private var cardCornerRadius: Float = 0f
    private var cardStroke: Int = 0
    private var cardStrokeColor: Int = 0
    private val gradientDrawable = GradientDrawable()

    private val inflater: LayoutInflater
        get() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    var customViewAction: View?
        get() {
            if (viewCustomAction == null)
                throw IllegalStateException("Please setCustomViewAction first!")
            return viewCustomAction
        }
        set(customView) {
            removeDefaultAction()
            llHeader!!.addView(customView)
            viewCustomAction = customView
        }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context, attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        displayAttrs()
    }

    private fun displayAttrs() {
        setLabel(strLabel)
        setDescription(strDescription)
        setIcon(drawableIcon)
        setActionIcon(drawableActionIcon)
        setLabelColor(colorLabel)
        setDescriptionColor(colorDescription)
        setClickableAction(clickableAction)
        setCardBackgroundColor(cardBackgroundColor)
        setCardCornerRadius(cardCornerRadius)
        setCardStrokeWidth(cardStroke)
        setCardStrokeColor(cardStrokeColor)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        inflateView()

        val a = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ItemSettingView,
            0, 0
        )

        try {
            strLabel = a.getString(R.styleable.ItemSettingView_settingLabel)
            strDescription = a.getString(R.styleable.ItemSettingView_settingDescription)
            drawableActionIcon = a.getDrawable(R.styleable.ItemSettingView_settingActionIcon)
            drawableIcon = a.getDrawable(R.styleable.ItemSettingView_settingIcon)
            colorLabel = a.getColor(
                R.styleable.ItemSettingView_settingLabelColor,
                Color.DKGRAY
            )
            colorDescription = a.getColor(
                R.styleable.ItemSettingView_settingDescriptionColor,
                Color.DKGRAY
            )
            clickableAction = a.getBoolean(
                R.styleable.ItemSettingView_settingClickable,
                true
            )
            cardBackgroundColor = a.getColor(
                R.styleable.ItemSettingView_settingCardStrokeColor,
                Color.TRANSPARENT
            )
            cardCornerRadius = a.getFloat(
                R.styleable.ItemSettingView_settingCardCornerRadius,
                0f
            )
            cardStroke = a.getInt(
                R.styleable.ItemSettingView_settingCardStroke,
                0
            )
            cardStrokeColor = a.getColor(
                R.styleable.ItemSettingView_settingCardStrokeColor,
                Color.DKGRAY
            )
        } finally {
            a.recycle()
        }
    }

    private fun inflateView() {
        mView = inflater.inflate(R.layout.view_item_setting, this)
    }

    private fun removeDefaultAction() {
        (ivAction!!.parent as ViewGroup).removeView(ivAction)
    }

    private fun clickable(isClickable: Boolean) {
        if (isClickable) {
            flContainer.background = ContextCompat.getDrawable(context, R.drawable.item_selector)
        } else {
            flContainer.background = ContextCompat.getDrawable(context, android.R.color.transparent)
        }
    }

    fun setLabel(label: String?) {
        tvLabel!!.text = label
        invalidateAndRequestLayout()
    }

    fun setLabel(label: Int) {
        tvLabel!!.setText(label)
        invalidateAndRequestLayout()
    }

    fun setDescription(description: String?) {
        tvDescription!!.text = description
        invalidateAndRequestLayout()
    }

    fun setDescription(description: Int) {
        tvDescription!!.setText(description)
        invalidateAndRequestLayout()
    }

    fun setActionIcon(drawableActionIcon: Drawable?) {
        ivAction!!.setImageDrawable(drawableActionIcon)
        invalidateAndRequestLayout()
    }

    fun setIcon(drawableIcon: Drawable?) {
        ivIcon!!.setImageDrawable(drawableIcon)
        invalidateAndRequestLayout()
    }

    fun setDescriptionColor(colorDescription: Int) {
        tvDescription!!.setTextColor(colorDescription)
        invalidateAndRequestLayout()
    }

    fun setLabelColor(colorLabel: Int) {
        tvLabel!!.setTextColor(colorLabel)
        invalidateAndRequestLayout()
    }

    fun setClickableAction(clickable: Boolean) {
        clickable(clickable)
        invalidateAndRequestLayout()
    }

    fun setCardBackgroundColor(color: Int) {
        gradientDrawable.setColor(color)

        setBackgroundAttrs()
    }

    fun setCardCornerRadius(radius: Float) {
        gradientDrawable.cornerRadius = radius

        setBackgroundAttrs()
    }

    fun setCardStrokeWidth(width: Int) {
        gradientDrawable.setStroke(width, cardStrokeColor)

        setBackgroundAttrs()
    }

    fun setCardStrokeColor(color: Int) {
        gradientDrawable.setStroke(cardStroke, color)

        setBackgroundAttrs()
    }

    private fun setBackgroundAttrs() {
        llContainer.background = gradientDrawable
        invalidateAndRequestLayout()
    }

    private fun invalidateAndRequestLayout() {
        invalidate()
        requestLayout()
    }

}
