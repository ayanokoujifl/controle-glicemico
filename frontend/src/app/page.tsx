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
      <main className="flex flex-col flex-1 justify-center items-center min-h-[500px] mt-8">
        <Search />
        <section className="p-5">
          {/*
           * Aqui ficaria todo o seed do database
           */}
          <table className="border border-cyan-700 p-4 text-sm">
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
                    <Link href={`/reports/${paciente.prontuario}`}></Link>
                    <tr
                      key={paciente.Prontuario}
                      className="hover:bg-cyan-600 cursor-pointer"
                    >
                      <td>{paciente.prontuario}</td>
                      <td>{paciente.nome}</td>
                      <td>{paciente.tipoInternacao}</td>
                      <td>{paciente.imc.toFixed(2)}</td>
                      <td>{paciente.diabetes}</td>
                      <td>{paciente.insuficienciaRenal}</td>
                      <td>{paciente.corticoide}</td>
                      <td>{paciente.infeccao}</td>
                      <td>{paciente.sindromeDescRespiratorio}</td>
                      <td>{paciente.instabilidadeHemodinamica}</td>
                      <td>{paciente.statusPaciente}</td>
                      <td>{paciente.observacoes}</td>
                      <td>{paciente.tratamento}</td>
                      <td>{paciente.monitoramento}</td>
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
