package br.com.tabelafipe.application;

import java.util.Scanner;

public class ConsoleService {
    Scanner scanner;

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCA = "/marcas/";
    private final String MODELO = "/modelos/";
    private final String ANO = "/anos";
    private String url;

    public void exibeMenu() {
        scanner = new Scanner(System.in);
        var confere = "S";
        while (confere.equals("S")) {
            System.out.println(" _____   _      ______    _   _    ____");
            System.out.println("/  __ \\ | |    |  __  | |  | |  | / __  \\");
            System.out.println("| |  | || |    |  __  | |  | |  || |  | |");
            System.out.println("| |  | || |    | |  | | |  |_|  || |  | |");
            System.out.println("| |__| || |____| |  | |  \\     / | |__| |");
            System.out.println("\\_____\\__\\______\\____\\_\\  \\___/   \\____/");

            System.out.print("╔════════════════════════════╗ \n");
            System.out.print("║           OPÇÕES           ║ \n");
            System.out.print("║════════════════════════════║ \n");
            System.out.print("║   > 1. Carro               ║ \n");
            System.out.print("║   > 2. Moto                ║ \n");
            System.out.print("║   > 3. Caminhão            ║ \n");
            System.out.print("╚════════════════════════════╝ \n");
            System.out.print("    > ");
            var veiculo = scanner.nextLine();

            switch (veiculo) {
                case "1":
                    veiculo = "carros";
                    url = ENDERECO + veiculo + MARCA;

                    break;
                case "2":
                    veiculo = "motos";
                    url = ENDERECO + veiculo + MARCA;

                    break;
                case "3":
                    veiculo = "caminhoes";
                    url = ENDERECO + veiculo + MARCA;

                    break;
                default:
                    break;
            }

            System.out.println("    ________");
            System.out.println("   /        \\");
            System.out.println("  |    🔴    |  [Gostaria de procurar outro veículo?]");
            System.out.println("  |    🟢    |");
            System.out.println("   \\________/");
            System.out.println("      | |");
            System.out.println("     _| |_");
            System.out.println("    |_____|");
            System.out.print("\n[S/N]: ");
            confere = scanner.next().toUpperCase();
            if (confere.equals("N")) {
                System.out.print("\033[34mOBRIGADO POR NOS ESCOLHER \u2764\uFE0F \nVOLTE SEMPRE!\033[0m");
            }
        }
    }
}
