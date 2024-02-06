package com.example.layoutinflator

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout
//    lateinit var myAdapter: MyAdapter
//    lateinit var viewAdapter: ViewPageAdapter
    lateinit var categoryRecycler : RecyclerView
    lateinit var viewPager2: ViewPager2
    lateinit var marqueeText : TextView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    lateinit var indicator : CircleIndicator3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linearLayout)

        setUpViews()


    }

    private fun setUpViews() {
        setToolBar()
        setAnnouncementBar()
        setCategoryItemViews()
        setBannerSlider()
        setFixedBanner()
        setUpRecommendedLayout()
        setUpLargeFixedBanner()
        setViewAllLayout()
    }

    private fun setViewAllLayout() {
        val view = layoutInflater.inflate(R.layout.view_all,null)
        linearLayout.addView(view)
    }


    private fun setUpLargeFixedBanner() {
        val view = layoutInflater.inflate(R.layout.large_fixed_banner,null)
        linearLayout.addView(view)
    }

    private fun setUpRecommendedLayout() {
        val view = layoutInflater.inflate(R.layout.static_text_layout,null)

        linearLayout.addView(view)
    }

    private fun setFixedBanner() {
        val view = layoutInflater.inflate(R.layout.fixed_banner,null)

        linearLayout.addView(view)
    }

    private fun setBannerSlider() {
        val view = layoutInflater.inflate(R.layout.banner_slider,null)

        viewPager2 =view.findViewById<ViewPager2>(R.id.viewPager)
        indicator=view.findViewById<CircleIndicator3>(R.id.indicator)

        val bannerTextArray = arrayOf(
            "item1",
            "item2",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
        )

        val bannerImageArray = arrayOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4,
            R.drawable.banner5,
            R.drawable.banner6,
            R.drawable.banner7,
            R.drawable.banner8,
        )

        val bannerItemList = arrayListOf<ViewPage>()

        for(index in bannerTextArray.indices)
        {
            var items = ViewPage(bannerTextArray[index],bannerImageArray[index])
            bannerItemList.add(items)
        }


        viewPager2.adapter = ViewPageAdapter(bannerItemList)
        viewPager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL


        indicator.setViewPager(viewPager2)

        linearLayout.addView(view)


    }

    private fun setCategoryItemViews() {
        val view = layoutInflater.inflate(R.layout.category_item_list,null)
        categoryRecycler= view.findViewById(R.id.categoryRecycler)

        val categoryTextArray = arrayOf(
            "Bakery",
            "Fruits",
            "Laptops",
            "Books",
            "Soaps",
            "Grocery",
            "Pottery",
            "Honey",
        )

        val categoryImageArray = arrayOf(
           R.drawable.bakery,
           R.drawable.fruits,
           R.drawable.laptops,
           R.drawable.books,
           R.drawable.soaps,
           R.drawable.grocery,
           R.drawable.pottery,
           R.drawable.honey,

        )

        val categoryArrayList = arrayListOf<Category>()

        for(index in categoryTextArray.indices)
        {
            var items = Category(categoryTextArray[index],categoryImageArray[index])
            categoryArrayList.add(items)
        }

        categoryRecycler.layoutManager = LinearLayoutManager(this)
        categoryRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        categoryRecycler.adapter = MyAdapter(this,categoryArrayList,)


        linearLayout.addView(view)

    }

    private fun setAnnouncementBar() {
        val view = layoutInflater.inflate(R.layout.announcement_bar,null)
        marqueeText=view.findViewById(R.id.marqueeText)
        marqueeText.isSelected=true
        linearLayout.addView(view)
    }

    private fun setToolBar() {

        val view = layoutInflater.inflate(R.layout.action_bar,null)

        linearLayout.addView(view)


    }
}