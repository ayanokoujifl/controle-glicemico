package com.glicemia.agents.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class AMA extends Agent {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void setup() {
		System.out.println(getAID().getName() + " rodando");

		addBehaviour(new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;
			@Override
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {
					System.out.println(msg.getContent());
					
				} else {
					block(); // Aguarda por novas mensagens
				}
			}
		});
		
		
	}
}
