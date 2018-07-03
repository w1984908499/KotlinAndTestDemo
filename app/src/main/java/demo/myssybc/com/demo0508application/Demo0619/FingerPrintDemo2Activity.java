package demo.myssybc.com.demo0508application.Demo0619;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;
import com.wei.android.lib.fingerprintidentify.base.BaseFingerprint;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.myssybc.com.demo0508application.R;

public class FingerPrintDemo2Activity extends Activity {


    FingerprintIdentify mFingerprintIdentify;

    private static final String TAG = "FingerPrintDemo2";
    Button btnFingerprintTest;
    @BindView(R.id.tv_isHardWareUse)
    TextView tvIsHardWareUse;
    @BindView(R.id.tv_isFingerPrintRecord)
    TextView tvIsFingerPrintRecord;
    @BindView(R.id.tv_isFingerPrintUse)
    TextView tvIsFingerPrintUse;
    @BindView(R.id.tv_isFingerPrintSuccess)
    TextView tvIsFingerPrintSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_demo);
        ButterKnife.bind(this);

        btnFingerprintTest = findViewById(R.id.btn_fingerprint_test);

        mFingerprintIdentify = new FingerprintIdentify(this, new BaseFingerprint.FingerprintIdentifyExceptionListener() {
            @Override
            public void onCatchException(Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });

        btnFingerprintTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

    }


    private void fingerpringt() {
        if (mFingerprintIdentify.isFingerprintEnable()) {
            mFingerprintIdentify.startIdentify(3, new BaseFingerprint.FingerprintIdentifyListener() {
                @Override
                public void onSucceed() {
                    Log.e(TAG, "验证成功，自动结束指纹识别");
//                            tvIsFingerPrintSuccess.setText("验证成功，自动结束指纹识别");
                    Toast.makeText(FingerPrintDemo2Activity.this, "验证成功", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNotMatch(int availableTimes) {
                    Log.e(TAG, " 指纹不匹配，并返回可用剩余次数并自动继续验证");
//                            tvIsFingerPrintRecord.setText();
                    Toast.makeText(FingerPrintDemo2Activity.this, "指纹不匹配,剩余" + availableTimes + "次", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed(boolean isDeviceLocked) {
                    // 错误次数达到上限或者API报错停止了验证，自动结束指纹识别
                    // isDeviceLocked 表示指纹硬件是否被暂时锁定
                    Log.e(TAG, "错误次数达到上限或者API报错停止了验证");
                    tvIsHardWareUse.setText("错误次数达到上限或者API报错停止了验证");

                }

                @Override
                public void onStartFailedByDeviceLocked() {
                    // 第一次调用startIdentify失败，因为设备被暂时锁定
                    Log.e(TAG, " // 第一次调用startIdentify失败，因为设备被暂时锁定");
                }
            });
        }
    }
}
