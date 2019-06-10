export interface IPlayer {
    id?: number;
    idUser?: number;
    biomedicalDataId?: number;
    performanceId?: number;
}

export class Player implements IPlayer {
    constructor(public id?: number, public idUser?: number, public biomedicalDataId?: number, public performanceId?: number) {}
}
