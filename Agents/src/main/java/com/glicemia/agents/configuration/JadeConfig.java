package com.glicemia.agents.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.glicemia.agents.agents.AMA;
import com.glicemia.agents.agents.PAA;
import com.glicemia.agents.agents.PTA;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

@Configuration
public class JadeConfig {

	@Bean
	public AgentContainer agentContainer() {
		try {
			Runtime runtime = Runtime.instance();
			Profile profile = new ProfileImpl();
			AgentContainer container = runtime.createMainContainer(profile);
			return container;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public AgentController agentPTA(AgentContainer container) {
		try {
			AgentController controller = container.acceptNewAgent("PTA", new PTA());
			controller.start();
			return controller;
		} catch (StaleProxyException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public AgentController agentAMA(AgentContainer container) {
		try {
			AgentController controller = container.acceptNewAgent("AMA", new AMA());
			controller.start();
			return controller;
		} catch (StaleProxyException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public AgentController agentPAA(AgentContainer container) {
		try {
			AgentController controller = container.acceptNewAgent("PAA", new PAA());
			controller.start();
			return controller;
		} catch (StaleProxyException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
