from ..paciente import pacientes
from mesa import Agent


class PAA(Agent):
    def __init__(self, id, model):
        super().__init__(id, model)

    def step(self):
        # Logica
        
