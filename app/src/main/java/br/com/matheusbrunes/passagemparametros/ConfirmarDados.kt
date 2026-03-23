package br.com.matheusbrunes.passagemparametros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class ConfirmarDados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar_dados)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val idade = intent.getIntExtra("idade", 0)
        val curso = intent.getStringExtra("curso")
        val endereco = intent.getStringExtra("endereco")

        val txtNome = findViewById<TextView>(R.id.txt_nome)
        val txtEmail = findViewById<TextView>(R.id.txt_email)
        val txtIdade = findViewById<TextView>(R.id.txt_idade)
        val txtCurso = findViewById<TextView>(R.id.txt_curso)
        val txtEndereco = findViewById<TextView>(R.id.txt_endereco)

        txtNome.text = "Nome: $nome"
        txtEmail.text = "Email: $email"
        txtIdade.text = "Idade: $idade"
        txtCurso.text = "Curso: $curso"
        txtEndereco.text = "Endereço: $endereco"

        val btnConfirmar = findViewById<Button>(R.id.btn_confirmar)

        btnConfirmar.setOnClickListener {

            val intent = Intent(this, TelaFinal::class.java)
            startActivity(intent)

        }
    }
}