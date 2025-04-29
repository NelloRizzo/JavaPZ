export interface Province {
    id: number;
    name: string;
    acronym: string;
    region: Region;
}

export interface Region {
    id: number;
    name: string;
    area: Area;
}
export interface Area { 
    id: number;
    name: string;
}

export interface ResponseArray<T> {
    data: T[]
}