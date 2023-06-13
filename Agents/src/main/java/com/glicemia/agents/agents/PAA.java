package com.glicemia.agents.agents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glicemia.agents.domain.Paciente;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
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
		System.out.println("Agente: " + getAID().getName() + " rodando");

		addBehaviour(new OneShotBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				Request req = new Request.Builder().url("http://localhost:8080/pacientes").build();
				try (Response res = client.newCall(req).execute()) {
					String body = res.body().string();
					List<Paciente> pacientes = mapper.readValue(body, new TypeReference<List<Paciente>>() {
					});

					for (Paciente paciente : pacientes) {
						// Inicialmente, validaremos o status da diabetes do paciente
						relatorio = new HashMap<>();
						ACLMessage relatorioPaciente = new ACLMessage(ACLMessage.INFORM);
						relatorio.put("Status Diabetes", paciente.getDiabetes().getDescricao());
						relatorio.put("Tipo de internação", paciente.getTipoInternacao().getTipo());
						relatorio.put("Insuficiência renal", paciente.getInsuficienciaRenal().getDescricao());
						relatorio.put("Status corticoide", paciente.getCorticoide().getDescricao());
						relatorio.put("Status infecção",paciente.getInfeccao().getDescricao());
						relatorio.put("Status sindrome desc respiratório",paciente.getSindromeDescRespiratorio().getDescricao());
						relatorio.put("Status instabilidade hemodinâmica", paciente.getInstabilidadeHemodinamica().getDescricao());
						relatorio.put("Status paciente", paciente.getStatusPaciente().getDescricao());
						relatorioPaciente.setOntology(paciente.getProntuario().toString());
						relatorioPaciente.setContent(
								"Relatório - "+paciente.getNome()+" "+paciente.getProntuario()
								+"\n"+ makeReport(relatorio)
								);
						relatorioPaciente.addReceiver(new AID("AMA", AID.ISLOCALNAME));		
						relatorioPaciente.addReceiver(new AID("PTA", AID.ISLOCALNAME));

						doWait(500);
						send(relatorioPaciente);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				block(); // Aguarda por novas mensagens
			}
		});
	}

	private String makeReport(Map<String,String> map) {
		String msg = "";
		for(Map.Entry<String, String> entry:map.entrySet()) {
			msg = msg +""+entry.getKey()+": "+entry.getValue()+"\n";
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
