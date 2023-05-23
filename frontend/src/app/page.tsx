import React, { useEffect } from "react"

interface Paciente {
  id: number
  nome: string
  idade: number
  glicemia: number
}

export default async function Home() {
  const pacientes = await fetch("http://localhost:8888/pacientes").then(
    (response) => {
      return response.json()
    }
  )

  return (
    <>
      <header className="flex justify-between px-3">
        <h1 className="text-3xl">Controle glicêmico</h1>
        <nav className="flex gap-6">
          <p>Relatórios</p>
          <p>Pedidos de tratamento</p>
          <p>Pedidos de monitoramento</p>
        </nav>
      </header>
      <main className="flex flex-1 justify-center items-center min-h-[500px]">
        <section></section>
        <section>
          {/*
           * Aqui ficaria todo o seed do database
           */}
          <table className="table-auto border border-collapse border-cyan-700">
            <thead>
              <tr>
                <th>Paciente</th>
                <th>Nome</th>
                <th>Idade</th>
                <th>Glicemia</th>
              </tr>
            </thead>
            <tbody>
              {pacientes.map((paciente: Paciente) => {
                return (
                  <tr>
                    <td>{paciente.id}</td>
                    <td>{paciente.nome}</td>
                    <td>{paciente.idade}</td>
                    <td>{paciente.glicemia}</td>
                  </tr>
                )
              })}
            </tbody>
          </table>
        </section>
      </main>
    </>
  )
}
