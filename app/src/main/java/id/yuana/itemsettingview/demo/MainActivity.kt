package id.yuana.itemsettingview.demo

import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initItemNotif1()

        initItemNotif2()

        initItemNotif3()
    }

    /**
     * Action Click
     */
    private fun initItemNotif1() {
        Log.d(TAG, "initItemNotif1: $itemNotif1")
        itemNotif1.setOnClickListener {
            Toast.makeText(this, "clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Custom Action View using Switch
     */
    private fun initItemNotif2() {
        val switch = Switch(this)
        switch.isChecked = true
        switch.setOnCheckedChangeListener { _, b ->
            Toast.makeText(this, "checked : " + b, Toast.LENGTH_SHORT).show()
        }

        itemNotif2.customViewAction = switch
    }

    /**
     * setup programatical
     */
    private fun initItemNotif3() {
        itemNotif3.setLabel(R.string.txt_notifications)
        itemNotif3.setDescription(R.string.txt_notifications_desc)
        itemNotif3.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_notifications))
        itemNotif3.setActionIcon(ContextCompat.getDrawable(this, R.drawable.ic_arrow_right))
        itemNotif3.setLabelColor(R.color.colorPrimary)
        itemNotif3.setDescriptionColor(R.color.colorPrimaryDark)
        itemNotif3.setOnClickListener {
            Toast.makeText(this, "clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
