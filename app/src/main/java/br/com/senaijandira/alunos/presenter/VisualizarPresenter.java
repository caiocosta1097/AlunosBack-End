package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 17259196 on 05/11/2018.
 */

public class VisualizarPresenter {

    VisualizarView visualizarView;
    AlunoService service;

    public VisualizarPresenter(VisualizarView visualizarView, AlunoService service){

        this.visualizarView = visualizarView;
        this.service = service;

    }

    public void carregarAluno(int idAluno){

        Call<Aluno> call = service.obterAlunoPorId(idAluno);

        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {

                Aluno aluno = response.body();

                visualizarView.pegarAluno(aluno);

            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {

            }
        });

    }

}
