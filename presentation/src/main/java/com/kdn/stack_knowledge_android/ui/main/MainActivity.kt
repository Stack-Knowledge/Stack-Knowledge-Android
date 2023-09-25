package com.kdn.stack_knowledge_android.ui.main

import androidx.navigation.ui.setupWithNavController
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.main.RankingListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.ActivityMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this) }
    private val fragmentManager: FragmentManager = supportFragmentManager
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var rankingListAdapter: RankingListAdapter

    override fun createView() {
        showViewPager()
        showIndicator()
        initRecyclerView()
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

    private fun showViewPager() {
        binding.vpMainViewPager.adapter = mainViewPagerAdapter
    }

    private fun showIndicator() {
        binding.vpMainViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBannerTabLayout.getTabAt(position)?.select()
            }
        })
    }

    private fun initRecyclerView() {
        missionListAdapter = MissionListAdapter(listOf())
        rankingListAdapter = RankingListAdapter(listOf())
        binding.rvMission.adapter = missionListAdapter
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvMission.addItemDecoration(ItemDecorator(16))
        binding.rvRanking.addItemDecoration(ItemDecorator(16))
    }
}