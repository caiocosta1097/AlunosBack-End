package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    VisualizarPresenter presenter;

    int idAluno;

    TextView txtnome, txtDtNasc, txtMatricula, txtCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        idAluno = getIntent().getIntExtra("idAluno", 0);

        txtnome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNascimento);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);

        presenter = new VisualizarPresenter(this, ServiceFactory.create());

        Log.d("ID_Aluno", idAluno+"");

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarAluno(idAluno);

    }

    @Override
    public void pegarAluno(Aluno aluno) {



        txtnome.setText(aluno.getNome());
        txtDtNasc.setText(String.valueOf(aluno.getDataNascimento()));
        txtMatricula.setText(String.valueOf(aluno.getMatricula()));
        txtCpf.setText(aluno.getCpf());

    }
}
