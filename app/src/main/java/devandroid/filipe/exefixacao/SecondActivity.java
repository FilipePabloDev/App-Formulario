package devandroid.filipe.exefixacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        TextView nameSave = (TextView) findViewById(R.id.nameSave);
        TextView ageSave = (TextView) findViewById(R.id.ageSave);
        TextView sexSave = (TextView) findViewById(R.id.sexSave);
        TextView phoneSave = (TextView) findViewById(R.id.phoneSave);
        Button btBack = (Button) findViewById(R.id.btBack);
        Button btClearDB = (Button) findViewById(R.id.btClearDB);

        nameSave.setText(Dados.dados.getNome());
        ageSave.setText(Dados.dados.getIdade()+"");
        sexSave.setText(Dados.dados.getSexo());
        phoneSave.setText(Dados.dados.getTelefone());

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btClearDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameSave.setText("");
                ageSave.setText("");
                sexSave.setText("");
                phoneSave.setText("");

                Dados.dados.setNome("");
                Dados.dados.setIdade(0);
                Dados.dados.setSexo("");
                Dados.dados.setTelefone("");
                Toast.makeText(SecondActivity.this,"Dados Excluidos",Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}