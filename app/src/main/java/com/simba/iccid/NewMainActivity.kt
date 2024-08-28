package com.simba.iccid

import android.util.Log
import android.widget.Toast
import com.simba.iccid.databinding.ActivityMainBinding
import com.simba.proto.GRPCUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2024/7/30
 *    @Desc   :
 *    @Version:
 */
class NewMainActivity : BaseVMActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    override fun initView() {
        binding.apply {
            btnStart.setOnClickListener {
                if (editText.text.isNullOrEmpty()) {
                    Toast.makeText(this@NewMainActivity, "不能为空...", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                Log.e("UserClient", "start: ${editText.text.toString()} 密码：${pwd.text}")
                CoroutineScope(Dispatchers.IO).launch {
                    GRPCUtils.login(
                        this@NewMainActivity,
                        editText.text.toString(),
                        pwd.text.toString()
                    )
                }
            }
        }
    }

    override fun initData() {

    }

    override fun startObserve() {

    }
}