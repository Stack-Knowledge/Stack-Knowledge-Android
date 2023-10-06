package com.kdn.stack_knowledge_android.ui.main

import androidx.navigation.ui.setupWithNavController
import androidx.navigation.fragment.findNavController
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ActivityMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun createView() {
        initBottomNav()
    }

    override fun observeEvent() {

    }


    private fun initBottomNav() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fcv_fragment_container)
                ?.findNavController()
        val nav = binding.bnMainBottomNavi
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }
}