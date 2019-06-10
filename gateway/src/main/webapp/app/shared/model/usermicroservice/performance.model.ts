export interface IPerformance {
    id?: number;
    maxCorsaMin?: number;
    maxFlessioni?: number;
    maxAddominali?: number;
}

export class Performance implements IPerformance {
    constructor(public id?: number, public maxCorsaMin?: number, public maxFlessioni?: number, public maxAddominali?: number) {}
}
