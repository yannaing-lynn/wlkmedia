package com.wlkmultimedia.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.mancj.materialsearchbar.MaterialSearchBar
import com.wlkmultimedia.R
import com.wlkmultimedia.ui.main.tabsfragment.*
import com.wlkmultimedia.utils.FontUtil.Companion.isValid
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnClickListener, MaterialSearchBar.OnSearchActionListener  {
    override fun onButtonClicked(buttonCode: Int) {
        when (buttonCode) {
            MaterialSearchBar.BUTTON_NAVIGATION -> drawer_layout.openDrawer(Gravity.LEFT)
            MaterialSearchBar.BUTTON_SPEECH -> {
            }
            MaterialSearchBar.BUTTON_BACK -> searchBar.disableSearch()
        }
    }

    override fun onSearchStateChanged(enabled: Boolean) {

    }

    override fun onSearchConfirmed(text: CharSequence?) {

    }

    override fun onClick(p0: View?) {

    }

    private lateinit var searchBar:MaterialSearchBar
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Home())
        val currentLocale = Locale.getDefault().language
        isValid = if (currentLocale.toString() == "my") {
            setLocale("my")
            true
        } else {
            setLocale("zy")
            false
        }
        val t = ActionBarDrawerToggle(
            this,
            drawer_layout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        toolbar = findViewById(R.id.toolbar)
        drawer_layout.addDrawerListener(t)
        //t.syncState()
        setSupportActionBar(toolbar)
        nv.setNavigationItemSelectedListener { p0 ->
            when (p0.itemId) {
                R.id.account -> {
                }
                R.id.settings -> {

                }
                R.id.mycart -> {

                }
            }
            val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        tabs.addTab(tabs.newTab().setText("Home"))
        tabs.addTab(tabs.newTab().setText("Korea"))
        tabs.addTab(tabs.newTab().setText("Movies"))
        tabs.addTab(tabs.newTab().setText("News"))
        tabs.addTab(tabs.newTab().setText("TV"))
        tabs.addTab(tabs.newTab().setText("Crime"))
        tabs.addTab(tabs.newTab().setText("Drama"))
        tabs.setOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0?.position==0){
                    loadFragment(Home())
                }else if(p0?.position==1){
                    loadFragment(Korea())
                }else if (p0?.position==2){
                    loadFragment(Movies())
                }else if (p0?.position==3){
                    loadFragment(News())
                }else if (p0?.position==4){
                    loadFragment(TV())
                }else if (p0?.position==5){
                    loadFragment(Crime())
                }else if (p0?.position==6){
                    loadFragment(Drama())
                }
            }
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }


        })


    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragmentContainer, fragment)
                .commit()
            return true
        }
        return false
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }
    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        val config = baseContext.resources.configuration
        Locale.setDefault(locale)
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }
}
