package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.util.DateUtil;
import br.com.senaijandira.alunos.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    VisualizarPresenter presenter;

    int idAluno;

    TextView txtnome, txtDtNasc, txtMatricula, txtCpf, txtMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        idAluno = getIntent().getIntExtra("idAluno", 0);

        txtnome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNascimento);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);
        txtMedia = findViewById(R.id.txtMedia);

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

        String dataConvertida = new DateUtil().convetDate(String.valueOf(aluno.getDataNascimento()));

        txtnome.setText(aluno.getNome());
        txtDtNasc.setText(dataConvertida);
        txtMatricula.setText(String.valueOf(aluno.getMatricula()));
        txtCpf.setText(aluno.getCpf());
        txtMedia.setText("7.5");

    }
}
