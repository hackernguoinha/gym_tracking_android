package namle.tutorial.gymtracer.utils

import android.content.Context
import android.graphics.Color
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import namle.tutorial.gymtracer.R

object ToastUtil {
    fun showSuccess(context: Context, message: String){
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.toast_custom, null)

        view.findViewById<TextView>(R.id.txtToast).setTextColor(Color.BLACK)
        view.findViewById<TextView>(R.id.txtToast).text = message

        val toast = Toast(context.applicationContext)
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
    fun showFail(context: Context, message: String){
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.toast_custom, null)

        view.findViewById<TextView>(R.id.txtToast).setTextColor(Color.RED)
        view.findViewById<TextView>(R.id.txtToast).text = message

        val toast = Toast(context.applicationContext)
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}