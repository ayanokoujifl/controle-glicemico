from mesa import Model
from mesa.time import BaseScheduler

class Model(Model):
    def __init__(self):
        self.schedule = BaseScheduler(self)
         
    def step(self):
        self.schedule.step()
