package com.example.demo;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(VoitureRepository.class);

	@Autowired
	private VoitureRepository voitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// injection de dépendances
	@Override
	public void run(String... args) throws Exception {
		voitureRepository.save(new Voiture(01,"Lamborghini",10000000));
		voitureRepository.save(new Voiture(02, "Renault", 30000));
		voitureRepository.save(new Voiture(03, "Citroën", 20000));
		voitureRepository.save(new Voiture(04,"Ferrari", 100000));


		voitureRepository.findAll();
		voitureRepository.findById(2);

	}

}
