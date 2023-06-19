package com.glicemia.agents.agents;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PTA extends Agent {
	private static final long serialVersionUID = 1L;

	OkHttpClient client = new OkHttpClient();

	@Override
	protected void setup() {
		System.out.println("\n" + getAID().getName() + " rodando");
		addBehaviour(new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {
					String dataPaciente;
					Pattern pattern = Pattern.compile("^.*?\n(.*)$", Pattern.DOTALL);
					Matcher matcher = pattern.matcher(msg.getContent());
					if (matcher.find()) {
						dataPaciente = matcher.group(1);
						Map<String, String> mapPaciente = new HashMap<>();
						String[] linhas = dataPaciente.split("\n");
						for (String linha : linhas) {
							String[] partes = linha.split(": ");
							if (partes.length == 2) {
								String chave = partes[0].trim();
								String valor = partes[1].trim();
								mapPaciente.put(chave, valor);
							}
						}

						String firstLine = msg.getContent().split("\n")[0];
						String prontuario = extrairProntuario(firstLine);
						// logica para decidir a respeito do tratamento do paciente
						String tratamento = "";
						if (mapPaciente.get("Status Diabetes").equals("Ignorado")) {
							tratamento += "teste, pq na prática, não é necessário informar nenhum tratamento nesse caso";
						} else if (mapPaciente.get("Status Diabetes").equals("Controle domiciliar medicamentoso")) {
							tratamento += "Recomenda-se revisar glicose de X em X horas";
						}
						// depois de fazer todas as validações, devemos atualizar o status de
						// tratamento do paciente
						MediaType type = MediaType.parse("application/json");
						String body = "{\"tratamento\": \"" + tratamento + "\"}";
						@SuppressWarnings("deprecation")
						RequestBody reqBody = RequestBody.create(type, body);
						Request req = new Request.Builder().url("http://localhost:8080/pacientes/" + prontuario)
								.put(reqBody).build();
						try {
							client.newCall(req).execute();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					block(); // Aguarda por novas mensagens
				}
			}
		});

	}

	private String extrairProntuario(String linha) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(linha);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	@Override
	protected void takeDown() {
		super.takeDown();
		System.out.println("PTA encerrado");
	}
}
