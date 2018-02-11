package alancasasarevalo.com.ganggame.activities

import alancasasarevalo.com.ganggame.R
import alancasasarevalo.com.ganggame.fragments.DealsFragment
import alancasasarevalo.com.ganggame.fragments.TopOwnedFragment
import alancasasarevalo.com.ganggame.fragments.TopRatedFragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_OPTIONS = R.id.action_deals
    }

    private val fragments : HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewWithDefaultFragment()

        navigationView.selectedItemId = DEFAULT_OPTIONS

        navigationView.setOnNavigationItemSelectedListener{item ->
            val fragment : Fragment? = fragments[item.itemId]

            if (fragment != null){
                replaceErrorFragment( fragment )
            }

            true
        }
    }

    private fun replaceErrorFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    private fun initViewWithDefaultFragment() {
        val currentFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainer)

        if (currentFragment == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTIONS])
                    .commit()
        }
    }
}
