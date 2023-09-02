package Autenticacao;

import java.util.Scanner;

public class TesteSistemaLogin {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaLogin sistema = new SistemaLogin();

        System.out.println("""
                    +----------------🩺----------------+
                    |          Bem-vindo(a) ao         |
                    |          Vita - idleCare         |
                    |       ---------------------      |
                    | • Selecione a opção desejada:    |
                    | 1 - Cadastro                     |
                    | 2 - Login                        |
                    | 3 - Sair do sistema              |
                    +----------------------------------+
                    """);

        Integer escolha = leitor.nextInt();

        if (escolha == 3) {
            System.out.println("Saindo do sistema...");
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
