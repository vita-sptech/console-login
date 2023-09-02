import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLogin {
    Scanner leitor = new Scanner(System.in);
    List<String> listaEmail = new ArrayList();
    List<String> listaSenha = new ArrayList<>();

    void cadastro(){
        System.out.println("Cadastre-se!");
        System.out.println("---------");

        do {
            System.out.println("• Digite um email: ");
            String email = leitor.nextLine();

            if (email.equals("") && email.equals(" ")
                    || (email.indexOf("@") == -1 || email.indexOf("@") == 0)
                    || (email.indexOf(".") == -1 || email.indexOf(".") == 0)
            ) {
                System.out.println("Email incorreto, tente novamente!");
            } else {
                listaEmail.add(email);
                break;
            }
        } while (true);

        do {
            System.out.println("• Digite uma senha: ");
            String senha = leitor.nextLine();

            if (senha.length() < 8 || senha.length() > 64) {
                System.out.println("Senha fraca, informe uma senha mais forte!");
            } else {
                listaSenha.add(senha);
                break;
            }
        } while (true);

        System.out.println("""
                    |----------------------------------|
                    |       CADASTRO REALIZADO!        |
                    |     Acesse seu email para ter    |
                    | a chave de acesso da sua empresa.|
                    |----------------------------------|
                    """);
        System.out.println("Redirecionando ao login...");
        System.out.println("--------------------------------");
        login();
    }
    void login() {
        Boolean loginBemSucedido = false;

        do {
            System.out.println("Bem-vindo(a) de volta!");
            System.out.println("---------");

            System.out.println("• Digite seu email: ");
            String email = leitor.nextLine();

            System.out.println("• Digite  sua senha: ");
            String senha = leitor.nextLine();

            for (int i = 0; i < listaEmail.size(); i++) {
                if (listaEmail.get(i).equals(email) && listaSenha.get(i).equals(senha)) {
                    loginBemSucedido = true;
                    break;
                }
            }

            if (loginBemSucedido) {
                System.out.println("""
                        |----------------------------------|
                        |       LOGIN BEM SUCEDIDO!        |
                        | Bem-vindo(a) de volta ao sistema |
                        |           da idleCare            |
                        |----------------------------------|
                        """);
            } else {
                System.out.println("Nome de usuário e/ou senha incorretos. Tente novamente.");
            }
        } while (!loginBemSucedido);
    }
}
