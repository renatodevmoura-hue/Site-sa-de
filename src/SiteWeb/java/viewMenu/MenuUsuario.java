package viewMenu;

import model.Usuario;
import dao.UsuarioDao;

import java.util.List;
import java.util.Scanner;


public class MenuUsuario {
    private Scanner scanner = new Scanner(System.in);
    private UsuarioDao usuarioDao = new UsuarioDao();

    public void iniciarUsuario() {

        int opcao;
        do {

            System.out.println("MENU DO USUÁRIO");
            System.out.println("DIGITE (1) PARA CADASTRAR USUÁRIO NO SISTEMA");
            System.out.println("DIGITE (2) PARA LER USUÁRIO DO SISTEMA");
            System.out.println("DIGITE (3) ATUALIZAR USUÁRIO DO SISTEMA");
            System.out.println("APERTE (0) PARA ENCERRAR O SISTEMA");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    inserirUsuario();
                    break;
                case 2:
                    listaDeUsuario();
                    break;
                case 3:
                    inserirAtualizacaoUsuario();
                    break;

                case 0:
                    System.out.println("ENCERRANDO SISTEMA");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁDIDA");
                    break;
            }

        } while (opcao != 0);
    }

    public void inserirUsuario() {

        try {
            System.out.println("DIGITE NOME DO USUÁRIO");
            String nome = scanner.nextLine();

            System.out.println("DIGITE EMAIL DO USUÁRIO");
            String email = scanner.nextLine();

            System.out.println("DIGITE A SENHA");
            String senha = scanner.nextLine();

            System.out.println("DIGITE IDADE DO USUÁRIO");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("DIGITE SEXO DO USUÁRIO");
            String sexo = scanner.nextLine();

            System.out.println("DIGITE TELEFONE DO USUÁRIO");
            String telefone = scanner.nextLine();

            Usuario usuario = new Usuario(nome, email, senha, idade, sexo, telefone);

            usuarioDao.cadastrarUsuario(usuario);

            System.out.println("USUÁRIO CADASTRADO COM SUCESSO");
        } catch (Exception e) {
            System.out.println("ERRO AO CADASTRAR USUÁRIO" + e.getMessage());
        }


    }

    public void listaDeUsuario() {
        try {
            List<Usuario> usuarios = usuarioDao.listarUsuario();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

        }catch (RuntimeException e){
            System.out.println("ERRO AO GERAR LISTA" +e.getMessage());
        }

    }
    public void inserirAtualizacaoUsuario(){

        try {
            System.out.println("INSIRA O IDENTIFICADOR DO USUÁRIO");
            int idUsuario = scanner.nextInt();
            scanner.nextLine();

            System.out.println("DIGITE NOVO NOME DO USUÁRIO");
            String nome = scanner.nextLine();

            System.out.println("DIGITE NOVO EMAIL DO USUÁRIO");
            String email = scanner.nextLine();


            System.out.println("DIGITE NOVA IDADE DO USUÁRIO");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("DIGITE NOVO SEXO DO USUÁRIO");
            String sexo = scanner.nextLine();

            System.out.println("DIGITE NOVO TELEFONE DO USUÁRIO");
            String telefone = scanner.nextLine();

            Usuario usuario = new Usuario(idUsuario, nome, email, idade, sexo, telefone);
            usuarioDao.atualizarUsuario(usuario);

        } catch (RuntimeException e) {
            System.out.println("ERRO AO ATUALIZAR DADOS" + e.getMessage());
            }
        }



    }
