package devandroid.filipe.exefixacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Criando componentes e linkando o id

        EditText editName = findViewById(R.id.editName);
        EditText editAge = findViewById(R.id.editAge);
        EditText editSex = findViewById(R.id.editSex);
        EditText editPhone = findViewById(R.id.editPhone);
        Button btGo = findViewById(R.id.btGo);
        Button btClear = findViewById(R.id.btClear);
        Button btSave = findViewById(R.id.btSave);


        //Criando Intent e Interações

        //Mudar a página
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //Limpa os dados do Formulário

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editName.setText("");
                editAge.setText("");
                editSex.setText("");
                editPhone.setText("");
                Toast.makeText(MainActivity.this,"Dados Excluidos!",Toast.LENGTH_SHORT).show();
            }
        });

        //Salva os dados
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Dados.dados.setNome(String.valueOf(editName.getText()));
               Dados.dados.setIdade(Integer.parseInt(String.valueOf(editAge.getText())));
               Dados.dados.setSexo(String.valueOf(editSex.getText()));
               Dados.dados.setTelefone(String.valueOf(editPhone.getText()));

               Toast.makeText(MainActivity.this,"Dados Salvos com Sucesso!",Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}