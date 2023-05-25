from flask import Flask, jsonify, request
from src.agents.PAA import PAA
from src.agents.PMA import PMA
from src.agents.PTA import PTA
from src.Model import Model
from src.paciente import pacientes

app = Flask(__name__)

@app.route("/pacientes", methods=["GET"])
def get_pacientes():
    return jsonify(pacientes)

model = Model()
paa = PAA(id=1, model=model)
pta = PTA(id=2, model=model)
pma = PMA(id=3, model=model)
model.schedule.add(paa)
model.schedule.add(pta)
model.schedule.add(pma)

model.step()
app.run(port=8888, host="localhost", debug=True)

