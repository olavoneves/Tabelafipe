package br.com.tabelafipe.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoTabelafipeApplication implements CommandLineRunner {

	public static void main(String[] args) { SpringApplication.run(ProjetoTabelafipeApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
		ConsoleService console = new ConsoleService();
		try {
			console.exibeMenu();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
