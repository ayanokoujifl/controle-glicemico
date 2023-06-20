"use client"
import { ListMagnifyingGlass } from "@phosphor-icons/react"

export function Search() {
  return (
    <>
      <div className="px-5 w-full">
        <div className="flex flex-1 bg-slate-400 rounded px-3 py-1 focus-within:outline-cyan-300 focus-within:outline outline-2">
          <input
            type="text"
            className="flex-1 bg-transparent focus:outline-none placeholder:text-cyan-950 text-cyan-950"
            placeholder="Pesquise pelo prontuario ou nome do paciente..."
          />
          <ListMagnifyingGlass
            size={32}
            color="rgb(8 51 68)"
            className="cursor-pointer"
          />
        </div>
      </div>
    </>
  )
}
