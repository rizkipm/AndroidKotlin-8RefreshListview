package superheroku.id.co.kotlin8refreshlistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary",
            "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich",
            "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,
                R.layout.listview_item, array)

        val listView: ListView = findViewById(R.id.listview_1)
        listView.setAdapter(adapter)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(applicationContext,
                        "Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG)
                        .show()
            }
        }

        val change_btn = findViewById(R.id.change) as Button
        change_btn.setOnClickListener {
            // data in the source array has been changed
            array.set(0,"New City")
            array.set(1,"Another New City")
        }

        val btn_click_me = findViewById(R.id.refresh) as Button
        btn_click_me.setOnClickListener {
            // let the adapter know that data set has been changed
            // adapter will notify respective views and the views shall refresh
            adapter.notifyDataSetChanged()
        }
    }
}
