package Autenticacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLogin {
    Scanner leitor = new Scanner(System.in);
    Scanner leitor2 = new Scanner(System.in);

    List<String> listaEmail = new ArrayList<String>();
    List<String> listaSenha = new ArrayList<String>();
    List<String> dateLog = new ArrayList<String>();

    DateTimeFormatter formatadorDataHora =
            DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss");

    Boolean isAdmin = false;

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
                System.out.println("❌ Email incorreto, tente novamente!");
            } else {
                listaEmail.add(email);
                break;
            }
        } while (true);

        do {
            System.out.println("• Digite uma senha: ");
            String senha = leitor.nextLine();

            if (senha.length() < 8 || senha.length() > 64) {
                System.out.println("❌ Senha fraca, informe uma senha mais forte!");
            } else {
                listaSenha.add(senha);
                break;
            }
        } while (true);

        do {
            System.out.println("• Tipo de usuário:\n1) Admin\n2) Suporte");
            Integer tipoUsuario = leitor2.nextInt();

                if (tipoUsuario == 1) {
                    isAdmin = true;
                    break;
            } else if (tipoUsuario == 2) {
                    break;
                } else {
                    System.out.println("❌ Tipo de usuário inválido!");
                }
        } while (true);

        System.out.println("""
                    +----------------------------------+
                    |        CADASTRO REALIZADO!       |
                    |     Acesse seu email para ter    |
                    | a chave de acesso da sua empresa.|
                    +----------------------------------+
                    """);
        System.out.println("⏳ Redirecionando ao login...");
        System.out.println("--------------------------------");
        login();
    }
    void login() {
        Boolean loginBemSucedido = false;

        do {
            LocalDateTime dataHora = LocalDateTime.now();

            System.out.println("Bem-vindo(a) de volta!");
            System.out.println("---------");

            System.out.println("• Digite seu email: ");
            String email = leitor.nextLine();

            System.out.println("• Digite  sua senha: ");
            String senha = leitor.nextLine();
            
            String maskedPassword = maskPassword(senha);
            System.out.println(maskedPassword);

            for (int i = 0; i < listaEmail.size(); i++) {
                if (listaEmail.get(i).equals(email) && listaSenha.get(i).equals(senha)) {
                    loginBemSucedido = true;
                    dateLog.add(formatadorDataHora.format(dataHora));
                    break;
                }
            }

            if (loginBemSucedido) {
                System.out.println("""
                        +----------------------------------+
                        |        LOGIN BEM SUCEDIDO!       |
                        | Bem-vindo(a) de volta ao sistema |
                        |           da idleCare            |
                        +----------------------------------+
                        """);

                    profile();
            } else {
                System.out.println("❌ Nome de usuário e/ou senha incorretos. Tente novamente.");
            }
        } while (!loginBemSucedido);
    }

    void profile() {
        List<String> listaMaquinasNumDeSerie = new ArrayList();
        List<String> listaMaquinasApelido = new ArrayList();
        List<Double> listaMaquinasRAM = new ArrayList();
        List<Double> listaMaquinasCPU = new ArrayList();
        List<String> listaMaquinasLocalizacao = new ArrayList();

        do {
            System.out.println("""
                    +----------------------------------+
                     Email: %s
                     Admin: %b
                    +----------------------------------+
                    """);
            System.out.println("""
                    | 1) Cadastrar máquina             |
                    | 2) Remover máquina               |
                    | 3) Listar máquinas               |
                    | 4) Deslogar                      |
                    +----------------------------------+
                    """);
            Integer escolha = leitor2.nextInt();

            if (escolha == 1) {
                System.out.println("• Digite o número de série:");
                String numeroDeSerie = leitor.nextLine();

                if (numeroDeSerie.equals("")) {
                    System.out.println("❌ Informe um número de série válido.");
                } else {
                    listaMaquinasNumDeSerie.add(numeroDeSerie);
                }

                System.out.println("• Digite o apelido da máquina:");
                String apelido = leitor.nextLine();

                if (apelido.equals("")) {
                    System.out.println("❌ Informe um apelido válido.");
                } else {
                    listaMaquinasApelido.add(apelido);
                }

                System.out.println("• Quantidade de memória RAM:");
                Double memoriaRAM = leitor2.nextDouble();

                if (memoriaRAM < 0.0) {
                    System.out.printf("❌ Informe um número válido.");
                } else {
                    listaMaquinasRAM.add(memoriaRAM);
                }

                System.out.printf("• Processador (CPU):");
                Double processador = leitor2.nextDouble();

                if (processador < 0.0) {
                    System.out.printf("❌ Informe um número válido.");
                } else {
                    listaMaquinasCPU.add(processador);
                }

                System.out.printf("• Localidade da maquina (atualmente):");
                String localidade = leitor.nextLine();

                if (localidade.equals("")) {
                    System.out.printf("❌ Informe uma localização válida.");
                } else {
                    listaMaquinasLocalizacao.add(localidade);
                }

                System.out.println("Cadastro realizado com sucesso!");

            } else if (escolha == 2) {
                if (listaMaquinasNumDeSerie.size() > 0) {
                    System.out.println("Informe o ID da máquina que deseja remover");
                    Integer maquina = leitor2.nextInt();

                    if (maquina <= listaMaquinasApelido.size() && maquina > 0) {
                        listaMaquinasNumDeSerie.remove(maquina - 1);
                        listaMaquinasApelido.remove(maquina - 1);
                        listaMaquinasRAM.remove(maquina - 1);
                        listaMaquinasCPU.remove(maquina - 1);
                        listaMaquinasLocalizacao.remove(maquina - 1);
                    } else {
                        System.out.println("❌ Não existe nenhuma máquina com esse ID.");
                    }
                } else {
                    System.out.println("❌ Não existe nenhuma máquina cadastrada.");
                }
            } else if (escolha == 3) {
                if (listaMaquinasNumDeSerie.size() > 0) {
                    System.out.println("Listando todas as máquinas:");

                    for (int i = 0; i < listaMaquinasNumDeSerie.size(); i++) {
                        System.out.println("+----");
                        System.out.println(
                                String.format("""
                                %d - Máquina: %s
                                """, i + 1, listaMaquinasApelido.get(i))
                        );
                    }

                    System.out.println("""
                            +----------------------------------+
                            Deseja visualizar detalhes de alguma máquina?
                            Informe o ID da máquina. (Digite 0 caso não queira)
                            """);
                    Integer maquina = leitor2.nextInt();

                    if (maquina <= listaMaquinasApelido.size() && maquina > 0) {
                        System.out.println(
                                String.format("""
                                Máquina ID: %d
                                Número de Série: %s
                                Apelido: %s
                                Memória RAM: %f
                                CPU: %f
                                Localização: %s
                                """, maquina,
                                listaMaquinasNumDeSerie.get(maquina - 1),
                                listaMaquinasApelido.get(maquina - 1),
                                listaMaquinasRAM.get(maquina - 1),
                                listaMaquinasCPU.get(maquina - 1),
                                listaMaquinasLocalizacao.get(maquina - 1)
                                )
                        );
                    } else {
                        System.out.println("❌ Não existe nenhuma máquina com esse ID.");
                    }
                } else {
                    System.out.println("❌ Não existe nenhuma máquina cadastrada.");
                }
            } else if (escolha == 4) {
                System.out.println("Deslogando...");
                break;
            } else {
                System.out.println("❌ Informe uma opção válida.");
            }
        } while (true);
    }

    private static String maskPassword(String senha) {
        return "*".repeat(senha.length());
    }
}
