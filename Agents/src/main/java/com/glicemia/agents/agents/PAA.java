package com.glicemia.agents.agents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glicemia.agents.domain.Paciente;
import com.glicemia.agents.dto.PacienteDTO;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PAA extends Agent {

	Map<String, String> relatorio;

	private static final long serialVersionUID = 1L;

	OkHttpClient client = new OkHttpClient();

	ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void setup() {
		System.out.println(getAID().getName() + " rodando");

		addBehaviour(new WakerBehaviour(this, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public void handleElapsedTimeout() {
				Request req = new Request.Builder().url("http://localhost:8080/pacientes").build();
				try (Response res = client.newCall(req).execute()) {
					String body = res.body().string();
					List<PacienteDTO> pacientesDTO = mapper.readValue(body, new TypeReference<List<PacienteDTO>>() {
					});

					List<Paciente> pacientes = new ArrayList<>();
					pacientes.addAll(pacientesDTO.stream().map(x -> new Paciente(x)).collect(Collectors.toList()));

					for (Paciente paciente : pacientes) {
						// Inicialmente, validaremos o status da diabetes do paciente
						relatorio = new HashMap<>();
						ACLMessage relatorioPaciente = new ACLMessage(ACLMessage.INFORM);
						relatorio.put("Status Diabetes", paciente.getDiabetes().getDescricao());
						relatorio.put("Tipo de internação", paciente.getTipoInternacao().getTipo());
						relatorio.put("Insuficiência renal", paciente.getInsuficienciaRenal().getDescricao());
						relatorio.put("Status corticoide", paciente.getCorticoide().getDescricao());
						relatorio.put("Status infecção", paciente.getInfeccao().getDescricao());
						relatorio.put("Status sindrome desc respiratório",
								paciente.getSindromeDescRespiratorio().getDescricao());
						relatorio.put("Status instabilidade hemodinâmica",
								paciente.getInstabilidadeHemodinamica().getDescricao());
						relatorio.put("Status paciente", paciente.getStatusPaciente().getDescricao());
						relatorioPaciente.setOntology(paciente.getProntuario().toString());
						relatorioPaciente.setContent("Relatório - " + paciente.getNome() + " "
								+ paciente.getProntuario() + "\n" + makeReport(relatorio));
						relatorioPaciente.addReceiver(new AID("AMA", AID.ISLOCALNAME));
						relatorioPaciente.addReceiver(new AID("PTA", AID.ISLOCALNAME));

						send(relatorioPaciente);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				reset(60000);
			}
		});
	}

	private String makeReport(Map<String, String> map) {
		String msg = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			msg = msg + "" + entry.getKey() + ": " + entry.getValue() + "\n";
		}
		return msg;
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
