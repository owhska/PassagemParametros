package br.com.matheusbrunes.passagemparametros

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.matheusbrunes.passagemparametros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Forma legada

       // val email = findViewById<EditText>(R.id.input_email)
       // val password = findViewById<EditText>(R.id.input_password)
       // val btnLogin = findViewById<Button>(R.id.btn_login)
       // val btnRegister = findViewById<Button>(R.id.btn_register)

        //Forma com "jetpack"

        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if(v?.id == R.id.btn_login){
            println("login")
        }


        if(v?.id == R.id.btn_register){
            println("registro")
        }
    }

}