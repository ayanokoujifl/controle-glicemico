from mesa import Agent,Model

class PTA(Agent):
    def __init__(self,id,model):
        super().__init__(id,model)
    
    def step(self):
        print("PTA rodando")