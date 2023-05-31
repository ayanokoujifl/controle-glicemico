package com.glicemia.agents.agents;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glicemia.agents.domain.Paciente;
import com.glicemia.agents.domain.enums.TipoDiabete;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PAA extends Agent {
	private static final long serialVersionUID = 1L;

	OkHttpClient client = new OkHttpClient();

	ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void setup() {
		System.out.println("Agente: " + getAID().getName() + " rodando");

		addBehaviour(new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				Request req = new Request.Builder().url("http://localhost:8080/pacientes").build();
				try (Response res = client.newCall(req).execute()) {
					String body = res.body().string();
					List<Paciente> pacientes = mapper.readValue(body, new TypeReference<List<Paciente>>() {
					});

					for (Paciente paciente : pacientes) {
						if (paciente.getDiabetes().equals(TipoDiabete.IGNORADO)) {
							msg.setContent(paciente.getNome() + " teve seu status de diabetes ignorado");
							msg.setOntology(paciente.getProntuario() + ": " + paciente.getNome() + "- Relatório");
						}
						msg.addReceiver(new AID("AMA", AID.ISLOCALNAME));
						doWait(700);
						send(msg);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				block(); // Aguarda por novas mensagens
			}
		});
	}

	@Override
	protected void takeDown() {
		super.takeDown();
		System.out.println("Agente encerrado");
	}
}

/*
 * Future<List<Paciente>> getPacientes = executorService.submit(new
 * Callable<List<Paciente>>() { public List<Paciente> call() throws Exception {
 * System.out.println("Thread rodando"); Request req = new
 * Request.Builder().url("http://localhost:8080/pacientes").build(); try
 * (Response res = client.newCall(req).execute()) { String body =
 * res.body().string(); ObjectMapper mapper = new ObjectMapper(); List<Paciente>
 * list = mapper.readValue(body, new TypeReference<List<Paciente>>() { });
 * System.out.println("Thread finalizada");
 * 
 * return list; } } });
 * 
 * Future<Void> sendMessageToAMA = executorService.submit(new Callable<Void>() {
 * 
 * @Override public Void call() throws Exception {
 * System.out.println("iniciando processo de envio"); List<Paciente> list =
 * getPacientes.get(); for (Paciente paciente : list) { if
 * (paciente.getDiabetes().equals(TipoDiabete.IGNORADO)) { ACLMessage msg = new
 * ACLMessage(ACLMessage.INFORM);
 * msg.setContent("Status de diabetes do paciente: " + paciente.getNome() +
 * " foi ignorado."); msg.addReceiver(getAID("AMA")); send(msg); AMA ama = new
 * AMA(); ama.setup(); } } return null; } });
 */
