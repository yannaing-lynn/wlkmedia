package com.wlkmultimedia.ui.main.navfragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wlkmultimedia.R
import com.wlkmultimedia.model.HomeModel
import com.wlkmultimedia.model.HomeSubModel
import com.wlkmultimedia.ui.main.VideoPlayActivity
import com.wlkmultimedia.ui.main.adapters.kidadapter.KidsRecyclerAdpter
import kotlinx.android.synthetic.main.fragment_kids.*

/**
 * A simple [Fragment] subclass.
 */
class Kids : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kids, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewFlipper.setInAnimation(activity, android.R.anim.slide_in_left)
        viewFlipper.setOutAnimation(activity, android.R.anim.slide_out_right)
        viewFlipper.startFlipping()
//        if (viewFlipper != null) {
//            for (image in imageList) {
//                val imageView = ImageView(activity)
//                //val layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//                //layoutParams.setMargins(30, 30, 30, 30)
//                //layoutParams.gravity = Gravity.CENTER
//                //imageView.layoutParams = layoutParams
//                imageView.scaleType = ImageView.ScaleType.FIT_XY
//                imageView.setImageResource(image)
//                viewFlipper.addView(imageView)
//            }
//        }

        val lm = LinearLayoutManager(activity)
        rvHome.layoutManager = lm
        val homeRecyclerAdpter = KidsRecyclerAdpter(generateHomeList()) { vh, pos ->
        }
        rvHome.adapter = homeRecyclerAdpter
        rvHome.isNestedScrollingEnabled = false
        svHome.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY > oldScrollY) {
                ibFlipOne.animate().alpha(0f).setDuration(100).start()
            } else {
                ibFlipOne.animate().alpha(1f).setDuration(100).start()
            }
        })

        ibFlipOne.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    VideoPlayActivity::class.java
                )
            )
        }
        ibFlipTwo.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    VideoPlayActivity::class.java
                )
            )
        }
        ibFlipThree.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    VideoPlayActivity::class.java
                )
            )
        }

    }

    private fun generateHomeList(): ArrayList<HomeModel> {
        val list = ArrayList<HomeModel>()
        val one = HomeModel("Continue Watching", generateSubList())
        list.add(one)

        val two = HomeModel("Cartoon Movie", generateSubList2())
        list.add(two)

        val three = HomeModel("Advenger", generateSubList())
        list.add(three)

        val four = HomeModel("Child Play", generateSubList2())
        list.add(four)

        return list
    }

    private fun generateSubList2(): ArrayList<HomeSubModel> {
        val list = ArrayList<HomeSubModel>()
        val one = HomeSubModel(
            "Dory",
            R.drawable.car1
        )
        list.add(one)

        val two = HomeSubModel(
            "Grinch",
            R.drawable.car2
        )
        list.add(two)

        val four = HomeSubModel(
            "Panda",
            R.drawable.car3
        )
        list.add(four)
        val five = HomeSubModel(
            "Lost Girl",
            R.drawable.lostgirl
        )
        list.add(five)
        val six = HomeSubModel(
            "Now Playing",
            R.drawable.avengers
        )
        list.add(six)
        val seven = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(seven)
        val eight = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(eight)
        val nine = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(nine)

        return list
    }

    private fun generateSubList(): ArrayList<HomeSubModel> {
        val list = ArrayList<HomeSubModel>()
        val one = HomeSubModel(
            "Captain Marvel",
            R.drawable.captain_marve
        )
        list.add(one)

        val two = HomeSubModel(
            "Halloween",
            R.drawable.hollowen
        )
        list.add(two)

        val four = HomeSubModel(
            "Avengers",
            R.drawable.avengers
        )
        list.add(four)
        val five = HomeSubModel(
            "Lost Girl",
            R.drawable.lostgirl
        )
        list.add(five)
        val six = HomeSubModel(
            "Now Playing",
            R.drawable.avengers
        )
        list.add(six)
        val seven = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(seven)
        val eight = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(eight)
        val nine = HomeSubModel(
            "Now Playing",
            R.drawable.captain_marve
        )
        list.add(nine)

        return list
    }

}
