package id.yuana.itemsettingview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.view_item_setting.view.*

/**
 * Created by yuana on 1/28/18.
 */

class ItemSettingView : LinearLayout {

    private var mView: View? = null
    private var viewCustomAction: View? = null

    private var strLabel: String? = null
    private var strDescription: String? = null
    private var drawableIcon: Drawable? = null
    private var drawableActionIcon: Drawable? = null
    private var colorLabel: Int = 0
    private var colorDescription: Int = 0
    private var clickableAction: Boolean = true

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

    constructor(context: Context, attrs: AttributeSet? = null): super(context) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
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
    }

    private fun init(context: Context, attrs: AttributeSet?) {

        inflateView()

        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.ItemSettingView,
                0, 0)

        try {
            strLabel = a.getString(R.styleable.ItemSettingView_settingLabel)
            strDescription = a.getString(R.styleable.ItemSettingView_settingDescription)
            drawableActionIcon = a.getDrawable(R.styleable.ItemSettingView_settingActionIcon)
            drawableIcon = a.getDrawable(R.styleable.ItemSettingView_settingIcon)
            colorLabel = a.getColor(
                    R.styleable.ItemSettingView_settingLabelColor,
                    getColorDefault(context))
            colorDescription = a.getColor(
                    R.styleable.ItemSettingView_settingDescriptionColor,
                    getColorDefault(context))
            clickableAction = a.getBoolean(R.styleable.ItemSettingView_settingClickable, true)

            // clickable
            clickable(clickableAction)
        } finally {
            a.recycle()
        }
    }

    private fun getColorDefault(context: Context): Int {
        return ContextCompat.getColor(context, android.R.color.darker_gray)
    }

    private fun inflateView() {
        mView = inflater.inflate(R.layout.view_item_setting, this)
    }

    private fun removeDefaultAction() {
        (ivAction!!.parent as ViewGroup).removeView(ivAction)
    }

    @SuppressLint("ResourceType")
    private fun clickable(isClickable: Boolean){
        if (isClickable) {
//            llContainer.background = resources.getDrawable(R.drawable.linear_layout_selector)
            llContainer.isClickable = true
            llContainer.isFocusable = true
        } else {
            llContainer.background = ContextCompat.getDrawable(context, android.R.color.transparent)
            llContainer.isClickable = false
            llContainer.isFocusable = false
        }
        invalidateAndRequestLayout()
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
    }

    private fun invalidateAndRequestLayout() {
        invalidate()
        requestLayout()
    }

}
