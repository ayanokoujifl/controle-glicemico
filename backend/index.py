from flask import Flask,jsonify,request
from src.paciente import pacientes
app = Flask(__name__)

@app.route('/pacientes',methods=['GET'])
def get_pacientes():
    return jsonify(pacientes)

app.run(port=8888, host="localhost", debug=True)
