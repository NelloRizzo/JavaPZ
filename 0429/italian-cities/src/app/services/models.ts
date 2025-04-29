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

export interface City {
    id: number;
    name: string;
    cadastralCode: string;
    zips?: string[];
    people: number;
    province: Province;
}

export interface ResponseArray<T> {
    data: T[]
}