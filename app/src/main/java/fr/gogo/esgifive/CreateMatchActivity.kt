package fr.gogo.esgifive

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


class CreateMatchActivity : AppCompatActivity() {

    lateinit var lv: ListView
    lateinit var btnStart: Button

    var listTeams = DataTeams.getTeams()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_match)

        //aller au nouveau match
        findViewById<Button>(R.id.btnStart).setOnClickListener{
            val intent = Intent(this,MatchActivity::class.java)
            startActivity(intent)
        }

        val actionbar = supportActionBar
        actionbar!!.title = ""
        actionbar.setDisplayHomeAsUpEnabled(true)

        lv = findViewById(R.id.list_teams)
        btnStart = findViewById(R.id.btnStart)

        val adapter = ArrayAdapter<Team>(this,
        android.R.layout.simple_list_item_activated_1, listTeams)
        lv.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        lv.adapter = adapter




        //CLICK SUR UNE EQUIPE
        lv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemText = parent.getItemAtPosition(position)
                println(lv.checkedItemCount)
                btnStart.isVisible = lv.checkedItemCount >= 2

                /*if(lv.checkedItemCount > 2){
                    lv.setItemChecked(0,false)
                }*/
            }


    }
}