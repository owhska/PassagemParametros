package br.com.matheusbrunes.passagemparametros

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast
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
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btn_register) {

            val nome = binding.inputNome.text.toString()
            val email = binding.inputEmail.text.toString()
            val idade = binding.inputIdade.text.toString()
            val curso = binding.inputCurso.text.toString()
            val endereco = binding.inputEndereco.text.toString()

            // Validações
            if (nome.isEmpty()) {
                binding.inputNome.error = "Digite seu nome"
                return
            }

            if (email.isEmpty()) {
                binding.inputEmail.error = "Digite seu email"
                return
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.inputEmail.error = "Email inválido"
                return
            }

            if (idade.isEmpty()) {
                binding.inputIdade.error = "Digite sua idade"
                return
            }

            val idadeInt = idade.toIntOrNull()
            if (idadeInt == null || idadeInt <= 0) {
                binding.inputIdade.error = "Idade inválida"
                return
            }

            if (curso.isEmpty()) {
                binding.inputCurso.error = "Digite seu curso"
                return
            }

            if (endereco.isEmpty()) {
                binding.inputEndereco.error = "Digite seu endereço"
                return
            }

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ConfirmarDados::class.java)

            intent.putExtra("nome", nome)
            intent.putExtra("email", email)
            intent.putExtra("idade", idadeInt)
            intent.putExtra("curso", curso)
            intent.putExtra("endereco", endereco)

            startActivity(intent)
        }
    }

}