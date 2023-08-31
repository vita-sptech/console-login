import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaLogin {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaLogin sistema = new SistemaLogin();

        System.out.println("Bem vindo(a) a idleCare");
        System.out.println("selecione a opção desejada: \n" +
                "1- Cadastro \n" +
                "2- Login \n" +
                "3- Sair do sistema");
        Integer escolha = leitor.nextInt();

        if (escolha == 3) {
            System.out.println("Saindo do sistema");
        }  if (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("Essa escolha é inválida");
        }
        if(escolha==1){
            sistema.cadastro();
        }else{
            sistema.login();
        }



    }
}
