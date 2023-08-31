import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLogin {
    Scanner leitor = new Scanner(System.in);
    List<String> listaEmail = new ArrayList();
    List<String> listaSenha = new ArrayList<>();

    void cadastro(){
        System.out.println("Cadastro");
            System.out.println("Digite um email: ");
            String email = leitor.nextLine();

            System.out.println("digite uma senha: ");
            String senha = leitor.nextLine();

            listaEmail.add(email);
            listaSenha.add(senha);
            System.out.println("Cadastro realizado com sucesso!");

        login();
    }
    void login() {
        System.out.println("Login");
            System.out.println("Digite  seu email: ");
            String email = leitor.nextLine();
            System.out.println("Digite  sua senha: ");
            String senha = leitor.nextLine();

            boolean loginBemSucedido = false;

            for (int i = 0; i < listaEmail.size(); i++) {
                if (listaEmail.get(i).equals(email) && listaSenha.get(i).equals(senha)) {
                    loginBemSucedido = true;
                    break;
                }
                }
            if(loginBemSucedido){
                System.out.println("Login bem-sucedido!");
            }else {
                    System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
                }
            while (!loginBemSucedido) ;
    }}
