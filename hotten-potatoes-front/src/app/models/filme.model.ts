export interface Filme {
    id?: string;
    anoEstreia: number;
    paisDeOrigem: string;
    classificacao: string;
    duracao: number;
    sinopse: string;
    bilheteria: string;
    diretor: entityId;
    estudio: entityId;
    titulo: string;
    capa?: string;
}
export interface entityId{
    id?: number
    nome?: string

}
