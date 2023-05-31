package com.glicemia.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glicemia.api.domain.Paciente;
import com.glicemia.api.repositories.PacienteRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	@Autowired
	private PacienteRepository repo;

	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Paciente p1 = new Paciente("Luis", sdf.parse("17/18/2114"), "Masculino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p2 = new Paciente("Clarise", sdf.parse("17/18/2114"), "Feminino", 1, 43.9, 1.49, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p3 = new Paciente("Genivaldo", sdf.parse("17/18/2114"), "Masculino", 1, 72.3, 1.75, 1, 1, 1, 1, 1, 1,
				1, null, new Date(System.currentTimeMillis()));
		Paciente p4 = new Paciente("Luana", sdf.parse("17/18/2114"), "Feminino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p5 = new Paciente("Karol", sdf.parse("17/18/2114"), "Feminino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p6 = new Paciente("Igor", sdf.parse("17/18/2114"), "Masculino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p7 = new Paciente("Dulce", sdf.parse("17/18/2114"), "Feminino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p8 = new Paciente("Emanoel", sdf.parse("17/18/2114"), "Masculino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p9 = new Paciente("Chokito", sdf.parse("17/18/2114"), "Masculino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p10 = new Paciente("Caribe", sdf.parse("17/18/2114"), "Masculino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		Paciente p11 = new Paciente("Cacau", sdf.parse("17/18/2114"), "Feminino", 1, 62.3, 1.62, 1, 1, 1, 1, 1, 1, 1,
				null, new Date(System.currentTimeMillis()));
		repo.saveAllAndFlush(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
	}

}
