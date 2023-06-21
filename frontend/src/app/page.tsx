import { Search } from "@/components/Search"
import Link from "next/link"
import React, { useEffect } from "react"

/* interface Paciente {
  Prontuario: Number
  Nome: string
  DataNascimento: Date
  Sexo: string
  DataInternacao: Date
  TipoInfeccao: number
  Peso: number
  Altura: number
  IMC: number
  Diabetes: number
  InsuficiênciaRenal: number
  Corticoide: number
  Infeccao: number
  SindromeDescRespiratorio: number
  InstabilidadeHemodinamica: number
  StatusPaciente: number
  observações: string
  tratamento: string
  monitoramento: string
  createDate: Date
  updateDate: Date
} */

const getDataPacientes = async () => {
  const res = await fetch("http://localhost:8080/pacientes", {
    next: { revalidate: 60 },
  })

  setInterval(() => {
    fetch("http://localhost:8080/pacientes", {
      next: { revalidate: 60 },
    })
  }, 5000)
  if (!res.ok) {
    throw new Error("Erro")
  }
  return res.json()
}

export default async function Home() {
  const pacientes = await getDataPacientes()

  console.log(pacientes)

  return (
    <>
      <header className="flex px-3 mt-4">
        <h1 className="text-3xl">Controle glicêmico</h1>
      </header>
      <main className="flex flex-col flex-1 mt-8">
        <Search />
        <section className="px-5 mt-5">
          {/*
           * Aqui ficaria todo o seed do database
           */}
          <table className="border border-cyan-700 text-sm px-5">
            <thead>
              <tr>
                <th>Prontuario</th>
                <th>Nome</th>
                <th>Tipo de internação</th>
                <th>IMC</th>
                <th>Diabetes</th>
                <th>Insuficiência renal</th>
                <th>Corticoide</th>
                <th>Infecção</th>
                <th>Sindrome desc. respiratório</th>
                <th>Instabilidade hemodinâmica</th>
                <th>Status do paciente</th>
                <th>Observações</th>
                <th>Tratamento</th>
                <th>Monitoramento</th>
              </tr>
            </thead>
            <tbody>
              {pacientes.map((paciente: any) => {
                return (
                  <>
                    <tr
                      key={paciente.Prontuario}
                      className="hover:bg-cyan-600 cursor-pointer"
                    >
                      <td className="p-0">
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.prontuario}
                        </Link>
                      </td>

                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.nome}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.tipoInternacao}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.imc.toFixed(2)}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.diabetes}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.insuficienciaRenal}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.corticoide}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.infeccao}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.sindromeDescRespiratorio}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4 h-full w-full"
                        >
                          {paciente.instabilidadeHemodinamica}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4"
                        >
                          {paciente.statusPaciente}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4"
                        >
                          {paciente.observacoes}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4"
                        >
                          {paciente.tratamento}
                        </Link>
                      </td>
                      <td>
                        <Link
                          href={`/reports?id=${paciente.prontuario}`}
                          className="flex flex-1 px-4"
                        >
                          {paciente.monitoramento}
                        </Link>
                      </td>
                    </tr>
                  </>
                )
              })}
            </tbody>
          </table>
        </section>
      </main>
    </>
  )
}
