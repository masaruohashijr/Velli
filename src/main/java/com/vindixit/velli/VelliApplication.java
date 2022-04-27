package com.vindixit.velli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vindixit.velli.entidade.Entidade;
import com.vindixit.velli.entidade.EntidadeRepository;
import com.vindixit.velli.escritorio.Escritorio;
import com.vindixit.velli.escritorio.EscritorioRepository;
import com.vindixit.velli.jurisdicao.Jurisdicao;
import com.vindixit.velli.jurisdicao.JurisdicaoRepository;
import com.vindixit.velli.membro.Membro;
import com.vindixit.velli.membro.MembroRepository;
import com.vindixit.velli.perfil.Perfil;
import com.vindixit.velli.perfil.PerfilRepository;
import com.vindixit.velli.plano.Plano;
import com.vindixit.velli.usuario.Usuario;
import com.vindixit.velli.usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VelliApplication {
	@Autowired
	private EntidadeRepository entidadeRepository;
	@Autowired
	private EscritorioRepository escritorioRepository;
	@Autowired
	private MembroRepository membroRepository;
	@Autowired
	private JurisdicaoRepository jurisdicaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilRepository perfilRepository;

	// @Bean
	public CommandLineRunner removeAll() {
		return (args) -> {
			perfilRepository.deleteAll();
			jurisdicaoRepository.deleteAll();
			membroRepository.deleteAll();
			usuarioRepository.deleteAll();
			entidadeRepository.deleteAll();
			escritorioRepository.deleteAll();
		};
	}

	//@Bean
	public CommandLineRunner criaEntidadeComoJurisdicaoDeEscritorio(EntidadeRepository repository) {
		return (args) -> {
			Entidade entidade = novaEntidadeMock();
			Escritorio escritorio = novoEscritorioMock();
			List<Jurisdicao> jurisdicoes = new ArrayList<Jurisdicao>();
			Jurisdicao jurisdicao = novaJurisdicao(entidade, escritorio);
			jurisdicoes.add(jurisdicao);
			escritorio.setJurisdicoes(jurisdicoes);
			entidade.setJurisdicoes(jurisdicoes);
			escritorioRepository.save(escritorio);
			jurisdicaoRepository.save(jurisdicao);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VelliApplication.class, args);
	}

	@Bean
	public CommandLineRunner criaEntidadeEPlano(EntidadeRepository repository) {
		return (args) -> {
			Entidade entidade = novaEntidadeMock();
			Plano plano = novoPlanoMock();
			List<Plano> planos = new ArrayList<Plano>();
			planos.add(plano);
			plano.setEntidade(entidade);
			entidade.setPlanos(planos);
			repository.save(entidade);
			repository.findAll().forEach(e -> {
				System.out.println(e.getName());
				System.out.println(e.getPlanos().size());
			});			
		};
	};

	//@Bean
	public CommandLineRunner criaUsuarioEPerfilComoMembroDeEscritorio(UsuarioRepository repository) {
		return (args) -> {
			Usuario usuario = novoUsuarioMock();
			Escritorio escritorio = novoEscritorioMock();
			Perfil perfil = novoPerfilMock();

			List<Membro> membros = new ArrayList<Membro>();
			Membro membro = novoMembro(usuario, escritorio);
			membros.add(membro);
			escritorio.setMembros(membros);

			List<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios.add(usuario);
			// perfilRepository.save(perfil);

			usuario.setPerfil(perfil);
			escritorio.setChefe(usuario);
			repository.save(usuario);
			escritorioRepository.save(escritorio);
			perfil.setUsers(usuarios);
			repository.findAll().forEach(u -> {
				System.out.println(u.getName());
				System.out.println(u.getPerfil().getName());
			});
		};
	}

	private Jurisdicao novaJurisdicao(Entidade entidade, Escritorio escritorio) {
		Jurisdicao jurisdicao = new Jurisdicao();
		jurisdicao.setEntidade(entidade);
		jurisdicao.setEscritorio(escritorio);
		jurisdicao.setIniciaEm(LocalDateTime.now());
		return jurisdicao;
	}

	private Membro novoMembro(Usuario usuario, Escritorio escritorio) {
		Membro membro = new Membro();
		membro.setUsuario(usuario);
		membro.setEscritorio(escritorio);
		membro.setIniciaEm(LocalDateTime.now());
		return membro;
	}

	private Perfil novoPerfilMock() {
		Perfil perfil = new Perfil();
		perfil.setName("Chefe");
		return perfil;
	}

	private Escritorio novoEscritorioMock() {
		Escritorio office = new Escritorio();
		office.setName("ERDF");
		return office;
	}

	private Usuario novoUsuarioMock() {
		Usuario user = new Usuario();
		user.setName("Fulano");
		user.setEmail("fulano@gmail.com");
		return user;
	}

	private Entidade novaEntidadeMock() {
		Entidade entidade = new Entidade();
		entidade.setName("SISTEL");
		return entidade;
	}

	private Plano novoPlanoMock() {
		Plano plano = new Plano();
		plano.setName("BD");
		plano.setRecurso("R$ 1.000.000,00");
		plano.setCnpb("202201");
		return plano;
	}

// 1 - Entidade 
// você recebe uma entidade
// endpoint java recebe json da entidade
// eu quero só o objeto que representa a entidade

/*
Vou criar um objeto Entidade
Vou criar um objeto Plano
Vou injetar Plano em Entidade
Vou salvar Entidade e persistir o Plano da Entidade
Qual o desafio?
Trazer o nome do plano selecionando a entidade.
*/

}
