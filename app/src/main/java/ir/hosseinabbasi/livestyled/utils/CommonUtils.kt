package ir.hosseinabbasi.livestyled.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import ir.hosseinabbasi.livestyled.R

/**
 * Created by Dr.jacky on 2018/06/15.
 */
class CommonUtils {
    companion object {
        fun showLoadingDialog(context : Context) : ProgressDialog {
            val progressDialog = ProgressDialog(context)
            progressDialog.show()
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(true)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }
    }
}