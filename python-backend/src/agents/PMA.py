from mesa import Agent


class PMA(Agent):
    def __init__(self, id, model):
        super().__init__(id, model)

    def step(self):
        print("PMA rodando")