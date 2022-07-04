package fr.gogo.esgifive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CardView>(R.id.cardViewNewTeam).setOnClickListener{
            val intent = Intent(this,CreateTeamActivity::class.java)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.cardViewNewMatch).setOnClickListener{
            val intent = Intent(this,CreateMatchActivity::class.java)
            startActivity(intent)
        }
    }




}

