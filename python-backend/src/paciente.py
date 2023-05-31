import pandas as pd
import json

table_pacientes=pd.read_excel('/home/luis/Documentos/dev/Glicemia/backend/src/assets/database/plan.xlsx')
pacientes= json.loads(table_pacientes.to_json(orient='records'))