package demo.myssybc.com.demo0508application.Demo0619

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.wei.android.lib.fingerprintidentify.FingerprintIdentify
import com.wei.android.lib.fingerprintidentify.base.BaseFingerprint
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_fingerprint_demo.*
import org.jetbrains.anko.toast

class KotlinFingerPrintTestActivity : Activity() {

    var mFingerprintIdentify: FingerprintIdentify? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint_demo)

        mFingerprintIdentify = FingerprintIdentify(this, object : BaseFingerprint.FingerprintIdentifyExceptionListener {
            override fun onCatchException(exception: Throwable?) {
                Log.e("exception", exception?.message)
            }

        })
        btn_fingerprint_test.setOnClickListener {
            mFingerprintIdentify!!.startIdentify(3, object : BaseFingerprint.FingerprintIdentifyListener {
                override fun onSucceed() {
                    toast("指纹验证成功")
                }

                override fun onFailed(isDeviceLocked: Boolean) {

                }

                override fun onNotMatch(availableTimes: Int) {
                    toast("指纹不匹配,剩余" + availableTimes + "次")
                }

                override fun onStartFailedByDeviceLocked() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        }

    }
}
