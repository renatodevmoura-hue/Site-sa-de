package model;
import util.Criptografia;

public class Usuario {

        private int idUsuario;
        private String nome;
        private String email;
        private String senha;
        private int idade;
        private String sexo;
        private String telefone;

        public Usuario(String nome, String email, String senha,
                       int idade, String sexo, String telefone) {
            setNome(nome);
            setEmail(email);
            setSenha(senha);
            setIdade(idade);
            setSexo(sexo);
            setTelefone(telefone);
        }
        public Usuario(int idUsuario, String nome, String email, String senhaHash,
                       int idade, String sexo, String telefone){
            this.idUsuario = idUsuario;
            this.nome = nome;
            this.email = email;
            this.senha = senhaHash;
            this.idade = idade;
            this.sexo = sexo;
            this.telefone = telefone;

        }public Usuario(int idUsuario, String nome, String email,
                        int idade, String sexo, String telefone){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;

    }

        public int getIdUsuario(){
            return idUsuario;
        }
        public String getNome(){
            return nome;
        }public String getEmail() {
        return email;
    }
    public String getSenhaHash() {
        return senha;
    }
        public int getIdade(){
            return idade;
        }
    public String getSexo() {
        return sexo;
    }
        public String getTelefone(){
            return telefone;
        }
        public void setIdUsuario(int idUsuario){
            this.idUsuario = idUsuario; //vamos ter que conectar o dao//
        }
        public void setNome(String nome){
            if(nome == null || nome.trim().isEmpty() || !nome.matches("[a-zA-ZÀ-ÿ ]+")){
                throw new IllegalArgumentException("NOME INVÁLIDO");
            }
            this.nome = nome.trim();
        }
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("EMAIL INVÁLIDO");
        }
        this.email = email.trim();
    }

    public void setSenha(String senha){
            if(senha == null || senha.trim().isEmpty()){
                throw new IllegalArgumentException("SENHA INVÁLLIDA");

            }
            this.senha = Criptografia.hash(senha);
    }

        public void setIdade(int idade){
            if(idade < 0 || idade >120){
                throw new IllegalArgumentException("IDADE INVÁLIDA");
            }
            this.idade = idade;
        }
    public void setSexo(String sexo){
        if(sexo == null ||
                !sexo.equalsIgnoreCase("masculino") && !sexo.equalsIgnoreCase("feminino")){
            throw new IllegalArgumentException("sexo dece ser masculino ou feminino");
        }
        this.sexo = sexo.trim();
    }
        public void setTelefone(String telefone){
            if(telefone == null || telefone.trim().isEmpty()) {
                throw new IllegalArgumentException("CAMPO NÃO PODE SER VAZIO");
            }

            telefone = telefone.replaceAll("[^0-9]","");
            if(!telefone.matches("\\d{10,11}")){
                throw new IllegalArgumentException("TELEFONE DEVE TER 10 OU 11 DIGITOS");
            }
            this.telefone = telefone;
        }
    }

