package com.kdn.stack_knowledge_android.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        createView()
        observeEvent()
    }

    abstract fun createView()

    abstract fun observeEvent()

    protected fun shortToast(kdn: String){
        Toast.makeText(this, kdn, Toast.LENGTH_SHORT).show()
    }

    protected fun longToast(kdn: String){
        Toast.makeText(this, kdn, Toast.LENGTH_LONG).show()
    }

}