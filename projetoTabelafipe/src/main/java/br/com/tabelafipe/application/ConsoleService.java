package br.com.tabelafipe.application;

import br.com.tabelafipe.model.Dados;
import br.com.tabelafipe.model.DadosMarca;
import br.com.tabelafipe.model.DadosVeiculo;
import br.com.tabelafipe.service.ConsumoTabelafipeService;
import br.com.tabelafipe.service.ConverteTabelafipeService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleService {
    private Scanner scanner;
    private ConsumoTabelafipeService consumir = new ConsumoTabelafipeService();
    private ConverteTabelafipeService conversor = new ConverteTabelafipeService();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCA = "/marcas";
    private final String MODELO = "/modelos";
    private final String ANO = "/anos";
    private String url;
    private String codigoMarca;
    private String nomeModelo;
    private String codigoModelo;
    private String json;
    private List<Dados> listaAnos;
    private List<Dados> modelosFiltrados;
    private List<DadosVeiculo> dadosVeiculos = new ArrayList<>();

    public void exibeMenu() {
        scanner = new Scanner(System.in);

        System.out.println(" _____   _      ______    _   _    ____");
        System.out.println("/  __ \\ | |    |  __  | |  | |  | / __  \\");
        System.out.println("| |  | || |    |  __  | |  | |  || |  | |");
        System.out.println("| |  | || |    | |  | | |  |_|  || |  | |");
        System.out.println("| |__| || |____| |  | |  \\     / | |__| |");
        System.out.println("\\_____\\__\\______\\____\\_\\  \\___/   \\____/");

        String confere = "S";
        while (confere.equals("S")) {
            System.out.print("╔════════════════════════════╗ \n");
            System.out.print("║           OPÇÕES           ║ \n");
            System.out.print("║════════════════════════════║ \n");
            System.out.print("║   > 1. Carro               ║ \n");
            System.out.print("║   > 2. Moto                ║ \n");
            System.out.print("║   > 3. Caminhão            ║ \n");
            System.out.print("║                            ║ \n");
            System.out.print("║   > Digite uma das opções: ║ \n");
            System.out.print("╚════════════════════════════╝ \n");
            System.out.print("    > ");
            var veiculo = scanner.nextLine();

            switch (veiculo) {
                case "1":
                    veiculo = "carros";
                    url = ENDERECO + veiculo + MARCA;
                    json = consumir.obterDado(url);
                    List<Dados> listaCarros = conversor.obterLista(json, Dados.class);
                    listaCarros.stream()
                                    .sorted(Comparator.comparing(Dados::nome))
                                            .forEach(System.out::println);

                    System.out.print("Digite o código da marca que você quer procurar: ");
                    codigoMarca = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO;
                    json = consumir.obterDado(url);
                    var listaMarcasCarro = conversor.obterDados(json, DadosMarca.class);
                    System.out.println("\n**************************************\nModelos dessa marca: ");
                    listaMarcasCarro.modelos().stream()
                                    .sorted(Comparator.comparing(Dados::nome))
                                            .forEach(System.out::println);


                    System.out.print("Digite uma parte do nome do modelo que você quer procurar: ");
                    nomeModelo = scanner.nextLine();

                    modelosFiltrados = listaMarcasCarro.modelos().stream()
                            .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                            .collect(Collectors.toList());
                    System.out.println("\n**************************************\nModelos filtrados: ");
                    modelosFiltrados.forEach(System.out::println);

                    System.out.println("Digite o código do modelo de interesse por favor: ");
                    codigoModelo = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO;
                    json = consumir.obterDado(url);
                    listaAnos = conversor.obterLista(json, Dados.class);

                    for (int i = 0; i < listaAnos.size(); i++) {
                        url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO + "/" + listaAnos.get(i).codigo();
                        json = consumir.obterDado(url);
                        DadosVeiculo dadoVeiculo = conversor.obterDados(json, DadosVeiculo.class);
                        dadosVeiculos.add(dadoVeiculo);
                    }
                    System.out.println("\nTodos os veiculos filtrados: ");
                    dadosVeiculos.forEach(System.out::println);

                    break;
                case "2":
                    veiculo = "motos";
                    url = ENDERECO + veiculo + MARCA;
                    json = consumir.obterDado(url);
                    List<Dados> listaMotos = conversor.obterLista(json, Dados.class);
                    listaMotos.stream()
                            .sorted(Comparator.comparing(Dados::nome))
                            .forEach(System.out::println);

                    System.out.print("Digite o código da marca que você quer procurar: ");
                    codigoMarca = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO;
                    json = consumir.obterDado(url);
                    var listaMarcasMotos = conversor.obterDados(json, DadosMarca.class);
                    System.out.println("\n**************************************\nModelos dessa marca: ");
                    listaMarcasMotos.modelos().stream()
                            .sorted(Comparator.comparing(Dados::nome))
                            .forEach(System.out::println);


                    System.out.print("Digite uma parte do nome do modelo que você quer procurar: ");
                    nomeModelo = scanner.nextLine();

                    modelosFiltrados = listaMarcasMotos.modelos().stream()
                            .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                            .collect(Collectors.toList());
                    System.out.println("\n**************************************\nModelos filtrados: ");
                    modelosFiltrados.forEach(System.out::println);

                    System.out.println("Digite o código do modelo de interesse por favor: ");
                    codigoModelo = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO;
                    json = consumir.obterDado(url);
                    listaAnos = conversor.obterLista(json, Dados.class);

                    for (int i = 0; i < listaAnos.size(); i++) {
                        url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO + "/" + listaAnos.get(i).codigo();
                        json = consumir.obterDado(url);
                        DadosVeiculo dadoVeiculo = conversor.obterDados(json, DadosVeiculo.class);
                        dadosVeiculos.add(dadoVeiculo);
                    }
                    System.out.println("\nTodos os veiculos filtrados: ");
                    dadosVeiculos.forEach(System.out::println);

                    break;
                case "3":
                    veiculo = "caminhoes";
                    url = ENDERECO + veiculo + MARCA;
                    json = consumir.obterDado(url);
                    List<Dados> listaCaminhoes = conversor.obterLista(json, Dados.class);
                    listaCaminhoes.stream()
                            .sorted(Comparator.comparing(Dados::nome))
                            .forEach(System.out::println);

                    System.out.print("Digite o código da marca que você quer procurar: ");
                    codigoMarca = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO;
                    json = consumir.obterDado(url);
                    var listaMarcasCaminhao = conversor.obterDados(json, DadosMarca.class);
                    System.out.println("\n**************************************\nModelos dessa marca: ");
                    listaMarcasCaminhao.modelos().stream()
                            .sorted(Comparator.comparing(Dados::nome))
                            .forEach(System.out::println);


                    System.out.print("Digite uma parte do nome do modelo que você quer procurar: ");
                    nomeModelo = scanner.nextLine();

                    modelosFiltrados = listaMarcasCaminhao.modelos().stream()
                            .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                            .collect(Collectors.toList());
                    System.out.println("\n**************************************\nModelos filtrados: ");
                    modelosFiltrados.forEach(System.out::println);

                    System.out.println("Digite o código do modelo de interesse por favor: ");
                    codigoModelo = scanner.nextLine();
                    url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO;
                    json = consumir.obterDado(url);
                    listaAnos = conversor.obterLista(json, Dados.class);

                    for (int i = 0; i < listaAnos.size(); i++) {
                        url = ENDERECO + veiculo + MARCA + "/" + codigoMarca + MODELO + "/" + codigoModelo + ANO + "/" + listaAnos.get(i).codigo();
                        json = consumir.obterDado(url);
                        DadosVeiculo dadoVeiculo = conversor.obterDados(json, DadosVeiculo.class);
                        dadosVeiculos.add(dadoVeiculo);
                    }
                    System.out.println("\nTodos os veiculos filtrados: ");
                    dadosVeiculos.forEach(System.out::println);

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
            confere = scanner.nextLine().toUpperCase();
            if (confere.equals("N")) {
                System.out.print("\033[34mOBRIGADO POR NOS ESCOLHER \u2764\uFE0F \nVOLTE SEMPRE!\033[0m");
                break;
            }
        }
    }
}
